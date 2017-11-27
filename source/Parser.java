import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
    StreamTokenizer st;

    /**
     * Constructor
     * Input stream is from prompter
     * '-' is read as an ordinary char.
     * EOL is a token
     */
    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.eolIsSignificant(true);
    }

    public Sexpr commands() throws IOException{
        st.nextToken();
        if (st.ttype == st.TT_WORD) {
            switch(st.sval) {
                case "vars":
                    return new Vars();
                case "quit":
                    return new Quit();
            }

        }
        st.pushBack();
        return expression();
    }

    /**
     * Checks if the next token is a '+'/'-'/'='.
     * @return a Sexpr expression. If there is a '+'/'-'/'=', it returns an instance of Addition/Subtraction/Assignment. 
     * Throws exception if the right side expression is incorrect.
     */
    private Sexpr expression() throws IOException{
        Sexpr expr = termMultOrDiv();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-' || st.ttype == '=') {
            if(st.ttype == '+'){
                Sexpr rightTerm = termMultOrDiv();

                if(rightTerm == null) {
                    throw new SyntaxErrorException("Incorrect right side term");
                }else{
                    expr = new Addition(expr, rightTerm);
                }

            }else if(st.ttype == '-'){
                Sexpr rightTerm = termMultOrDiv(); //Instead set rightTerm = unaryOrvariable(); ?

                if(rightTerm == null) {
                    throw new SyntaxErrorException("Incorrect right side term");
                }else{
                    expr = new Subtraction(expr, rightTerm);
                }

            }else {
                Sexpr rightTerm = assignment();

                if(rightTerm == null) {
                    throw new SyntaxErrorException("Incorrect right side term");
                }else{
                    expr = new Assignment(expr, rightTerm);
                }

            }
            st.nextToken();
        }
        st.pushBack();
        return expr;
    }


    /**
     * Checks if the next token is a variable or not.
     * @return a Sexpr expression. If token is a single char, then returns an instance of Variable.
     * Throws exception if the next token is not assigned to a variable.
     */
    private Sexpr assignment() throws IOException {  //how to get left value, read 3 tokens?
        Sexpr rightTerm;
        st.nextToken();
        if(st.ttype == st.TT_WORD) {
            return new Variable(st.sval);
        }
        else {
            throw new SyntaxErrorException("Incorrect assignment, expected variable");
        }
    }


    /**
     * Checks if the following token is a multiplication operator.
     * @return a Sexpr expression. If token is a '*'/'/', it returns a Multiplicaiton/Division Sexpr. 
     * throws exception if right side term, is not a valid expression or number.
     */
    private Sexpr termMultOrDiv() throws IOException{ //needs a better name
        Sexpr expr = factor();
        if(st.nextToken() == '*') {
            st.pushBack();
            while (st.nextToken() == '*'){
                Sexpr factorRight = termMultOrDiv();

                if(factorRight == null) { 
                    throw new SyntaxErrorException("Incorrect right side expression");
                }else{
                    expr = new Multiplication(expr, factorRight);
                }

            }
            st.pushBack();
        } 
        if(st.nextToken() == '/') {
            st.pushBack();
            while (st.nextToken() == '/'){
                Sexpr factorRight = termMultOrDiv();

                if(factorRight == null) {
                    throw new SyntaxErrorException("Incorrect right side expression");
                }else{
                    expr = new Division(expr, factorRight);
                }

            }
            st.pushBack();
        } 
        return expr;
    }

    /**
     * Checks if the following character is the beginning of a number or an expression between paranthesees. 
     * @return a Sexpr expression. 
     * throws exception if paranthesees are not matching. 
     */
    private Sexpr factor() throws IOException{
        Sexpr result;
        if(st.nextToken() != '('){
            st.pushBack();
            result = number();
        } else {
            result = expression();
            if (st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }

    /** 
     * Checks if the next token is a variable or a number.
     * @return a Sexp expression of a Constant or returns a call of variableorUnary()
     * Throws exception if it is neither a word of a number.
     */
    private Sexpr number() throws IOException{

        if(st.nextToken() == st.TT_WORD) {
            st.pushBack();
            return variableOrUnary();
        }
        st.pushBack();

        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }
        return new Constant(st.nval);

    }

    /**
     * Checks if there are matching paranthesees
     * Throws exception if parantheses do not match. 
     * @return the expression between the matching paranthesees.
     */
    private Sexpr checkParanthesees() throws IOException{
        if(st.nextToken() != '('){
            throw new SyntaxErrorException("expected '('");
        }
        Sexpr argument = expression();
        if(st.nextToken() != ')'){
            throw new SyntaxErrorException("expected ')'");
        }
        return argument;
    }

    /**
     * Checks if the a string is variable, or a unary expression
     * Throws exception when: length > 1 && not a Unary expression.
     * @return the variableor Unary expression.
     */
    private Sexpr variableOrUnary() throws IOException{
        if(st.nextToken() != st.TT_WORD && st.sval.length() != 3 && st.sval.length() != 1) { 
            throw new SyntaxErrorException("Expected a variable or unirary expression");
        }
        else if(st.sval.length() == 3) {
            switch(st.sval) {
                case "cos":
                    Sexpr cosArgument = checkParanthesees();
                    return new Cos(cosArgument);
                case "sin":
                    Sexpr sinArgument = checkParanthesees();
                    return new Sin(sinArgument);
                case "exp":
                    Sexpr expArgument = checkParanthesees();
                    return new Exp(expArgument);
                case "log":
                    Sexpr logArgument = checkParanthesees();
                    return new Log(logArgument);
                default:
                    throw new SyntaxErrorException("Unknown Expression");
            }

        } 
        else
            if (st.sval == "-") {
                return new Negation(expression());
            }
        return new Variable(st.sval);
    }



    public class SyntaxErrorException extends RuntimeException{
        public SyntaxErrorException(){
            super();
        }
        public SyntaxErrorException(String msg){
            super(msg);
        }
    }
}

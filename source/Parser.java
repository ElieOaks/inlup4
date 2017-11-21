
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
        st.eolIsSignificant(true);
    }

    /**
     * @return a Sexpr expression. If there is a '+'/'-', it returns a Addition/Subtraction Sexpr. 
     */
    public Sexpr expression() throws IOException{
        Sexpr expression = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-') {
            if(st.ttype == '+'){
                Sexpr termRight = term();
                expression = new Addition(expression, termRight);
            }else{
                Sexpr termRight = term();
                expression = new Subtraction(expression, termRight);
            }
            st.nextToken();
        }
        st.pushBack();
        return expression;
    }

    /**
     * @return a Sexpr expression. If there is a '*', it returns a Multiplicaiton Sexpr. 
     */
    private Sexpr term() throws IOException{
        Sexpr expression = factor();
        while (st.nextToken() == '*'){
            Sexpr factorRight = term();
            expression = new Multiplication(expression, factorRight);
        }
        st.pushBack();
        return expression;
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
        }else{
            result = expression();
            if(st.nextToken() != ')'){
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }

    /**
     * 
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
}

class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(){
        super();
    }
    public SyntaxErrorException(String msg){
        super(msg);
    }
}

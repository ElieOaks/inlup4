
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

    private Sexpr term() throws IOException{
        Sexpr expression = factor();
        while (st.nextToken() == '*'){
            Sexpr factorRight = term();
            expression = new Multiplication(expression, factorRight);
        }
        st.pushBack();
        return expression;
    }

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

    private Sexpr variableOrUnary() throws IOException{
        if(st.nextToken() != st.TT_WORD && st.sval.length() != 3 && st.sval.length() != 1) { 
            throw new SyntaxErrorException("Expected a variable or unirary expression");
        }
        else if(st.sval.length() == 3) {
            switch(st.sval) {
            case "cos":
                if(st.nextToken() != '('){
                    throw new SyntaxErrorException("expected '('");
                }
                Sexpr cosArgument = expression();
                if(st.nextToken() != ')'){
                    throw new SyntaxErrorException("expected ')'");
                }
                return new Cos(cosArgument);
            case "sin":
                if(st.nextToken() != '('){
                    throw new SyntaxErrorException("expected '('");
                }
                Sexpr sinArgument = expression();
                if(st.nextToken() != ')'){
                    throw new SyntaxErrorException("expected ')'");
                }
                return new Sin(sinArgument);
            case "exp":
                if(st.nextToken() != '('){
                    throw new SyntaxErrorException("expected '('");
                }
                Sexpr expArgument = expression();
                if(st.nextToken() != ')'){
                    throw new SyntaxErrorException("expected ')'");
                }
                return new Exp(expArgument);
            case "log":
                if(st.nextToken() != '('){
                    throw new SyntaxErrorException("expected '('");
                }
                Sexpr logArgument = expression();
                if(st.nextToken() != ')'){
                    throw new SyntaxErrorException("expected ')'");
                }
                return new Log(logArgument);
            default:
                throw new SyntaxErrorException("Unknown Expression");
            }
                
        }
        else
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

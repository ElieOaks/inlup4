
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

    public double expression() throws IOException{
        double sum = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-'){
            if(st.ttype == '+'){
                sum += term();
            }else{
                sum -= term();
            }
            st.nextToken();
        }
        st.pushBack();
        return sum;
    }

    private double term() throws IOException{
        double prod = factor();
        while (st.nextToken() == '*'){
            prod *= factor();
        }
        st.pushBack();
        return prod;
    }

    private double factor() throws IOException{
        double result;
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

    private double number() throws IOException{
        
        if(st.nextToken() == st.TT_WORD) {
            st.pushBack();
            variable();
        }
        st.pushBack();

        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }
        return st.nval; //TODO add to tree
    }

    private String variable() throws IOException{
        if(st.nextToken() != st.TT_WORD && st.sval.length() != 3 && st.sval.length() != 1) { 
            throw new SyntaxErrorException("Expected a variable or unirary expression");
        }
        else if(st.sval.length() == 3) {
            switch(st.sval) {
            case "cos":
                expression();
                return st.sval;
            case "sin":
                expression();
                return st.sval;
            case "exp":
                expression();
                return st.sval;
            case "log":
                expression();
                return st.sval;
            default:
                throw new SyntaxErrorException("Expected variable to unirary expression");
            }
                
        }
        else
            return st.sval;
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

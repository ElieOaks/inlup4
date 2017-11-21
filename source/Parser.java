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

    public double expression() throws IOException {
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

    /**
     *
     */
    private double factor() throws IOException {
        double result = unaryFactor();
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
     * Checks if proper Unirary expression
     * @return the read Unirary Expression or throws exception.        
     */
    private double unaryFactor() throws IOException {
        double unrExpr;
        int nTkn = st.nextToken();

        switch(nTkn)
		{
                case "sin":
                {	
                    //TODO: Funktion for sin token, unrExpr = nTkn?
                    break;
                }
                case "cos":
                {	
                    //TODO: Funktion for cos token
                    break;
                }
                case "log":
                {
                    //TODO: Funktion for log token
                    break;
                }
                default: throw new SyntaxErrorException("Not a unary function");
				
                //alt break;
		}
        return unrExpr;
    }

    /**
     * @return a string value, or a numeric value depending on the inputs type.
     * Throws exception if not a numeric value or string value.
     */
    private double number() throws IOException{  //add posibility for variables
        if(st.nextToken() == st.TT_NUMBER)
            {
                return st.nval;
            }
        else if(st.nextToken() == st.TT_WORD)
            {
                return st.sval;
            }
        else
            {
                throw new SyntaxErrorException("Expected number or variable");
            }
    

        throw new SyntaxErrorException("Expected number");
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

import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
    StreamTokenizer st;

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
        double result = unaryFactor();
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

	private double unaryFactor() throws IOException
	{
		double unrExpr;
		double nTkn = st.nextToken()

		switch(nTkn)
		{
			case "sin";
			{	
				//TODO: Funktion för sin token, unrExpr = nTkn?
				return true;
			}
			case "cos";
			{	
				//TODO: Funktion för cos token
				return true;
			}
			case "log";
			{
				//TODO: Funktion för log token
				return true;
			}
			default: throw new SyntaxErrorException("Not a unary function");
				
			//alt break;
		}
		return unrExpr;
	}


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
    }

	throw new SyntaxErrorException("Expected number");
}

class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(){
        super();
    }
    public SyntaxErrorException(String msg){
        super(msg);
    }
}

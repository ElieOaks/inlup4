import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
    StreamTokenizer st;


    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
    }



    private Sexpr parenthesisCheck() throws IOException{
        if(st.nextToken() != '('){
            throw new SyntaxErrorException("Expected '('");
        }
        Sexpr expr = expression();
        if(st.nextToken() != ')'){
            throw new SyntaxErrorException("Expected ')'");
        }
        return argument;
    }

	public Sexpr expression() throws IOException{
        Sexpr expr = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-') {
            if(st.ttype == '+'){
                //set expr to new instance of subtraction 
            }else{
                //set expr to new instance of subtraction
            }
            st.nextToken();
        }
        st.pushBack();
        return expression;
    }


    private Sexpr term() throws IOException{
        Sexpr expr = factor();
        while (st.nextToken() == '*'){
            Sexpr factorRight = term();  //??? Implementation by Joy
            //set expr to new instance of Multiplication 
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

 
    private Sexpr number() throws IOException{  //Expr can also begin with unar, therefor unarOrVar is needed
        
        if(st.nextToken() == st.TT_WORD) {
            st.pushBack();
            return unarOrVar();  
        }
        st.pushBack();

        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }
        //return a new instance of Number;
       
    }



    private Sexpr unarOrVar() throws IOException{
        if(st.nextToken() != st.TT_WORD && st.sval.length() != 3 && st.sval.length() != 1) { 
            throw new SyntaxErrorException("Expected a variable or unirary expression");
        }
        else if(st.ttype.length() == 3) {
            switch(st.ttype) {
            case "sin":
			{
                Sexpr strSin = parenthesisCheck();
                //return a instance of Sinus
				break;
			}
            case "cos":
			{
                Sexpr strCos = parenthesisCheck();
                //return a instance of Cosinus
				break;
			}
            case "log":
			{	
                Sexpr strLog = parenthesisCheck();
                //returns a instance of Logarithm
				break;
			}
			case "not":
			{
				Sexpr strNot = parenthesisCheck();  //do negations actually need to check parenthesis though?
				//return a new instance of negation
				break;
			}
            default:
                throw new SyntaxErrorException("Incorrect expression");
            }
                
        }
        else
        {
        	//return a instance of variable, as the input is not a unar expr
		}
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

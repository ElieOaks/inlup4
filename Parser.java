import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
    StreamTokenizer st;

    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
    }

    public double expression() throws IOException{ //Should return a Sexpr?
        double sum = termOrQuotation();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-'){
            if(st.ttype == '+'){
                sum += termOrQuotation(); //TODO: Should instead create an instance of Addition.
            }else{
                sum -= termOrQuotation(); //TODO: Should instead create an instance of Division.
            }
            st.nextToken();
        }
        st.pushBack();
        return sum;
    }

    private double termOrQuotation() throws IOException{ //Should return a Sexpr?
        double prod = factor();  //TODO:Change prod to something not fkin stupid
        while (st.nextToken() == '*' || st.nextToken() == '/'){
            if (st.ttype == '*')
            {
               // prod *= factor();
               // shouldn't eval, simply creates new instances of the correct class (multiplication class)
               // Multiplication newMult = new Multiplication()
            }
            else if (st.ttype == '/')
            {
               // prod /= factor();
               // shouldn't eval, simply creates new instances of the correct class (multiplication class)
               // Division newDiv = new Division()
            }
        }
        st.pushBack();
        return prod;
    }

    private double factor() throws IOException{  //TODO: Expects only a num or var atm. Should return a Sexpr?
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

    private void unaryFactor() throws IOException //Expected return value is now void instead of double
    {
        double nTkn = st.nextToken(); //Incorrect, need to wrap the token somehow.
        double Expr;    

        switch(nTkn)  //TODO: Add cases for the rest of the unarExpr.
        {
            case "sin":
            {	
                //Sinus newSin = new Sinus();
                break;
            }
            case "cos":
            {	
                //Cosinus newCos = new Cosinus();
                break;
            }
            case "log": 
            {
                //Logarithm newLog = new Logarithm();
                break;
            }
            case "Negation":
            {
                //Negation newNeg = new Negation();
                break;
            }
            default: throw new SyntaxErrorException("Not a unary function");
        }
        if (st.nextToken() != '(') { //A unary Expr always expects a parenthesis with expr in it.
            throw new SyntaxErrorException("Expected '('");
        }
        else {
            Expr = expression();
            if(st.nextToken() != ')') {
                throw new SyntaxErrorException("Expected ')'");
            }
        }
        //Not sure if a return is needed yet
    }


    private void number() throws IOException{  //Now returns void instead of double
        if(st.nextToken() == st.TT_NUMBER)
	{
            //Number newNum = new Number();
            //return st.nval; Old code
        }
        else if(st.nextToken() == st.TT_WORD) //in case token is a singel char
        {
            //Variable newVar = new Variable();
            //return st.sval;
        }
        else
        {
            throw new SyntaxErrorException("Expected number or variable");
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

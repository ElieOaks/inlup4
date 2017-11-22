public class Negation extends Unary {

    //Attributes
    int prio = 1;

    //Constructor
    public Negation(Sexpr argument) {
        super(argument, "-");       
    }    

    //Methods
     public double getValue() { //FIXME lite defensiv programmering. 
         return 0-(this.getArgument().getValue());
    }
      
    
    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Negation(this.getArgument().eval());
        }
    }

    
}

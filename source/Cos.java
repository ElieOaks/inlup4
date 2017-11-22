public class Cos extends Unary {

    //Attributes
    int prio = 3; 

    //Constructor
    public Cos(Sexpr argument) {
        super(argument, "cos");
        
    }    

    //Methods
    public double getValue() { //FIXME lite defensiv programmering. 
        return Math.cos(this.getArgument().getValue());
    }
      
    
    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Cos(this.getArgument().eval());
        }
    }
}


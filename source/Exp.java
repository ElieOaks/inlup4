public class Exp extends Unary {
    int prio = 3;

    //Constructor
    public Exp(Sexpr argument) {
        super(argument, "exp");
        
    }

    //Methods

     public double getValue() { //FIXME lite defensiv programmering. 
         return Math.exp(this.getArgument().getValue());
    }
      

    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Exp(this.getArgument().eval());
        }
    }

}


public class Cos extends Unary {

    //Attributes
    int prio = 3; 

    //Constructor
    public Cos(Sexpr argument) {
        super(argument, "cos");
        
    }    

    //Methods
    public boolean isConstant() {
        return false;
    }

    public Sexpr eval() {
        return new Constant(cos(this.getArgument().eval()));
    }
}

public class Sin extends Unary {

    //Attributes
    String sign;

    //Constructor
    public Sin(Sexpr argument) {
        super(argument, "sin");
        this.sign = "Sin(" + argument.toString() + ")";
        
    }    

    //Methods
    public Sexpr eval() {
        return new Constant(sin(this.getArgument().eval()));
    }
}

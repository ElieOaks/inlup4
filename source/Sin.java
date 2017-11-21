public class Sin extends Unary {

    //Attributes
    String sign;

    //Constructor
    public Sin(Sexpr argument) {
        super(argument, "sin");
        this.sign = "Sin(" + argument.toString() + ")";
        
    }    

    //Methods

    public boolean isConstant() {
        return false;
    }
}

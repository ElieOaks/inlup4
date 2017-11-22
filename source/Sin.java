public class Sin extends Unary {

    //Attributes
    String sign;

    //Constructor
    public Sin(Sexpr argument) {
        super(argument, "sin");
        this.sign = "Sin(" + argument.toString() + ")";
        
    }
     public double getValue() { //FIXME lite defensiv programmering. 
         return Math.sin(this.getArgument().getValue());
    }
      

    //Methods
    public Sexpr eval() {
        if (this.isConstant())
            return new Constant(this.getValue());
        else {
            return new Sin(this.getArgument().eval());
        }
    }
}

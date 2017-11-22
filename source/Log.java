public class Log extends Unary {

    //Attributes
    int prio = 3;

    //Constructor
    public Log(Sexpr argument) {
        super(argument, "log");
        
    }    

    //Methods

     public double getValue() { //FIXME lite defensiv programmering. 
         return Math.log(this.getArgument().getValue());
    }
      
   public Sexpr eval() {
       if (this.isConstant()) {
           return new Constant(this.getValue());
        }
        else {
            return new Log(this.getArgument().eval());
        }
    }
}

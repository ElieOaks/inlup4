public class Log extends Unary {

    //Attributes
    int prio = 3;

    //Constructor
    public Log(Sexpr argument) {
        super(argument, "log");
        
    }    

    //Methods
    public Sexpr eval() {
        return new Constant(log(this.getArgument().eval()));
    }
}

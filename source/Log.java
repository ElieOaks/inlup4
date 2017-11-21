public class Log extends Unary {

    //Attributes
    int prio = 3;

    //Constructor
    public Log(Sexpr argument) {
        super(argument, "log");
        
    }    

    //Methods
    public boolean isConstant() {
        return false;
    }
}

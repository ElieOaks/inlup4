public class Negation extends Unary {

    //Attributes
    int prio = 1;

    //Constructor
    public Negation(Sexpr argument) {
        super(argument, "-");       
    }    

    //Methods

    public boolean isConstant() {
        return false;
    }
}

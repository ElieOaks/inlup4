public class Multiplication extends Binary{

    //Attributes
    int prio = 2;

    //Constructor
    public Multiplication(Sexpr left, Sexpr right) {
        super(left, right, " * ");
        
    }


    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }
    
}

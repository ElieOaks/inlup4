public class Subtraction extends Binary{

    //Attributes
    String sign = "-";
    int prio = 1;


    //Constructor
    public Subtraction(Sexpr left, Sexpr right) {
        super(left, right);
        
    }
    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }
    
}


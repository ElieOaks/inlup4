public class Subtraction extends Binary{

    //Attributes
    int prio = 1;


    //Constructor
    public Subtraction(Sexpr left, Sexpr right) {
        super(left, right, " - ");
        
    }
    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }

    public String toString() {
        return "(" + this.getLeft().toString() + " - " + this.getRight().toString() + ")";
    }
    
}


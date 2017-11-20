public class Addition extends Binary{

    //Attributes
    int prio = 1;

    //Constructor
    public Addition(Sexpr left, Sexpr right) {
        super(left, right, " + ");
        
    }

    //Methods
    /**
     * Check if addition is a constant.
     * Always returns false.
     */
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }

    public String toString() {
        return  "(" + this.getLeft().toString() +" + "+ this.getRight().toString() + ")";
    }
    
}

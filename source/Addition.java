public class Addition extends Binary{

    //Attributes
    String sign = "+";
    int prio = 1;

    //Constructor
    public Addition(Sexpr left, Sexpr right) {
        super(left, right);
        
    }

    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }

    public String toString() {
        return this.getLeft().toString() + "+" + this.getRight().toString();
    }
    
}

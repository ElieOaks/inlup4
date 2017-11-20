public class Division extends Binary{

    //Attributes
    int prio = 2;

    //Constructor
    public Division(Sexpr left, Sexpr right) {
        super(left, right, "/");
        
    }

    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }

    public String toString() {
        return "(" + this.getLeft().toString() + " / " + this.getRight().toString() + ")";
    }
    
}

public class Division extends Binary{

    //Attributes
    int prio = 2;

    //Constructor
    public Division(Sexpr left, Sexpr right) {
        super(left, right, "/");
        
    }

    //Methods
    
    public int priority() {
        return this.prio;
    }

    public String toString() {
        return "(" + this.getLeft().toString() + " / " + this.getRight().toString() + ")";
    }

    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getLeft().eval()/this.getRight().eval());
        }
        else {
            return new Division(this.getLeft().eval(), this.getRight().eval());
        }
            
    }
    
}

public class Addition extends Binary{

    //Attributes
    int prio = 1;

    //Constructor
    public Addition(Sexpr left, Sexpr right) {
        super(left, right, " + ");
        
    }

    //Methods
    public int priority() {
        return this.prio;
    }

    public Sexpr eval() {
        return new Constant(this.getLeft().eval() + this.getRight().eval());
    }

    
}

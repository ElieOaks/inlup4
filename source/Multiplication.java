public class Multiplication extends Binary{

    //Attributes
    int prio = 2;

    //Constructor
    public Multiplication(Sexpr left, Sexpr right) {
        super(left, right, " * ");
        
    }


    //Methods
    public Sexpr eval() {
        return new Constant(this.getLeft().eval() * this.getRight().eval());
    }

    public int priority() {
        return this.prio;
    }
    
}

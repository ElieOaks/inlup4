public class Subtraction extends Binary{

    //Attributes
    int prio = 1;


    //Constructor
    public Subtraction(Sexpr left, Sexpr right) {
        super(left, right, " - ");
        
    }
    //Methods
    public int priority() {
        return this.prio;
    }

    public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue() - this.getRight().getValue();
    }
        
    public Sexpr eval() {
        if (this.isConstant())
            return new Constant(this.getValue());
        else {
            return new Subtraction(this.getLeft().eval(), this.getRight().eval());
        }
    }

    public String toString() {
        return "(" + this.getLeft().toString() + " - " + this.getRight().toString() + ")";
    }
    
}


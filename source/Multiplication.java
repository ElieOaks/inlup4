public class Multiplication extends Binary{

    //Attributes
    int prio = 2;

    //Constructor
    public Multiplication(Sexpr left, Sexpr right) {
        super(left, right, " * ");
        
    }


    //Methods
    public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue()*this.getRight().getValue();
    }
      
    
    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Multiplication(this.getLeft().eval(),this.getRight().eval());   
        }
    }

    public int priority() {
        return this.prio;
    }
    
}


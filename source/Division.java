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

     public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue()/this.getRight().getValue();
    }
      

    public Sexpr eval() {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Division(this.getLeft().eval(), this.getRight().eval());
        }
            
    }
    
}

public class Assignment extends Binary{

    //Attributes
    int prio = 1;

    //Constructor
    public Assignment(Sexpr left, Sexpr right) { //TODO - conditions for assignment. Not 4 = 6. 
        super(left, right, " = ");
    }

    //Methods
    public int priority() {
        return this.prio;
    }

     public double getValue() { //FIXME lite defensiv programmering.+ special för denna
         return this.getLeft().getValue();
    }

    public boolean isConstant() { //FIXME
        return false;
    }
      

    public Sexpr eval() {   //FIXME?     
        return new Assignment(this.getLeft().eval(), this.getRight());       
         
    }
    
}

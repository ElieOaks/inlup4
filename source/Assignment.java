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

    public Sexpr eval() {
        return new Assignment(this.getLeft().eval(), this.getRight()) ;
    }
    
}

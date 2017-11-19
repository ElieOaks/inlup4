public class Assignment extends Binary{

    //Attributes
    String sign = "=";
    int prio = 1;

    //Constructor
    public Assignment(Sexpr left, Sexpr right) { //TODO - conditions for assignment. Not 4 = 6. 
        super(left, right);
    }

    //Methods
    public boolean isConstant() {
        return false;
    }

    public int priority() {
        return this.prio;
    }
    
}

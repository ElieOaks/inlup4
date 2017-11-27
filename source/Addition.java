import java.util.*;

public class Addition extends Binary{

    //Attributes
    String name = " + ";
    int prio = 1;

    //Constructor
    public Addition(Sexpr left, Sexpr right) {
        super(left, right);  
    }

    //Methods
    /**
     * @return the priority of Addition, which is 1
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return the sign of addition, which is '+'
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the evaluated Sexpr expression. 
     */
    public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue() + this.getRight().getValue();
    }
      
    /**
     * @return the most evaluated version of the Sexpr expression.
     * @param map is the HashMap that contains all the variables and assignment.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {

        return Symbolic.addition(this.getLeft().eval(map), this.getRight().eval(map));          
    }    
}

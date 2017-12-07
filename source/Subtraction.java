
package mathematix;
import java.util.*;
public class Subtraction extends Binary{

    //Attributes
    int prio = 1;
    String name = " - ";


    //Constructor
    public Subtraction(Sexpr left, Sexpr right) {
        super(left, right);
        
    }
    //Methods
    /**
     * @return the priority of Subtraction, which is 1.
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return '-'
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the evaluated constant.
     */
    public double getValue() {
        return this.getLeft().getValue() - this.getRight().getValue();
    }
        
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.subtraction(this.getLeft().eval(map), this.getRight().eval(map));
    }
    
}


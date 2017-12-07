
package mathematix;
import java.util.*;

public class Negation extends Unary {

    //Attributes
    int prio = 1;

    //Constructor
    public Negation(Sexpr argument) {
        super(argument, "-");       
    }    

    //Methods
    /**
     * @return the Constant of the exaluated Sexpr expression.
     */
     public double getValue() { //FIXME lite defensiv programmering. 
         return -this.getArgument().getValue();
    }

    /**
     * @return the most evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.negation(this.getArgument().eval(map));
    }

    /**
     * @return the priority of Negation, which is 0.
     */
    public int priority() {
        return 0;
    }

    
}

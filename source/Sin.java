
package mathematix;
import java.util.*;
public class Sin extends Unary {

    //Attributes
    String sign;
    int prio = 3;

    //Constructor
    public Sin(Sexpr argument) {
        super(argument, "sin");
        this.sign = "Sin(" + argument.toString() + ")";
        
    }

    /**
     * @return a constant, sin of the evaluated argument 
     */
     public double getValue() { 
         return Math.sin(this.getArgument().getValue());
    }
      

    //Methods
    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.sin(this.getArgument().eval(map));
    }

    /**
     * @return the priority of Sin, whih is 5.
     */
    public int priority() {
        return this.prio;
    }
}

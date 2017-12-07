
package mathematix;
import java.util.*;
public class Exp extends Unary {
    int prio = 3;

    //Constructor
    public Exp(Sexpr argument) {
        super(argument, "exp");
        
    }

    //Methods

    /**
     * @return the constant of the Sexor expression evaluated.
     */
     public double getValue() { //FIXME lite defensiv programmering. 
         return Math.exp(this.getArgument().getValue());
    }
      

    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.exp(this.getArgument().eval(map));
    }

    /**
     *@ return the priority of Exp, which is 3.
     */
    public int priority() {
        return this.prio;
    }

}


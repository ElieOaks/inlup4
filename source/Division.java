
package mathematix;
import java.util.*;
public class Division extends Binary{

    //Attributes
    int prio = 2;
    String name = " / ";

    //Constructor
    public Division(Sexpr left, Sexpr right) {
        super(left, right);
        
    }

    //Methods
    /**
     *@ return the priority of Division, which is 2.
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return the sign for Division, which is /.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the constant of the Sexor expression evaluated.
     */
    public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue()/this.getRight().getValue();
    }
      
    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.division(this.getLeft().eval(map), this.getRight().eval(map));
            
    }
    
}


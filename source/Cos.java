import java.util.*;

public class Cos extends Unary {

    //Attributes
    int prio = 3; 

    //Constructor
    public Cos(Sexpr argument) {
        super(argument, "cos");
        
    }    

    //Methods
    /**
       return the cos of the evaluated argument. 
     */
    public double getValue() { //FIXME lite defensiv programmering. 
        return Math.cos(this.getArgument().getValue());
    }

    /**
     * @return the priority of cos, which is 3.
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.sin(this.getArgument().eval(map));
    }
}

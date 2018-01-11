

import java.util.*;
public class Log extends Unary {

    //Attributes
    int prio = 3;

    //Constructor
    public Log(Sexpr argument) {
        super(argument, "log");
        
    }    

    //Methods

    /**
     * @return the constant of the Sexor expression evaluated.
     */
    public double getValue() { //FIXME lite defensiv programmering. 
        return Math.log(this.getArgument().getValue());
    }

    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return Symbolic.log(this.getArgument().eval(map));
    }

    /**
     *@ return the priority of Log, which is 3.
     */
    public int priority() {
        return this.prio;
    }
}

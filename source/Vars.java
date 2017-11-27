import java.util.*;
public class Vars extends Command {

    int prio = 5;

    public boolean isConstant() {
        return true;
    }

    public Sexpr eval(HashMap<String,Sexpr> map) {
        return new Constant(0); //FIXME
    }

    public double getValue() { //FIXME
        return 0;
    }

     public boolean isQuit() {
        return false;
    }

    /**
     * @return the priority of Sin, whih is 5.
     */
    public int priority() {
        return this.prio;
    }

}

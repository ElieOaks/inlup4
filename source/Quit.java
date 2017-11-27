import java.util.*;
public class Quit extends Command {

    String sign = "Thank you for using this Signulator!";
    int prio = 4;

    /**
     * @return false, as Quit is never a constant (a double), exists to fulfill Sexpr requirements.
     */
    public boolean isConstant() {
        return false;
    }

    public boolean isQuit() {
        return true;
    }

    public double getValue() { //Fixme?
        return 0;
    }

    public Sexpr eval(HashMap<String,Sexpr> map) {
        return this;
    }

    /**
     * @return the priority of Quit, to fulfil Sexpr abstract requrements. 
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return a goodbye greeting, which is an attribute of Quit.
     */
    public String toString(){
        return this.sign;
    }
}

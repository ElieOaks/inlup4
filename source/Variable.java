import java.util.*;
public class Variable extends Atom {

    String identity;
    int prio = 4;

    public Variable(String identity) { //ToDO - does this already exist?
        this.identity = identity;
    }

    /**
     * @return false, as a variable is never constant.
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * @return adds the variable to the map, if it is new.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        String character = this.toString();
        if (map.containsKey(character)){
            Sexpr val = map.get(character);
            map.remove(character);
            map.put(character, val);
            if (val != null) return val;
        }
        else {
            map.put(character, null);
            
        }
        return this;
    }

    /**
     * //FIXME
     */
    public double getValue() { //FIXME
        return 0;
    }

    public String toString() {
        return identity;
    }

    /**
     * @return the priority of Variable, whih is 4.
     */
    public int priority() {
        return this.prio;
    }
}


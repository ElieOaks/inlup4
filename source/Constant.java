
import java.util.*;

public class Constant extends Atom {

    public double constant;

    public Constant(final double constant) {
        this.constant = constant;
    }

    /**
     *@return the constant number, as a string.
     */
    public String toString() {
        return Double.toString(this.constant);
    }

    /**
     * reutnr true, as a constant always is constant.
     */
    public boolean isConstant() {
        return true;
    }

    /**
     * @return the value of the constant as double.
     */
     public double getValue() {
        return this.constant;
    }
      
    /**
     * @return the Constant.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        return this;
    }

    public int priority() {
        return 4;
    }

}

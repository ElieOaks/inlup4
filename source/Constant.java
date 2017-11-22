import java.math.*;

public class Constant extends Atom {
    public double constant;

    public Constant(final double constant) {
        this.constant = constant;
    }

    public String toString() {
        return Double.toString(this.constant);
    }

    public boolean isConstant() {
        return true;
    }

     public double getValue() { //FIXME lite defensiv programmering. 
        return this.constant;
    }
      

    public Sexpr eval() {
        return this;
    }

}

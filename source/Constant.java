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

    public Sexpr eval() {
        return this.constant;
    }

}

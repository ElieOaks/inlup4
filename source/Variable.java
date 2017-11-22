public class Variable extends Atom {
    String identity;

    public Variable(String identity) { //ToDO - does this already exist?
        this.identity = identity;
    }

    public boolean isConstant() {
        return false;
    }

    public Sexpr eval() {
        return this;
    }

    public double getValue() { //FIXME
        return 0;
    }

    public String toString() {
        return identity;
    }
}

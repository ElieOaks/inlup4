public class Variable extends Atom {
    String identity;

    public Variable(String identity) { //ToDO - does this already exist?
        this.identity = identity;
    }

    public boolean isConstant() {
        return true;
    }

    public String toString() {
        return identity;
    }
}

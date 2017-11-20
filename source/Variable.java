public class Variable extends Atom {
    String identity;

    public Variable(String identity) { //ToDO - does this already exist?
        this.identity = "" + identity.charAt(0);
    }

    public boolean isConstant() {
        return true;
    }
}

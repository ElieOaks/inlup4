public class Quit extends Command {

    String sign = "Thank you for using this Signulator!";

    public boolean isConstant() {
        return false;
    }

    public boolean isQuit() {
        return true;
    }

    public double getValue() { //Fixme?
        return 0;
    }

    public Sexpr eval() {
        return this;
    }
}

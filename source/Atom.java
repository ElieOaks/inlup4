abstract class Atom extends Sexpr {

    public boolean isQuit() {
        return false;
    }

    public boolean isVars() {
        return false;
    }
}

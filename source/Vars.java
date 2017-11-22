public class Vars extends Command {


    public boolean isConstant() {
        return true;
    }

    public Sexpr eval() {
        return new Constant(0); //FIXME
    }

    public double getValue() { //FIXME
        return 0;
    }
}

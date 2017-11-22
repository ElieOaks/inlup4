abstract class Sexpr {
    //abstract String getName();
    //abstract double getValue();
    //abstract int priority();
    abstract boolean isConstant();
    abstract Sexpr eval(Sexpr map);
}

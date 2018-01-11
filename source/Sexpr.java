import java.util.*;

public abstract class Sexpr {
    //abstract String getName();
    abstract boolean isQuit();
    abstract boolean isVars();
    abstract double getValue();
    abstract int priority();
    abstract boolean isConstant();
    abstract Sexpr eval(HashMap<String,Sexpr> map);
}

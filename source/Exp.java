public class Exp extends Unary {
    int prio = 3;

    //Constructor
    public Exp(Sexpr argument) {
        super(argument, "exp");
        
    }

    public Sexpr eval() {
        return new Constant(exp(this.getArgument().eval());
    }

}

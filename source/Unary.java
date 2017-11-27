abstract class Unary extends Sexpr {
    private Sexpr argument;
    private String sign;

    //Constructor
    public Unary(Sexpr argument, String sign) {
        this.argument = argument;
        this.sign = sign;
    }

    //Abstract Methods
    //abstract String toString();

    //Method
    public Sexpr getArgument() {
        return this.argument;
    }
    
    public String toString() {
        return this.sign + "(" + this.argument + ")";
    }

    public boolean isConstant() {
        return this.argument.isConstant();
    }

     public boolean isQuit() {
        return false;
    }
    
}

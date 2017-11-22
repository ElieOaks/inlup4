abstract class Binary extends Sexpr{
    //Attributes
    private Sexpr left;
    private Sexpr right;
    private String sign;
    
    //Constructor
    public Binary(Sexpr left, Sexpr right, String sign) {
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    //Abstract Methods
    //abstract String toString();

    //Methods
    public Sexpr getLeft() {
        return this.left;
    }

    public Sexpr getRight() {
        return this.right;
    }

    public boolean isConstant() {
        return this.left.isConstant() || this.right.isConstant();
    }

    public String toString() { //TODO: Switch cases based on priority
        return "(" + this.left.toString() + this.sign + this.right.toString() + ")";
    }
}

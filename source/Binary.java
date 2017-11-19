abstract class Binary extends Sexpr{
    //Attributes
    private Sexpr left;
    private Sexpr right;
    
    //Constructor
    public Binary(Sexpr left, Sexpr right) {
        this.left = left;
        this.right = right;
    }

    //Methods
    public Sexpr getLeft() {
        return this.left;
    }

    public Sexpr getRight() {
        return this.right;
    }
}

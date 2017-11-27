abstract class Binary extends Sexpr{
    //Attributes
    private Sexpr left;
    private Sexpr right;
    
    //Constructor
    public Binary(Sexpr left, Sexpr right) {
        this.left = left;
        this.right = right;
    }

    //Abstract Methods
    abstract String getName();

    //Methods

    public boolean isQuit() {
        return false;
    }
    
    /**
       return the left Sexpr argument. 
     */
    public Sexpr getLeft() {
        return this.left;
    }

    /**
       return the right Sexpr argument. 
     */
    public Sexpr getRight() {
        return this.right;
    }

    /**
     * @return true if both arguments are constant. Otherwise false. 
     */
    public boolean isConstant() {
        return this.left.isConstant() || this.right.isConstant();
    }

    /**
     * @return the string of the Sexpr. 
     * Only uses paranthsees arount an argument if its priority is lower than this. 
     */
    public String toString() {
        String left = this.left.toString();
        String right = this.right.toString();
        if (this.left.priority() < this.priority()) {
            left = "(" + left + ")";
        }
        if (this.right.priority() < this.priority()) {
            left = "(" + right + ")";
        }
        return left + this.getName() + right ;
    }
}

public class Symbolic{
    /**
     * Checks if both args are Constants. 
     * @return an instance of Constant if left && right are constants, else returns an instance of Addition.
     */
    static Sexpr addition(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() + right.getValue());
        }
        else {
            return new Addition(left, right);
        }
        
    }
    
    /**
     * Checks if both args are constants.
     * @return an instance of Constant if left && right are constants, else returns an instance of subtraction.
     */ 
    static Sexpr subtraction(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() - right.getValue());
        }
        else {
            return new Subtraction(left, right);
        }
        
    }

    /**
     * Checks if left && right are constants.
     * @return an instance of constant if left && right are constants, else returns an instance of Division.
     */
    static Sexpr division(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() / right.getValue());
        }
        else {
            return new Division(left, right);
        }
        
    }
    
    /**
     * Checks if both args are constants. 
     * @return an instance of constant if left && right are constants, else returns an instance of Multiplication. 
     */
    static Sexpr multiplication(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() * right.getValue());
        }
        else {
            return new Multiplication(left, right);
        }
    }
    
    /**
     * Evaluates the left term of an assignment as the right term is always a variable.
     * @return the left argument.
     */
    static Sexpr assignment(Sexpr left, Sexpr right){
        return left;
        
    }

    /**
     * Checks if the argument is a constant.
     * @return an instance of constant if argument is a constant, else returns an instance Cos.
     */
    static Sexpr cos(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.cos(argument.getValue()));
        }
        else {
            return new Cos(argument);
        }
    }
    
    /**
     * Checks if the argument is a constant.
     * @return an instance of constant if argument is a constant, else returns an instance Sin.
     */
    static Sexpr sin(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.sin(argument.getValue()));
        }
        else {
            return new Sin(argument);
        }
    }
    
    /**
     * Checks if the argument is a constant.
     * @return an instance of constant if argument is a constant, else returns an instance Exp.
     */
    static Sexpr exp(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.exp(argument.getValue()));
        }
        else {
            return new Exp(argument);
        }
    }


    /**
     * Checks if the argument is a constant.
     * @return an instance of constant if argument is a constant, else returns an instance Log.
     */
    static Sexpr log(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.log(argument.getValue()));
        }
        else {
            return new Log(argument);
        }
    }


    /**
     * Checks if the argument is a constant.
     * @return an instance of constant if argument is a constant, else returns an instance Negation.
     */
    static Sexpr negation(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(-(argument.getValue()));
        }
        else {
            return new Negation(argument);
        }
    }
    
}

public class Symbolic{

    static Sexpr addition(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() + right.getValue());
        }
        else {
            return new Addition(left, right);
        }
        
    }

    static Sexpr subtraction(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() - right.getValue());
        }
        else {
            return new Subtraction(left, right);
        }
        
    }


    static Sexpr division(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() / right.getValue());
        }
        else {
            return new Division(left, right);
        }
        
    }

    static Sexpr multiplication(Sexpr left, Sexpr right){
        if (left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() * right.getValue());
        }
        else {
            return new Multiplication(left, right);
        }
        
    }

    static Sexpr assignment(Sexpr left, Sexpr right){
        return left;
        
    }

}

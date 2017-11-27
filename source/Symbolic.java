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

    
    static Sexpr cos(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.cos(argument.getValue()));
        }
        else {
            return new Cos(argument);
        }
    }

     static Sexpr sin(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.sin(argument.getValue()));
        }
        else {
            return new Sin(argument);
        }
    }

    static Sexpr exp(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.exp(argument.getValue()));
        }
        else {
            return new Exp(argument);
        }
    }

    static Sexpr log(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(Math.log(argument.getValue()));
        }
        else {
            return new Log(argument);
        }
    }

    static Sexpr negation(Sexpr argument) {
        if (argument.isConstant()) {
            return new Constant(-(argument.getValue()));
        }
        else {
            return new Negation(argument);
        }
    }
    
}

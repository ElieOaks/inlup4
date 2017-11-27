public class Symbolic{

    static Sexpr Addition(Sexpr arg1, Sexpr arg2){
         if (arg1.isConstant() && arg2.isConstant()) {
            return new Constant(arg1.getValue() + arg2.getValue());
        }
        else {
            return new Addition(arg1, arg2);
        }
        
    }

static Sexpr Subtraction(Sexpr arg1, Sexpr arg2){
         if (arg1.isConstant() && arg2.isConstant()) {
            return new Constant(arg1.getValue() - arg2.getValue());
        }
        else {
            return new Subtraction(arg1, arg2);
        }
        
    }


static Sexpr Division(Sexpr arg1, Sexpr arg2){
         if (arg1.isConstant() && arg2.isConstant()) {
            return new Constant(arg1.getValue() / arg2.getValue());
        }
        else {
            return new Division(arg1, arg2);
        }
        
    }

static Sexpr Multiplication(Sexpr arg1, Sexpr arg2){
         if (arg1.isConstant() && arg2.isConstant()) {
            return new Constant(arg1.getValue() * arg2.getValue());
        }
        else {
            return new Multiplication(arg1, arg2);
        }
        
    }

static Sexpr Assignment(Sexpr arg1, Sexpr arg2){
         if (arg1.isConstant()) {
            return new Assignment(arg1, arg2);
        }
        else {
            return arg1;
        }
        
    }

}

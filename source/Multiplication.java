import java.util.*;
public class Multiplication extends Binary{

    //Attributes
    String name = " * ";
        int prio = 2;

    //Constructor
    public Multiplication(Sexpr left, Sexpr right) {
        super(left, right);
        
    }


    //Methods
    /**
     * @return the constant of the Sexor expression evaluated.
     */
    public double getValue() { //FIXME lite defensiv programmering. 
        return this.getLeft().getValue()*this.getRight().getValue();
    }

    /**
     * @return the sign for multiplication, whoch is '*'
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the evaluated Sexpr expression.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        if (this.isConstant()) {
            return new Constant(this.getValue());
        }
        else {
            return new Multiplication(this.getLeft().eval(map),this.getRight().eval(map));   
        }
    }

    /**
     *@ return the priority of multiplication, which is 2.
     */
    public int priority() {
        return this.prio;
    }
    
}

import java.util.*;

public class Assignment extends Binary{

    //Attributes
    int prio = 0;
    String name = " = ";

    //Constructor
    public Assignment(Sexpr left, Sexpr right) {
        super(left, right);
    }

    //Methods
    /**
     * @return Assignments priority, which is 0.
     */
    public int priority() {
        return this.prio;
    }

    /**
     * @return the evaluated constant value of thr Sexpr expression to the left of the assignment.
     */
     public double getValue() {
         return this.getLeft().getValue();
    }

    /**
       @return +
     */
    public String getName() {
        return this.name;
    }

    /**
       @return true, if the Left side can be evaluated to a constant, otherwise false.
     */
    public boolean isConstant() {
        return false;
    }
    
      
    /**
     * @return an Assignment Sexpr, where the left side is as evaluated as possible. 
     * @param map, a Hashmap of all variables and assignments.
     * Adds the assignment to map, or changes the value of a variabel is already part of the map.
     */
    public Sexpr eval(HashMap<String,Sexpr> map) {
        Sexpr assign = Symbolic.assignment(this.getLeft().eval(map), this.getRight());
        String character = this.getRight().toString();
        if (map.containsKey(character)){
            map.remove(character);            
        }
        map.put(this.getRight().toString(), this.getLeft().eval(map));
        return assign;
         
    }
    
}

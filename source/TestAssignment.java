import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestAssignment{
    public Constant arg1 = new Constant(3);
    public Variable arg2 = new Variable("b");
    public Assignment num = new Assignment(arg1, arg2);
    public double exact = 0.0001;
    public HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();

    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("3.0 = b", adi);
    }

    @Test
    public void testPriority() {
        assertEquals(num.priority(), 0);
    }

    @Test
    public void testGetValue() {
        assertEquals(num.getValue(), 3, exact);
    }

    @Test
    public void testEval() {
        assertEquals((new Constant(3)).toString(), num.eval(map).toString());
    }

    @Test
    public void testGetName() {
        assertEquals(num.getName(), " = ");
    }
    
}

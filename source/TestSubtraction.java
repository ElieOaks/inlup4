import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestSubtraction implements TestInterface{
    public Constant arg1 = new Constant(3);
    public Constant arg2 = new Constant(2);
    public Subtraction num = new Subtraction(arg1, arg2);
    public double exact = 0.001;
    public HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();

    
    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("3.0 - 2.0", adi);
    }

    @Test
    public void testPriority() {
        assertEquals(num.priority(), 1);
    }

    @Test
    public void testGetValue() {
        assertEquals(num.getValue(), 1, exact);
    }

    @Test
    public void testEval() {
        assertEquals((new Constant(1)).toString(), num.eval(map).toString());
    }

    @Test
    public void testGetName() {
        assertEquals(num.getName(), " - ");
    }
    
}

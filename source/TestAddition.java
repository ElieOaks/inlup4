import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestAddition {
    public Constant arg1 = new Constant(3);
    public Constant arg2 = new Constant(2);
    public Addition num = new Addition(arg1, arg2);
    public HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();

    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("3.0 + 2.0", adi);
    }

    @Test
    public void testPriority() {
        assertEquals(num.priority(), 1);
    }

    @Test
    public void testGetValue() {
        assertEquals(num.getValue(), 5);
    }

    @Test
    public void testEval() {
        assertEquals((new Constant(5)).toString(), num.eval(map).toString());
    }

    @Test
    public void testGetName() {
        assertEquals(num.getName(), " + ");
    }
    
}

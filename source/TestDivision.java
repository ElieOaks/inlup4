import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestDivision {
    public Constant arg1 = new Constant(6);
    public Constant arg2 = new Constant(2);
    public Division num = new Division(arg1, arg2);
    public HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();


    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("6.0 / 2.0", adi);
    }

     @Test
    public void testPriority() {
        assertEquals(num.priority(), 2);
    }

    @Test
    public void testGetValue() {
        assertEquals(num.getValue(), 3);
    }

    @Test
    public void testEval() {
        assertEquals((new Constant(3)).toString(), num.eval(map).toString());
    }

    @Test
    public void testGetName() {
        assertEquals(num.getName(), " / ");
    }
    
}

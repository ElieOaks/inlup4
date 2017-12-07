import mathematix.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestLog {
    public Constant arg = new Constant(3);
    public Log num = new Log(arg);
    public double value = Math.log(3);
    public double exact = 0.0001;
    public HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();

    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("log(3.0)", adi);
    }

    @Test
    public void testPriority() {
        assertEquals(num.priority(), 3);
    }

    @Test
    public void testGetValue() {
        assertEquals(num.getValue(), value, exact);
    }

    @Test
    public void testEval() {
        assertEquals((new Constant(value)).toString(), num.eval(map).toString());
    }
    
}

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestSubtraction {
    public Constant arg1 = new Constant(3);
    public Constant arg2 = new Constant(2);
    public Subtraction num = new Subtraction(arg1, arg2);

    @Test
    public void testToString() {
        String adi = num.toString();
        assertEquals("(3.0 - 2.0)", adi);
    }
    
}

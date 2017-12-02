import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import junit.framework.*;

public class TestFile {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestAddition.class, TestSubtraction.class, TestDivision.class, TestMultiplication.class, TestAssignment.class, TestCos.class, TestSin.class, TestExp.class, TestLog.class);

        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());

        System.out.println(result.wasSuccessful());
    }
}

import java.io.InputStream;
import java.util.*;


public class TestInputStream extends InputStream {
	String testString;
	int testIndex;
	
	public TestInputStream(String s) {
        this.testString = s;
    }
    
	public int read() {	
        this.testIndex++;
        return this.testString.charAt(this.testIndex);
	}

	public void newString(String test) {
		this.testString = test;
	}

}
		



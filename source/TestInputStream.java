
import java.io.InputStream;
import java.util.*;


public class TestInputStream extends InputStream {
	String testString;
	int testIndex;

	public int read() {	
		return this.testString.charAt(this.testIndex);
		this.testIndex++;
	}

	public void newString(String test) {
		this.testString = test;
	}

}
		



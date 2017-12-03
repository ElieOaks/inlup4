import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.io.IOException;


public class TestParser {

    @Test
    public void addVariableTest() throws IOException{
        Sexpr actual = Parser.parse("a + b");
        Sexpr expected = new Addition(new Variable("a"), new Variable("b"));
        assertEquals(expected.toString(), actual.toString(), "a + b");
    }

	@Test
	public void subtractionVariableTest() throws IOException{
		Sexpr actual = Parser.parse("a - b");
		Sexpr expected = new Subtraction(new Variable("a"), new Variable("b"));
		assertEquals(expected.toString(), actual.toString(), "a - b");
	}

	@Test
	public void addConstantTest() throws IOException {
		Sexpr actual = Parser.parse("1 + 2");
		Sexpr expected = new Addition(new Constant(1), new Constant(2));
		assertEquals(expected.toString(), actual.toString(), "1 + 2");
	}

	@Test
	public void subtractConstantTest() throws IOException{
		Sexpr actual = Parser.parse("1 - 2");
		Sexpr expected = new Subtraction(new Constant(1), new Constant(2));
		assertEquals(expected.toString(), actual.toString(), "1 - 2");
	}

	@Test
	public void multiplicationConstantTest() throws IOException{
		Sexpr actual = Parser.parse("7 * 3");
		Sexpr expected = new Multiplication(new Constant(7), new Constant(3));
		assertEquals(expected.toString(), actual.toString(), "7 * 3");
	}

	@Test
	public void divisionConstantTest() throws IOException{
		Sexpr actual = Parser.parse("7 / 3");
		Sexpr expected = new Division(new Constant(7), new Constant(3));
		assertEquals(expected.toString(), actual.toString(), "7 / 3");
	}

	@Test
	public void negationTest() throws IOException {
		Sexpr actual = Parser.parse("---3");
		Sexpr expected = new Negation("3");
		assertEquals(expected.toString(), actual.toString(), "---3");
	}

	@Test
	public void wrongAssignmentTest() throws IOException {
		try {
			Sexpr actual = Parser.parse("r = 3");
			fail();
		}
		catch (SyntaxErrorException e) {
			System.err.println("NO, BAD DOG");
		}
	}


	@Test
	public void parenthesisTest1() throws IOException{
		Sexpr actual = Parser.parse("((2 - 4) * 3)");
		Sexpr expected = new Multiplication(new Subtraction(new Constant(2), new Constant(4)), new Constant(3));
		assertEquals(expected.toString(), actual.toString(), "((2 - 4) * 3)");
	}

	@Test
	public void parenthesisTest2() throws IOException{
		try {
			Sexpr actual = Parser.parse("sin((");
			fail();
		}
		catch (SyntaxErrorException e) {
			System.err.println("Caught Parenthesis error");
		}
	}


	@Test
	public void unaryTest1() throws IOException{
		Sexpr actual = Parser.parse("sin(sin(7/2))");
		Sexpr expected = new Sin(new Sin(new Division(new Constant(7),new Constant(2))));
		assertEquals(expected.toString(), actual.toString(), "sin(sin(7/2))");
	}
	
	@Test
	public void emptyExprTest() throws IOException {
		try {
			Sexpr actual = Parser.parse("");
			fail();
		}
		catch (SyntaxErrorException e) {
			System.err.println("Caught exception");
		}
	}




}	

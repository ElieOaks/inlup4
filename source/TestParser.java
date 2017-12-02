import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;


public class ParserTest {

    @Test
    public void addVariableTest {
        Sexpr actual = Parser.parse("a + b");
        Sexpr expected = new Addition(new Variable("a"), new Variable("b"));
        Assert.assertEquals(expected.toString(), actual.toString(), "a + b");
    }

	@Test
	public void subtractionVariableTest {
		Sexpr actual = Parser.parse("a - b");
		Sexpr expected = new Subtraction(new Variable("a"), new Variable("b"));
		Assert.assertEquals(expected.toString(), actual.toString(), "a - b");
	}

	@Test
	public void addConstantTest {
		Sexpr actual = Parser.parse("1 + 2");
		Sexpr expected = new Addition(new Constant("1"), new Constant("2"));
		Assert.assertEquals(expected.toString(), actual.toString(), "1 + 2");
	}

	@Test
	public void subtractConstantTest {
		Sexpr actual = Parser.parse("1 - 2");
		Sexpr expected = new Subtraction(new Constant(("1"), new Constant("2"));
		Assert.assertEquals(expected.toString(), actual.toString(), "1 - 2");
	}

	@Test
	public void multiplicationConstantTest {
		Sexpr actual = Parser.parse("7 * 3");
		Sexpr expected = new Multiplication(new Constant("7"), new Constant("3"));
		Assert.assertEquals(expected.toString(), actual.toString(), "7 * 3");
	}

	@Test
	public void divisionConstantTest {
		Sexpr actual = Parse.parse("7 / 3");
		Sexpr expected = new Division(new Constant("7"), new Constant("3"));
		Assert.assertEquals(expected.toString(), actual.toString(), "7 / 3");
	}
	


	@Test
	public unaryTest1 {
		Sexpr actual = Parser.parse("sin(sin(7/2))");
		Sexpr expected = new Sin(new Sin(new Division(7, 2)));
		Assert.assertEquals(expected.toString(), actual.toString(), "sin(sin(7/2))");
	}
	
	/*
	@Test
	public unaryTest2 {
		Sexpr actual = Parser.parse("")
		Sexpr expected = ??

	}

	*/

	@Test	

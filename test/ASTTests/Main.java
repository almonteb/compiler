package ASTTests;
import AST.*;
import static AST.Terminals.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Main
{
	@Test
	public void testAst()
	{
		Node factorial = block(
				assign(id("factorial"), number(1)),
				assign(id("i"), number(5)),
				assign(id("test"), chars("cookies")),
				loop(id("i"),
						block(assign(id("factorial"),
								times(id("factorial"), id("i"))),
								assign(id("i"), minus(id("i"), number(1))))));
		StatementInterpreter runner = new StatementInterpreter();
		factorial.accept(runner);
		
		assertEquals(runner.symbols.get("i"), 0);
		assertEquals(runner.symbols.get("factorial"), 120);
		assertEquals(runner.symbols.get("test"), "cookies");
	}
}

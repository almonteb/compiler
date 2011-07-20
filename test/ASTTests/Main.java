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
		
		runner.symbols.printTable();
		
		/* Need to check first child... */
		for(SymbolTable s : runner.symbols.children)
		{
			assertEquals(0,         s.get("i"));
			assertEquals(120,       s.get("factorial"));
			assertEquals("cookies", s.get("test"));
		}
		
	}
}

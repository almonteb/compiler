import AST.*;
import static AST.Terminals.*;

public class Main
{	
	public static void main(String[] args)
	{
		/*
		 * Factorial Program equivalent to: 
		 * int factorial = 1; 
		 * int i = 5; 
		 * while (i != 0) 
		 * { 
		 * 		factorial = factorial * i;
		 * 		i = i - 1; 
		 * }
		 */
		Node factorial = block(
				assign(id("factorial"), number(1)),
				assign(id("i"), number(5)),
				declfn("testfn", "Void", block(assign(id("asdf"), chars("cookies")))/*ret(times(id("ftemp"), id("itemp")))*/, null),
				dofn("testfn", null),
				loop(id("i"),
						block(
								assign(id("factorial"), times(id("factorial"), id("i"))),
								assign(id("i"), minus(id("i"), number(1)))
							)
					)
				);
		StatementInterpreter runner = new StatementInterpreter();
		factorial.accept(runner);

		System.out.println("---- END OF PROGRAM ----");
		
		runner.symbols.printTable();
	}
}

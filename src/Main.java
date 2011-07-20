import java.util.Hashtable;

import AST.*;
import static AST.Terminals.*;

public class Main
{	
	public static void main(String[] args)
	{
		Hashtable<String, String> params = new Hashtable<String, String>();
		Hashtable<String, Expression> vals = new Hashtable<String, Expression>();
		params.put("var", "Chars");
		vals.put("var", chars("my value"));
		
		Node factorial = block(
				assign(id("factorial"), number(1)),
				assign(id("i"), number(5)),
				assign(id("asdf"),number(2)),
				declfn("testfn", "Void", block(assign(id("asdf"), id("var"))), params),
				dofn("testfn", vals),
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

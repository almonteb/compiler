import AST.*;
import AST.Number;

public class Main
{
	/* Static Functions */ 
	public static Id id (String id) { return new Id (id); }
	public static Number number (int n) { return new Number (n); }
	public static Assign assign (Id var, Expression val) { return new Assign (var, val); }
	public static Block block (Statement... statements) { return new Block (statements); }
	public static Branch branch (Expression predicate, Statement ifBranch, Statement elseBranch) { return new Branch (predicate, ifBranch, elseBranch); }
	public static Loop loop (Expression predicate, Statement body) { return new Loop (predicate, body); }
	public static Plus plus (Expression left, Expression right) { return new Plus (left, right); }
	public static Minus minus (Expression left, Expression right) { return new Minus (left, right); }
	public static Times times (Expression left, Expression right) { return new Times (left, right); }
	public static Divide divide (Expression left, Expression right) { return new Divide (left, right); }
	
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
				loop(id("i"),
						block(assign(id("factorial"),
								times(id("factorial"), id("i"))),
								assign(id("i"), minus(id("i"), number(1))))));
		StatementInterpreter runner = new StatementInterpreter();
		factorial.accept(runner);

		System.out.println("---- END OF PROGRAM ----");
		
		runner.symbols.printTable();
	}
}

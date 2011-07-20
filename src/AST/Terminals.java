package AST;

import java.util.Hashtable;

public class Terminals
{
	public static Id id(String id)
	{
		return new Id(id);
	}

	public static Number number(int n)
	{
		return new Number(n);
	}

	public static Chars chars(String s)
	{
		return new Chars(s);
	}

	public static Assign assign(Id var, Expression val)
	{
		return new Assign(var, val);
	}

	public static Block block(Statement... statements)
	{
		return new Block(statements);
	}

	public static Branch branch(Expression predicate, Statement ifBranch,
			Statement elseBranch)
	{
		return new Branch(predicate, ifBranch, elseBranch);
	}

	public static Loop loop(Expression predicate, Statement body)
	{
		return new Loop(predicate, body);
	}

	public static Plus plus(Expression left, Expression right)
	{
		return new Plus(left, right);
	}

	public static Minus minus(Expression left, Expression right)
	{
		return new Minus(left, right);
	}

	public static Times times(Expression left, Expression right)
	{
		return new Times(left, right);
	}

	public static Divide divide(Expression left, Expression right)
	{
		return new Divide(left, right);
	}
	
	public static Method declfn(String name, String ret, Block a, Hashtable<String, String> params)
	{
		return new Method(name, ret, a, params);
	}
	
	public static MethodRunner dofn(String name, Hashtable<String, String> params)
	{
		return new MethodRunner(name, params);
	}
	
	public static Return ret(Expression exp)
	{
		return new Return(exp);
	}
}

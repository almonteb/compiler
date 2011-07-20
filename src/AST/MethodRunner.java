package AST;

import java.util.Hashtable;

public class MethodRunner implements Statement
{
	String name;
	Hashtable<String, String> params;

	public MethodRunner(String name, Hashtable<String, String> params)
	{
		this.name = name;
		this.params = params;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

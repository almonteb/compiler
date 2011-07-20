package AST;

import java.util.Hashtable;

public class MethodRunner implements Statement
{
	String name;
	Hashtable<String, Expression> params;

	public MethodRunner(String name, Hashtable<String, Expression> params)
	{
		this.name = name;
		this.params = params;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

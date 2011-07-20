package AST;

import java.util.Hashtable;

public class Method implements Statement
{
	public String name;
	public Hashtable<String, String> params;
	public Block stmt;
	public String ret;
	
	public Method(String name, String ret, Block a, Hashtable<String, String> params)
	{
		this.name = name;
		this.ret  = ret;
		this.stmt = a;
		this.params = params;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
	
	public String toString()
	{
		return name + " [" + ret + "]";
	}
}

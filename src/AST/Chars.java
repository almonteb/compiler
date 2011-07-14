package AST;

public class Chars implements Expression
{
	String s;

	public Chars(String s)
	{
		this.s = s;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}
package AST;

public class Number implements Expression
{
	int n;

	public Number(int n)
	{
		this.n = n;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}
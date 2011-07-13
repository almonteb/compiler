package AST;

public class Assign implements Statement
{
	Id variable;
	Expression value;

	public Assign(Id variable, Expression value)
	{
		this.variable = variable;
		this.value = value;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}



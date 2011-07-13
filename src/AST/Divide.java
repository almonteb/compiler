package AST;

public class Divide extends Operator
{
	public Divide(Expression left, Expression right)
	{
		super(left, right);
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

package AST;

public class Plus extends Operator
{
	public Plus(Expression left, Expression right)
	{
		super(left, right);
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

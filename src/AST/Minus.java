package AST;

public class Minus extends Operator
{
	public Minus(Expression left, Expression right)
	{
		super(left, right);
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}


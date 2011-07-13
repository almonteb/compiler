package AST;

public class Times extends Operator
{
	public Times(Expression left, Expression right)
	{
		super(left, right);
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

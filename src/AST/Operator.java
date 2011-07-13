package AST;

public class Operator implements Expression
{
	Expression left;
	Expression right;

	public Operator(Expression left, Expression right)
	{
		this.left = left;
		this.right = right;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}
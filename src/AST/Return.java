package AST;

public class Return implements Statement
{
	Expression value;

	public Return(Expression value)
	{
		this.value = value;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}
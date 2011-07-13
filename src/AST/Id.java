package AST;

public class Id implements Expression
{
	String id;

	public Id(String id)
	{
		this.id = id;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

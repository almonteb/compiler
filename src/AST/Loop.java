package AST;

public class Loop implements Statement
{
	Expression predicate;
	Statement body;

	public Loop(Expression p, Statement body)
	{
		predicate = p;
		this.body = body;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

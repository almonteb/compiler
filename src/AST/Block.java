package AST;

public class Block implements Statement
{
	Statement[] statements;

	public Block(Statement... statements)
	{
		this.statements = statements;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

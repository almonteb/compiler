package AST;

public class Branch implements Statement
{
	Expression predicate;
	Statement ifBranch;
	Statement elseBranch;

	public Branch(Expression p, Statement a, Statement b)
	{
		predicate = p;
		ifBranch = a;
		elseBranch = b;
	}

	public <T> T accept(Visitor<T> v)
	{
		return v.visit(this);
	}
}

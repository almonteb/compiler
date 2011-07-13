package AST;

public class ExpressionInterpreter implements Visitor<Integer>
{
	SymbolTable symbols;

	public ExpressionInterpreter(SymbolTable symbols)
	{
		this.symbols = symbols;
	}

	public Integer visit(Id id)
	{
		if (symbols.containsKey(id.id))
			return (Integer) symbols.get(id.id);
		else
			return 0;
	}

	public Integer visit(Operator op)
	{
		return null;
	}

	public Integer visit(Plus op)
	{
		return op.left.accept(this) + op.right.accept(this);
	}

	public Integer visit(Minus op)
	{
		return op.left.accept(this) - op.right.accept(this);
	}

	public Integer visit(Times op)
	{
		return op.left.accept(this) * op.right.accept(this);
	}

	public Integer visit(Divide op)
	{
		return op.left.accept(this) * op.right.accept(this);
	}

	public Integer visit(Number num)
	{
		return num.n;
	}

	public Integer visit(Loop loop)
	{
		return null;
	}

	public Integer visit(Branch branch)
	{
		return null;
	}

	public Integer visit(Block block)
	{
		return null;
	}

	public Integer visit(Assign assign)
	{
		return null;
	}
}

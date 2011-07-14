package AST;

public class ExpressionInterpreter implements Visitor<Object>
{
	SymbolTable symbols;

	public ExpressionInterpreter(SymbolTable symbols)
	{
		this.symbols = symbols;
	}

	public Object visit(Id id)
	{
		if (symbols.containsKey(id.id))
			return symbols.get(id.id);
		else
			return 0;
	}

	public Object visit(Operator op)
	{
		return null;
	}

	public Object visit(Plus op)
	{
		return (Integer) op.left.accept(this) + (Integer) op.right.accept(this);
	}

	public Object visit(Minus op)
	{
		return (Integer) op.left.accept(this) - (Integer) op.right.accept(this);
	}

	public Object visit(Times op)
	{
		return (Integer) op.left.accept(this) * (Integer) op.right.accept(this);
	}

	public Object visit(Divide op)
	{
		return (Integer) op.left.accept(this) * (Integer) op.right.accept(this);
	}

	public Object visit(Number num)
	{
		return num.n;
	}
	
	public Object visit(Chars str)
	{
		return str.s;
	}

	public Object visit(Loop loop)
	{
		return null;
	}

	public Object visit(Branch branch)
	{
		return null;
	}

	public Object visit(Block block)
	{
		return null;
	}

	public Object visit(Assign assign)
	{
		return null;
	}
}

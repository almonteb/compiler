package AST;

public class ExpressionInterpreter implements Visitor<Object>
{
	StatementInterpreter interp;

	public ExpressionInterpreter(StatementInterpreter interp)
	{
		this.interp = interp;
	}

	public Object visit(Id id)
	{
		if (this.interp.symbols.containsKey(id.id))
		{
			return this.interp.symbols.get(id.id);
		}
		else
		{
			return 0;
		}
	}
	public Object visit(Method meth)
	{
		return null;
	}
	
	public Object visit(MethodRunner methrun)
	{
		return null;
	}
	
	public Object visit(Return ret)
	{
		return null;
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

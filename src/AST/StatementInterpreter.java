package AST;

public class StatementInterpreter implements Visitor<Void>
{
	//Map<String, Integer> symbols = new HashMap<String, Integer>();
	public SymbolTable symbols = new SymbolTable();
	private ExpressionInterpreter eval = new ExpressionInterpreter(symbols);

	public Void visit(Loop loop)
	{
		symbols = symbols.beginScope();
		while (loop.predicate.accept(eval) != 0)
		{
			loop.body.accept(this);
		}
		symbols = symbols.closeScope();
		return null;
	}

	public Void visit(Branch branch)
	{
		if (branch.predicate.accept(eval) != 0)
		{
			symbols = symbols.beginScope();
			branch.ifBranch.accept(this);
			symbols = symbols.closeScope();
		}
		else
		{
			symbols = symbols.beginScope();
			branch.elseBranch.accept(this);
			symbols = symbols.closeScope();
		}
		return null;
	}

	public Void visit(Block block)
	{
		for (Statement s : block.statements)
		{
			symbols = symbols.beginScope();
			s.accept(this);
			symbols = symbols.closeScope();
		}
		return null;
	}

	public Void visit(Assign assign)
	{
		symbols.put(assign.variable.id, (Integer) assign.value.accept(eval));
		return null;
	}

	public Void visit(Id id)
	{
		return null;
	}

	public Void visit(Operator op)
	{
		return null;
	}

	public Void visit(Plus op)
	{
		return null;
	}

	public Void visit(Minus op)
	{
		return null;
	}

	public Void visit(Times op)
	{
		return null;
	}

	public Void visit(Divide op)
	{
		return null;
	}

	public Void visit(Number num)
	{
		return null;
	}
}

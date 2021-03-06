package AST;

public class StatementInterpreter implements Visitor<Void>
{
	public SymbolTable symbols = new SymbolTable();
	private ExpressionInterpreter eval = new ExpressionInterpreter(this);

	public Void visit(Loop loop)
	{
		symbols = symbols.beginScope();
		while (Integer.parseInt(loop.predicate.accept(eval).toString()) != 0)
		{
			loop.body.accept(this);
		}
		symbols = symbols.closeScope();
		return null;
	}

	public Void visit(Branch branch)
	{
		if (Integer.parseInt(branch.predicate.accept(eval).toString()) != 0)
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
		symbols = symbols.beginScope();
		for (Statement s : block.statements)
		{
			s.accept(this);
		}
		symbols = symbols.closeScope();
		return null;
	}

	public Void visit(Assign assign)
	{
		if (symbols.containsKey(assign.variable.id))
		{
			symbols.set(assign.variable.id, assign.value.accept(eval));
		}
		else
		{
			symbols.put(assign.variable.id, assign.value.accept(eval));
		}
		return null;
	}
	
	public Void visit(Method meth)
	{
		symbols.putMeth(meth);
		return null;
	}
	
	public Void visit(MethodRunner methrun)
	{
		symbols = symbols.beginScope();
		for (String key : symbols.getMeth(methrun).params.keySet())
		{
			new Assign(new Id(key), methrun.params.get(key)).accept(this);
		}
		symbols.getMeth(methrun).stmt.accept(this);
		symbols = symbols.closeScope();
		return null;
	}
	
	public Void visit(Return ret)
	{
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
	
	public Void visit(Chars str)
	{
		return null;
	}
}

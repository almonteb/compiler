package AST;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class SymbolTable
{
	public Hashtable<String, Object> table;
	public Hashtable<String, Method> meths;
	public ArrayList<SymbolTable> children;
	public SymbolTable parent;
	
	public SymbolTable()
	{
		table = new Hashtable<String, Object>();
		meths = new Hashtable<String, Method>();
		children = new ArrayList<SymbolTable>();
	}
	
	/* Symbols */
	public void put(String key, Object obj)
	{
		table.put(key, obj);
		//System.out.println("Adding " + key + " to table " + this.hashCode());
	}
	
	public void set(String key, Object obj)
	{
		if (table.containsKey(key))
		{
			//System.out.println("Setting " + key + " in table " + this.hashCode());
			table.put(key, obj);
		}
		else
		{
			if (parent != null)
			{
				parent.set(key, obj);
			}
		}
	}
	
	public boolean containsKey(String key)
	{
		//System.out.println("containsKey " + ((parent != null) ? parent.hashCode() : "no parent"));
		if (table.containsKey(key))
		{
			return true;
		}
		else if (parent != null)
		{
			//System.out.println("Upping parent");
			return parent.containsKey(key);
		}
		return false;
	}
	
	public Object get(String key)
	{
		if (table.containsKey(key))
		{
			return table.get(key);
		}
		else if (parent != null)
		{
			return parent.get(key);
		}
		return null;
	}
	
	/* Methods */
	public void putMeth(Method meth)
	{
		meths.put(meth.name, meth);
	}
	
	public Method getMeth(MethodRunner methrun)
	{
		String key = methrun.name;
		if (meths.containsKey(key))
		{
			return meths.get(key);
		}
		else if (parent != null)
		{
			return parent.getMeth(methrun);
		}
		return null;
	}
	
	/* Scoping */
	public SymbolTable beginScope()
	{
		SymbolTable newTable = new SymbolTable();
		newTable.parent = this;
		children.add(newTable);
		return newTable;
	}
	
	public SymbolTable closeScope()
	{
		return parent;
	}
	
	/* Misc */
	public void printTable()
	{
		if (table.size() > 0 || meths.size() > 0)
		{
			System.out.println(">>>>> START " + this.hashCode());
			if (parent == null)
				System.out.println("Parent symbol table is " + this.hashCode());
		}
		
		if (table.size() > 0)
		{
			System.out.println("Keys:\n----");
			for (String key : table.keySet())
			{
				System.out.println("\t" + key + ": " + table.get(key).toString());
			}
		}
		
		if (meths.size() > 0)
		{
			System.out.println("Methods:\n----");
			for (String key : meths.keySet())
			{
				System.out.println("\t" + meths.get(key).toString());
			}
		}
		
		Iterator<SymbolTable> itr = children.iterator();
		while (itr.hasNext())
		{
			itr.next().printTable();
		}
		
		if (table.size() > 0 || meths.size() > 0)
		{
		System.out.println("<<<<< END " + this.hashCode());
		}
	}
}

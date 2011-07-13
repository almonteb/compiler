package AST;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class SymbolTable
{
	public Hashtable<String, Object> table;
	public ArrayList<SymbolTable> children;
	public SymbolTable parent;
	
	public SymbolTable()
	{
		table = new Hashtable<String, Object>();
		children = new ArrayList<SymbolTable>();
	}
	
	public void put(String key, Object obj)
	{
		if (table.containsKey(key))
		{
			table.put(key, obj);
		}
		else
		{
			if (parent != null)
			{
				parent.put(key, obj);
			}
			else
			{
				table.put(key, obj);
			}
		}
	}
	
	public boolean containsKey(String key)
	{
		if (table.containsKey(key))
		{
			return true;
		}
		else if (parent != null)
		{
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
	
	public void printTable()
	{
		for (String key : table.keySet())
		{
			System.out.println("\t" + key + ": " + table.get(key).toString());
		}
		Iterator<SymbolTable> itr = children.iterator();
		while (itr.hasNext())
		{
			//System.out.println("--- BEGIN ---");
			itr.next().printTable();
			//System.out.println("---  END  ---");
		}
	}
}

package AST;

public interface Node
{
	<T> T accept(Visitor<T> v);
}

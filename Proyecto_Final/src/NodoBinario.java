
public class NodoBinario implements Nodo 
{

	public int [][]value = new int [7][7];
	public NodoBinario left;
	public NodoBinario right;
	
	public  NodoBinario(int value[][])
	{
		this.value = value;
	}
	
	
	@Override
	public void setLeft(Nodo node) 
	{
		left = (NodoBinario)node;
	}

	
	@Override
	public Nodo getLeft() 
	{
		return left;
	}

	
	@Override
	public void setRight(Nodo node)
	{
		right = (NodoBinario)node;
	}

	
	@Override
	public Nodo getRight() 
	{
		return right;
	}

	
	@Override
	public Nodo clone()
	{
		return new NodoBinario(this.value);
	}

	
	@Override
	public boolean isEqual(Nodo node) 
	{
		return false;
	}

	@Override
	public boolean isLessThan(Nodo node)
	{
		return false;
	}
	
	public String toString() 
	{
		return this.value+ " ";
	}
}
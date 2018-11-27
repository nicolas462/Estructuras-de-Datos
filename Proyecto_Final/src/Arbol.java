public class Arbol 
{
	
	Nodo root = null; //
	 
	/**
	 * 
	 */
	public Arbol() {}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void insert(Nodo node)
	{
		if(isEmpty())
			root = node;
		else
		{
			Nodo temp = root;
			Nodo parent = root;
			
			while(temp != null)
			{
				parent = temp;
				if(node.getLeft() == null)
					temp = temp.getLeft();
				else
					temp = temp.getRight();
			}
			
			if(node.getLeft() == null)
				parent.setLeft(node);
			else
				parent.setRight(node);
		}
	}
	
	/**
	 * 
	 * @param value
	 */
	public void delete(Nodo nodeToDelete)
	{
	Nodo parent = root;
	Nodo temp = root;
		while(temp != null) 
		{
			if(temp.isEqual(nodeToDelete))
				break;
			else 
			{
				parent = temp;
				if(nodeToDelete.isLessThan(temp)) 
					temp = temp.getLeft();
					else 	
						temp = temp.getRight();
						
					
			}
			if(temp != null) 
			{
				if(isLeaf(temp))
				{
					if(temp.isLessThan(parent))
						parent.setLeft(null);
					else
						parent.setRight(null);
					}
				else
				{
					if(oneChild(temp)) 
					{
						if(temp.getLeft() != null) {
							if(temp.isLessThan(parent))
								parent.setLeft(temp.getLeft());
							else
								parent.setRight(temp.getLeft());
					}
						else
						{
							if(temp.isLessThan(parent))
								parent.setLeft(temp.getRight());
							else
								parent.setRight(temp.getRight());
						}
					}
					else
					{
						//2 hijos
						Nodo less = temp.getRight();
						
						while(less.getLeft()!=null)				
							less = less.getLeft();
							
						delete(less);
						less.setLeft(temp.getLeft());
						less.setRight(temp.getRight());
						
						if(temp.isLessThan(parent))
							parent.setLeft(less);
						else	
							parent.setRight(less);			
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLeaf(Nodo node)
	{
		return (node.getLeft() == null && node.getRight() == null) ? true : false;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean oneChild(Nodo node)
	{
		return (node.getLeft() != null && node.getRight() != null) ? false : true;
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void preOrder(Nodo node)
	{
		if(node != null)
		{
			System.out.print(node.toString() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void postOrder(Nodo node)
	{
		if(node != null)
		{
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.toString() + " ");
		}
		
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void inOrder(Nodo node)
	{
		if(node != null)
		{
			inOrder(node.getLeft());
			System.out.print (node.toString() + " ");
			inOrder(node.getRight());
		}
			
	}
}
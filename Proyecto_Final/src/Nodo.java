public interface Nodo 
{
	int [][] value = new int [7][7];


	/**
	 * 
	 * @param node
	 */
	public void setLeft(Nodo node);
	
	
	/**
	 * 
	 * @return
	 */
	public Nodo getLeft();
	
	
	/**
	 * 
	 * @param node
	 */
	public void setRight(Nodo node);
	
	
	/**
	 * 
	 * @return
	 */
	public Nodo getRight();
	
	
	/**
	 * 
	 * @return
	 */
	public Nodo clone();
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isEqual(Nodo node);
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLessThan(Nodo node);	
	
	
	/**
	 * 
	 * @return
	 */
	public String toString();
}
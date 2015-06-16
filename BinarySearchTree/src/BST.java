public class BST 
{
	Node root;
	
	public void insert(int key)
	{
		Node newNode = new Node(key);
		
		if(root == null)
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			
			while(true)
			{
				parent = current;
				if(key < current.getKey())
				{	
					current = current.getLeft();
					if(current == null)
					{
						parent.setLeft(newNode);
						return;
					}
				}
				else
				{
					current = current.getRight();
					if(current == null)
					{
						parent.setRight(newNode);
						return;
					}
				}		
			}
		}
	}
	
	public String find(int key)
	{
		Node current = root;
		
		while(current.getKey()!=key)
		{
			if(key < current.getKey())
				current = current.getLeft();
			else
				current = current.getRight();
			
			if(current == null)
				return "Does not exist";
		}
		return "Exist";	
	}
	
	public String delete(int key)
	{
		String status = "";
		Node current = root;
		Node parent = null;
		boolean left = false;
		while(current!= null)
		{
			if(current.getKey() == key)
			{
				// status = "" + current.getKey();
				break;
			}
				
			parent = current;
			if(key < current.getKey())
			{
				current = current.getLeft();
				left = true;
			}	
			else
			{
				current = current.getRight();
				left = false;
			}
		}
		if(current == null)
			status = "Not found";
		
	if(current.getLeft() != null && current.getRight() != null)
	{
		Node y = current.getLeft();
		parent = current;
		while(y.getRight() != null)
		{
			parent = y;
			y = y.getRight();
		}
		current.setKey(y.getKey());
		current = y;		
	}
	
	if(current.getLeft() == null && current.getRight() == null)
		{
			if(left)
				parent.setLeft(null);
			else
				parent.setRight(null);
			status = "Success";
		}
		
		if(current.getLeft()!= null || current.getRight()!= null)
		{
			if(current.getLeft()!=null)
			{
				if(parent == null)
					root = current.getLeft();
				if(current == parent.getLeft())
					parent.setLeft(current.getLeft());
				else
					parent.setRight(current.getLeft());
			}
			else
			{
				if(parent == null)
					root = current.getRight();
				if(current == parent.getLeft())
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
			}
			
			status = "Sucess";
		}
		
		return status;
	}
	
	
	public BST() 
	{
		// TODO Auto-generated constructor stub
	}
	
	 public void inOrderTraverseTree(Node node) 
	 {
		 if (node != null) 
		 {
			 inOrderTraverseTree(node.getLeft());
			 System.out.print(node.getKey() + " ");
			 inOrderTraverseTree(node.getRight());
		 }
	 }
	 
	public static void main(String[] args) 
	{
		BST b = new BST();
		b.insert(12);
		b.insert(11);
		b.insert(27);
		b.insert(30);
		b.insert(20);
		b.insert(22);
		b.insert(25);	
		b.insert(26);
		b.inOrderTraverseTree(b.root);
		String result = b.find(27);
		System.out.println();
		System.out.println(result);
		String del_result = b.delete(27);
		System.out.println(del_result);
		System.out.println("after deletion");
		b.inOrderTraverseTree(b.root);
		

	}

}

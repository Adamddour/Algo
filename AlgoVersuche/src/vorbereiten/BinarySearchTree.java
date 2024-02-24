package vorbereiten;

public class BinarySearchTree {
	
	Treenode root;
	
	public BinarySearchTree(int value) {
		root=new Treenode(value);
	}
	
	public boolean find(int value) {
		
		Treenode node=root;
		
		while(node!=null) {
			if(value<node.wert) {
				node=node.firstChild;
			}
			else if(value>node.wert) {
				node=node.secondChild;
			}
			else {
				return true;
			}
		}
		
		return false;
		
	}

	
	//1.1.b
	
	private boolean addNode(Treenode node,int value) {
		
		if(value<node.wert) {
			
			if(node.firstChild==null) {
				node.firstChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.firstChild, value);
			}
		}
		else if(value>node.wert) {
			
			if(node.secondChild==null) {
				node.secondChild=new Treenode(value);
				return true;
			}
			else {
				return addNode(node.secondChild, value);
			}
			
		}
		else {
			return false;
		}
		
		
		
	}
	
	
	//1.1.b
	public boolean add(int value) {
		if(root==null) {
			root=new Treenode(value);
			return true;
		}
		return addNode(root, value);
	}
	
	//1.Möglichkeit
	private String print_structur(Treenode node) {
		
		return (node!=null) ? node.wert+"{"
				+print_structur(node.firstChild)
				+print_structur(node.secondChild)
				+"}":" null ";
	}
	
	//2.Möglichkeit
	private String inOrderTraver(Treenode node) {
		return (node!=null) ? inOrderTraver(node.firstChild)
				+" "+node.wert+" "+inOrderTraver(node.secondChild):"";
	}
	
	private String inOrder(Treenode node) {
		return "["+inOrderTraver(node)+"]";
	}
	
	public String print() {
		//return print_structur(root);
		return inOrder(root)+"\n";
	}
	
	
	private Treenode deleteNOde(Treenode node,int value) {
		
		
		if(node==null) {
			return null;
		}
		
		if(value<node.wert) {
			node.firstChild=deleteNOde(node.firstChild, value);
		}
		else if(value>node.wert) {
			node.secondChild=deleteNOde(node.secondChild, value);
		}
		else {
			if(node.firstChild==null) {
				return node.secondChild;
			}
			else if(node.secondChild==null) {
				return node.firstChild;
			}
			
			node.wert=minValue(node.secondChild);
			node.secondChild=deleteNOde(node.secondChild, node.wert);
			//node.wert = minValue(node.secondChild);
            //node.secondChild = deleteNOde(node.secondChild, node.wert);
			//return null;
		}
		
		
		return node;
	}
	
	public boolean delete(int value) {
		root=deleteNOde(root, value);
		return true;
	}
	
	private int minValue(Treenode node) {
		int minValue=node.wert;
		
		while(node.firstChild!=null) {
			
			minValue=node.firstChild.wert;
			node=node.firstChild;
		}
		return minValue;
		
	}
	

	
	/*public static int height(Treenode p) {
		
		if(p==null) {
			return -1;
		}
		else {
			int firstchild=height(p.firstChild);
			int secendchild=height(p.secondChild);
			return 1+Math.max(firstchild, secendchild);
		}
	}*/
	
	public Treenode getRoot() {
		return root;
	}
	
	private int heightRecu(Treenode node) {
		
		if(node==null) {
			return -1;
		}
		else {
			int leftHeight=heightRecu(node.firstChild);
			int rightHeight=heightRecu(node.secondChild);
			return 1+Math.max(leftHeight,rightHeight);
		}
	}
	
	public int height() {
		return heightRecu(root);
	}
	
	private int depthRec(Treenode node) {
		if(node==null) {
			return -1;
		}
		else {
			
			int leftDepth=depthRec(node.firstChild);
			int rightDepth=depthRec(node.secondChild);
			return 1+Math.max(leftDepth, rightDepth);
		}
	}
	
	public int depth() {
		return depthRec(root);
	}
	
	public Integer getSuccessor(int value) {
		
		Treenode node=root;
		Integer nextB=Integer.MAX_VALUE;
		while(node!=null) {
			if(node.wert<nextB&&node.wert>value) {
				nextB=node.wert;
			}
			
			if(value<node.wert) {
				node=node.firstChild;
			}
			else if(value>node.wert) {
				node=node.secondChild;
			}
			else {
				break;
			}
			
		}
		if(node==null||node.wert!=value) {
			return null;
		}
		
		if(node.secondChild!=null) {
			node=node.secondChild;
			while(node.firstChild!=null) {
				node=node.firstChild;
			}
			return node.wert;
		}
		else{
			return (nextB<Integer.MAX_VALUE ? nextB:null);
		}
			
	}
	
	public int getMin() {
		Treenode node=root;
		while(node.firstChild!=null) {
			node=node.firstChild;
		}
		return node.wert;
	}
	
	public Integer getMax() {
		if(root==null) {
			return null;
		}
		Treenode node=root;
		while(node.secondChild!=null) {
			node=node.secondChild;
		}
		return node.wert;
	}
	
	public Integer getPred(int value) {
		
		Treenode node=root;
		Integer preSmaller=null;
		
		while(node!=null) {
			if(node.wert<value) {
				preSmaller=node.wert;
			}
			
			if(value<node.wert) {
				node=node.firstChild;
			}
			else if(value>node.wert) {
				node=node.secondChild;
			}
			else {
				break;
			}
		}
		
		if(node==null || node.wert!=value) {
			return null;
		}
		
		if(node.firstChild!=null) {
			node=node.firstChild;
			while(node.secondChild!=null) {
				node=node.secondChild;
			}
			return node.wert;
		}
		else {
			return preSmaller;
		}
	}
	
	
}

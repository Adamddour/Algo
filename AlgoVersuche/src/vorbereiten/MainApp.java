package vorbereiten;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst=new BinarySearchTree(5);
		
		int[] elemnet= {3,7,6,10,12,9};
		
		for(int ele : elemnet) {
			bst.add(ele);
			
		}
		
		System.out.println("Baum:: "+bst.print());
		System.out.println("Height: "+bst.height());
		System.out.println("Height: "+bst.depth());
		System.out.println("Nachfolger: "+bst.getSuccessor(80));
		System.out.println("Min: "+bst.getMin());
		System.out.println("Max: "+bst.getMax());
		System.out.println("Vorgaenge: "+bst.getPred(6));
		
		bst.delete(10);
		//bst.delete(7);
		
		System.out.println("Baum:: "+bst.print());
		
	
	}

}

package klausur_vorbereitung;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,4,5,6,7,8};
		int searchValue=3;
		int index=binarySearch(arr, searchValue, 0, arr.length-1);
		int index2=binarySearchIterative(arr, searchValue, 0, arr.length-1);
		
		if(index==-1 || index2==-1) {
			System.out.println("Elment: "+searchValue+" nicht gefunden");
		}
		else {
			System.out.println("Elment an der Stelle: "+index);
			System.out.println("Elment an der Stelle(Ittarativ): "+index2);
		}
		
	}
	
	static int binarySearch(int[] arr,int searchValue,int bottom,int top) {
		
		if(top<bottom) {
			return top;	
		}
		int mid=(bottom+top)/2;
		if(arr[mid]>searchValue) {
			return binarySearch(arr, searchValue, bottom, mid-1);
		}
		else {
			return binarySearch(arr, searchValue, mid+1, top);
		}
	
	}
	
	//iterative
	static int binarySearchIterative(int[] arr,int searchValue,int bottom,int top) {
		
		while(bottom<=top) {
			
			int mitte=(bottom+top)/2;
			if(arr[mitte]==searchValue) {
				return mitte;
			}
			if(arr[mitte]>searchValue) {
				top=mitte-1;
			}
			else {
				bottom=mitte+1;
			}
		}
		return -1;
	}

}

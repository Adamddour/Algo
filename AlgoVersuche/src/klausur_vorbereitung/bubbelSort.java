package klausur_vorbereitung;

public class bubbelSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1,5,3,4};
		System.out.println("Bevor");
		printa(arr);
		bubbleSort(arr);
		System.out.println("Nach");
		printa(arr);
		
		
	}
	
	public static void bubbleSort(int[] arr) {
		
		int n=arr.length;
		boolean swapped=false;
		
		for(int i=0;i<n-1;i++) {
			swapped=false;
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
		}
		if(!swapped) {
			return;
		}
		
	}
	
	public static void printa(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	


}

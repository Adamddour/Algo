package klausur_vorbereitung;

import java.util.Iterator;

public class Rekursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Fakulitaet= "+fact(5));
		System.out.println("Endrekurion_Fakulitaet= "+do_fact(1, 5));
		System.out.println("Intarativ= "+ittrativ(5));
	}
	
	public static int fact(int n) {
		if(n==1) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static int do_fact(int act,int n) {
		if(n==1) {
			return act;
		}
		return do_fact(act*n,n-1);
	}
	public static int ittrativ(int n) {
		
		int returnValue=1;
		for (int i = 1; i <=n ; i++) {
			returnValue=returnValue*i;
		}
		return returnValue;////
	}
	

}

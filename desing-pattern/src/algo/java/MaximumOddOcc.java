package algo.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaximumOddOcc {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 20, 33, 1, 10, 5,1, 10, 20, 30 };
		arrayElement(arr);
	}

	private static void arrayElement(int[] arr) {
		// TODO Auto-generated method stub
		HashMap <Integer,Integer> hm = new HashMap<>();
		int max=-1; Integer num = null;
		for(int i=0;i<arr.length;i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i],hm.get(arr[i])+1 );
				if (hm.get(arr[i])%2==0 && max<hm.get(arr[i])+1) {
					 max=hm.get(arr[i])+1; num= arr[i]; }
				
			}else {
				hm.put(arr[i],1 );
				if ( max<1) {
					 max=1; num= arr[i]; 
			   }
			}
		}
		/* 
		 int max=-1; Integer num = null;
		 * for (Map.Entry<Integer, Integer> entry : hm.entrySet()) { Integer key =
		 * entry.getKey(); Integer val = entry.getValue(); if (val%2==1 && max<val) {
		 * max=val; num= key; } }
		 */
		System.out.println("max odd num"+num);
	}
}

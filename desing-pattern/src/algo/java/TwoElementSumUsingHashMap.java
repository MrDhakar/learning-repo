package algo.java;

import java.util.HashMap;

public class TwoElementSumUsingHashMap {

	
	public static void main(String[] args) {
		
		int [] arr= {1,-2,-4,-3,5,0,-7 };
		int sum = -8;
		
		HashMap<Integer, Integer> map= new HashMap<>();
		
		boolean found = false;
		for (int x : arr) {
			
			if(map.containsKey(sum-x)) {
				found = true;
				System.out.println(x+" "+(sum-x));
			}else {
				map.put(x, x);
			}
		    
		}
		
		if(!found) System.out.println("no element exists");
	}
}

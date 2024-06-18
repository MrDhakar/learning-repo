package algo.java;

import java.util.HashMap;

public class LongestSubArrary {
	public static void main(String[] args) {
		int[] arr = {0,1,0,1,0,0,0,1,1,0};
		
		arrayElement(arr);
		//System.out.println("start"+finalArry[0]+"end"+finalArry[1]);
	}

	private static int[] sumArray(int[] arr, int length) {
		// TODO Auto-generated method stub
		int[] sum = new int[length];
		sum[0]=0;
		for(int i=1;i<length;i++) {
			if(arr[i]>0) {
				sum[i]+=1+sum[i-1];
			}
			else sum[i]+=-1+sum[i-1];
		}
		return sum;
	}

	private static void arrayElement(int arr[]) {
		// TODO Auto-generated method stub
       
		int start=0,end=0,maxlen=-1,sum=0;
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
		   if(arr[i]>0) sum+=1;
		   else sum+=-1;
		   
    	   if(sum==0) {
    		   maxlen=i+1;
    		   end=i;
    	   }
    	   
    	   if(map.containsKey(sum)) {
    		   
    		   if(maxlen<i-map.get(sum)) {
    			   maxlen= i-map.get(sum);
    			   end=i;
					/* start=i-map.get(sum); */
    		   }
    			   
    	   }else {
    		   map.put(sum, i);
    	   }
    	   start=end-maxlen+1;
    	   
       }
		
		System.out.println("start:"+start+"ënd:" + end+"Max len"+maxlen);
	}
}

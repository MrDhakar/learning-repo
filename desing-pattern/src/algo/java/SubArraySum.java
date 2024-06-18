package algo.java;

public class SubArraySum {

	public static void main(String[] args) {
		int [] arr ={1, 4, 20, 3, 10, 5};
		subArraySum(arr,arr.length,5);
	}
	
	static void subArraySum(int[] arr, int n, int sum) {
		
		int start=0,currentSum=0;
		for(int i=0;i<n;i++) {
			currentSum+=arr[i];
			
			while (currentSum>sum) {
				currentSum-=arr[start];
				start++;
				
			}
			
			if(currentSum==sum) {
				System.out.println("start:"+start+"ënd:" + i);
				return;
			}
			
		}
		
		System.out.println("no sub array found");
	}
}

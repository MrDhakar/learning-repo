package algo.java;

public class maxprofit {
	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		
		arrayElement(arr);
	}

	private static void arrayElement(int[] arr) {
		// TODO Auto-generated method stub
		int maxprofit= -1;
		int min =arr[0];
		int start=0,end=0;
		for(int i=0;i<arr.length;i++) {
			if(maxprofit< arr[i]-min) {
				maxprofit= arr[i]-min;
				end=i;
			}
			if(min>arr[i]) {
				min = arr[i];
				start=i;
			}
		}
				System.out.println("start"+start+"end"+end);
	}

}

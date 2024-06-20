package algo.java;


public class CountingSort {
	
	public static void main(String[] args) {
		int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
		int[] outputArray = countSort(inputArray);

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}
	
	public static int[] countSort(int[] inputArray) {
		int N = inputArray.length;
		int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			MAX = Math.max(MAX, inputArray[i]);
			MIN = Math.min(MIN,inputArray[i] );
		}
		

		int[] countArray = new int[MAX-MIN + 1];

		for (int i = 0; i < N; i++) {
			countArray[inputArray[i]-1]++;
		}

		for (int i = MIN+1; i <= MAX; i++) {
			countArray[i-MIN] += countArray[i-MIN - 1]; // to get the correct position of element
		}

		int[] outputArray = new int[N];

		for (int i = 0; i<N; i++) {
			outputArray[countArray[inputArray[i]-1] - 1] = inputArray[i];
			countArray[inputArray[i]-1]--;
		}

		return outputArray;
	}

	
}

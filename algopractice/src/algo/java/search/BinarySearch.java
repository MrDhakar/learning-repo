package algo.java.search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 6, 8, -1, -5, 7, -10, 5 };
		// QuickSort sort = new QuickSort();
		//QuickSort.quickSort(arr, 0, arr.length - 1);
		// binarySearch(arr,6, 0, arr.length - 1);
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		//System.out.println(binarySearchRecursion(arr, 6, 0, arr.length - 1));
		//System.out.println(binarySearch(arr, -1, 0, arr.length - 1)); 
		KLargestElements(arr,3); 
	}

	private static int binarySearchRecursion(int[] arr, int element, int l, int r) {

		if (l <= r) {
			int mid = l + (r - l) / 2;
			if (element == arr[mid])
				return mid;
			else if (element < arr[mid])
				return binarySearchRecursion(arr, element, l, mid);
			else
				return binarySearchRecursion(arr, element, mid + 1, r);
		}
		return -1;
	}

	private static int binarySearch(int[] arr, int element, int l, int r) {

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (element == arr[mid])
				return mid;
			else if (element < arr[mid])
				 r = mid;
			else
				 l= mid+1;
		}
		return -1;
	}
	
	
	private static void KLargestElements(int[] arr, int k) {

		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(low>arr[i]) low = arr[i];
			if (high< arr[i]) high = arr[i];
		}
		int kthLargest = binarysearchUse(arr,k,low,high);
		System.out.println(kthLargest);
		for(int x : arr) {
			if(x>=kthLargest)	System.out.print(x+" ");
		}
	}

	private static int binarysearchUse(int[] arr, int k, int low, int high) {
		
		while(low<high) {
			int mid = low + (high-low)/2;
			int count=0;
			
			for(int j=0;j<arr.length;j++) {
				if(arr[j]>mid) count++;
			}
			
			if(count>=k) low = mid+1;
			else high = mid;
			
		}
		return high;
	}

}

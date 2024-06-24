package algo.java.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 6,8, -1, -5, 7, -10 ,5};

		quickSort(arr, 0, arr.length - 1);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

	public static void quickSort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if (l < r) {
            int partitionIndex = partition(arr,l,r);
            quickSort(arr, l, partitionIndex-1);
            quickSort(arr, partitionIndex+1, r);
		}
	}

	private static int partition(int[] arr, int l, int r) {
		
		int pivot  = arr[r];
		// TODO Auto-generated method stub
		int i=l-1;
		for(int j=l;j<=r-1;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j); // placing element before pivot elements
			}
		}
		swap(arr,i+1,r);
		return i+1;
	}
	
	static void swap(int[] arr, int i , int j){
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
}

package algo.java;

public class MergeSort {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, -1, -5, 7, -10 };

		mergeSort(arr, 0, arr.length-1);
		for(int x : arr) {
			System.out.print(x+" ");
		}
	}
// 
	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = l+  (r - l) / 2 ;

			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);

			merge(arr, l, m, r);
		}

	}

	private static void merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
        int n1=m - l+1;
        int n2=r - m;
		int[] L = new int[n1];// 3-0 = 3
		int[] R = new int[n2];// 7-3= 5

		for (int i = 0; i < n1; i++)
			L[i] = arr[l+i];
		for (int i = 0; i < n2; i++) {
			R[i] = arr[m+i+1];
		}
			

		int i = 0;
		int j = 0;
		int k=l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}
}

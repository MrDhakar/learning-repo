package algo.java;

public class ElementOrdering {
	public static void main(String[] args) {
		int [] arr ={1,2,4,-1,-5,7,-10}	;
		
//		for(int i=0;i<arr.length;i++) {}
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			if(arr[j]<0) {
				int temp = arr[j];
				while(arr[i]<0) i++;
				arr[j]=arr[i];
				arr[i]=temp;
				j--;
			}else j--;
		}
		
		for(int x : arr) {
			System.out.print(x+" ");
		}
	}
}

/**
* 利用最小堆，找出前k个最大值
*/
package Heap;

public class HeapSortApp {

	public static void main(String[] args) {
		int[] arr = new int[]{4,1,9,3,6,2,-1,5,-2,0};
		heap(arr, 3);
	}
	
	public static void heap(int[] arr, int k){
		if(k==0)
			return;
		else if(k>=arr.length)
			return;
		for(int i=0; i<k; i++){
			buildMaxHeap(arr, k);
		}
		for(int j=k; j<arr.length; j++){
			if(arr[j]<arr[0]){
				int temp = arr[0];
				arr[0] = arr[j];
				arr[j] = temp;
				updateHeap(arr, 0, k);
			}
		}
		for(int m=0; m<k; m++){
			System.out.print(arr[m]+" ");
		}
	}
	
	public static void buildMaxHeap(int[] arr, int k){
		if(k>0){
			int p = (k-1)/2;
			if(arr[k]>arr[p]){
				int temp = arr[k];
				arr[k] = arr[p];
				arr[p] = temp;
			}
			buildMaxHeap(arr, k-1);
		}
	}
	
	public static void updateHeap(int[] arr, int i, int k){
		if(2*i+2<k){
			int id = (arr[2*i+1]>arr[2*i+2])?2*i+1:2*i+2;
			if(arr[i]<arr[id]){
				int temp = arr[i];
				arr[i] = arr[id];
				arr[id] = temp;
				updateHeap(arr, id, k);
			}
		}
		else if(2*i+1<k && 2*i+2>k){
			if(arr[i] < arr[2*i+1]){
				int temp = arr[i];
				arr[i] = arr[2*i+1];
				arr[2*i+1] = temp;
				updateHeap(arr, 2*i+1, k);
			}
		}
		else
			return;
	}
	
}


public class BuildTopDownHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 3, 5, 4, 6, 13, 10,
				9, 8, 15, 17 };

		int n = arr.length;
	
		build_MaxHeap_TopDown(arr, n);
	
		printHeap(arr, n);

	}
	
	public static void build_MaxHeap_TopDown(int arr[], int n) {
		for (int i = 1; i<n; i++) {
			upHeap(arr, i);
		}
	}
	
	public static void upHeap(int arr[], int i) {
		int j = i;
		while (j > 1 & arr[j/2] < arr[j]) {
			int temp =arr[j];
			arr[j] = arr[j/2];
			arr[j/2]=temp;
			j = j/2;
			
			for (int k = 0; k < arr.length; ++i)
				System.out.print(arr[k] + " ");

			System.out.println();
		}
	}
	
	static void printHeap(int arr[], int n)
	{
		System.out.println("Array representation of Heap is:");

		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
	
}

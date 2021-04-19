
public class InsertionSort {
	public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
            
            for(int k=0; k < array.length; k++){  
	                System.out.print(array[k] + " ");  
	        } 
	        System.out.println(); 
        }  
    }  
       
    public static void main(String a[]){    
        int[] arr1 = {34,8,64,51,32,21};    
        System.out.println("Before Insertion Sort");    
        for(int k=0; k < arr1.length; k++){  
	            System.out.print(arr1[k] + " ");  
	    } 
	    System.out.println();
            
        insertionSort(arr1);//sorting array using insertion sort    
           
//        System.out.println("After Insertion Sort");    
//        for(int i:arr1){    
//            System.out.print(i+" ");    
//        }    
    }

}

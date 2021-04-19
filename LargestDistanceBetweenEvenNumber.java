import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.Random;

public class LargestDistanceBetweenEvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create instance of Random class
        Random rand = new Random();	
        
		int[] num= new int[1000];
				for(int i=0; i<num.length;i++) {
			num[i]= rand.nextInt(1000000);
		}
		
//		System.out.println("num: "+Arrays.toString(num));
		
		//largest distance between any two even integers in an integer array.
		
		/*Algorithm 1:Create a new array consisting of even numbers only. Then use nested loops to solve the problem using
		the newly created array of even numbers only.*/

		long start_time1=System.currentTimeMillis();
		int distance1=algorithm1(num);
		long end_time1=System.currentTimeMillis();
		System.out.println("total time duration for algorithm1: "+ (end_time1-start_time1));		

		System.out.println("distance1: "+distance1);
		
		//Algorithm 2.Use a nested loop to solve the problem without creating an extra array.
		long start_time2=System.currentTimeMillis();
		int distance2 =algorithm2(num);
		long end_time2=System.currentTimeMillis();
		System.out.println("total time duration for algorithm2: "+ (end_time2-start_time2));	

		System.out.println("distance2: "+distance2);
		
		//Algorithm 3.Use one loop. Find max and min of even integers. Compute max – min
		long start_time3=System.currentTimeMillis();
		int distance3 =algorithm3(num);
		long end_time3=System.currentTimeMillis();
		System.out.println("total time duration for algorithm3: "+ (end_time3-start_time3));

		System.out.println("distance3: "+distance3);
		
		//Algorithm 4.Use Streams to find the max and min. Compute max – min.
		long start_time4=System.currentTimeMillis();
		int distance4 =algorithm4(num);
		long end_time4=System.currentTimeMillis();
		System.out.println("total time duration for algorithm4: "+ (end_time4-start_time4));

		System.out.println("distance4: "+distance4);
	}
	
	public static int algorithm1(int[] num) {
		int[] temp=new int[num.length];
		int count=0;
		for(int i=0;i<temp.length;i++) {
			if(num[i]%2==0) {
				temp[count]=num[i];
				count++;
			}
		}
		int[] even=new int[count];
		
		for(int i=0;i<count;i++) {
			even[i]=temp[i];
		}
		
		int min=even[0];
		int max=even[1];
		for(int j=0;j<even.length;j++) {
			for(int k=j+1;k<even.length;k++) {
				
				if(even[j]<min) {
					min=even[j];
				}
				if(even[j]>max) {
					max=even[j];
				}
				
				if(even[k]<min) {
					min=even[k];
				}
				
				if(even[k]>max) {
					max=even[k];
				}
								
			}
			
		}

		
		return max-min;
	}
	
	public static int algorithm2(int[] num) {

		int min=0;
		int max=0;
		boolean flag=false;
		for(int j=0;j<num.length;j++) {
			for(int k=1;k<num.length;k++) {
				
				
				if(num[j]%2==0) {
					if(!flag) {
						min=max=num[j];
						flag=true;
					}
					
					if(num[j]<min) {
						min=num[j];
					}
					
					if(num[j]>max) {
						max=num[j];
					}
				}
				
				if(num[k]%2==0) {
					if(!flag) {
						min=max=num[k];
					}
					
					if(num[k]<min) {
						min=num[k];
					}
					
					if(num[k]>max) {
						max=num[k];
					}
				}
						
				
			}
			
		}
		return max-min;
	}
	
	public static int algorithm3(int[] num) {
		int min=0;
		int max=0;
		boolean flag=false;
		for(int j=0;j<num.length;j++) {
			if(num[j]%2==0) {
				if(!flag) {
					min=max=num[j];
					flag=true;
				}
				
				if(num[j]<min) {
					min=num[j];
				}
				
				if(num[j]>max) {
					max=num[j];
				}
			}
			
		}
		
		return max-min;
		
	}
	
	public static int algorithm4(int[] num) {
				
		int max=Arrays.stream(num)
				.filter(v->v % 2 == 0)
				.max()
				.getAsInt();
		int min=Arrays.stream(num)
				.filter(v->v % 2 == 0)
				.min()
				.getAsInt();
				
		return max-min;
	}
	
	

}

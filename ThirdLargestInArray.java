import java.util.Random;

public class ThirdLargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] nums= {7, 20, 18, 4, 20, 19, 20, 3};

		
		Random rand = new Random();	
        
		int[] nums= new int[150000];

		int numsLength=nums.length;
		
		for(int i=0; i<nums.length;i++) {
			nums[i]= rand.nextInt(1000000);
		}

		long start_time1=System.currentTimeMillis();
		int third_max1=algorithm1(nums,numsLength);
		long end_time1=System.currentTimeMillis();
		System.out.println("total time duration for algorithm1: "+ (end_time1-start_time1));
		
		System.out.println("The third max number using algorithm1 is: "+third_max1);

		long start_time2=System.currentTimeMillis();
		int third_max2=algorithm2(nums,numsLength);
		long end_time2=System.currentTimeMillis();
		System.out.println("total time duration for algorithm2: "+ (end_time2-start_time2));
		
		System.out.println("The third max number using algorithm2 is: "+third_max2);
		

	}
	
	public static int algorithm1(int[] nums,int numsLength) {
		
		int max=nums[0];
		int second_max=nums[0];
		int third_max=nums[0];
		int max_index=0;
		int second_index=0;
		int third_index=0;
		
		for(int i=1;i<numsLength;i++) {
			if(nums[i]>=max) {
				max=nums[i];
				max_index=i;
			}
		}
		
		for(int j=1;j<numsLength;j++) {
			if(nums[j]>=second_max && j!=max_index ) {
				second_max=nums[j];
				second_index=j;
			}
		}
		
		for(int k=1;k<numsLength;k++) {
			if(nums[k]>=third_max && k!=max_index && k!=second_index) {
				third_max=nums[k];
				third_index=k;
			}
		}
		
		return third_max;
		
	}
	
	public static int algorithm2(int[] nums,int numsLength) {
		int max=nums[0];
		int preMax=nums[0];
		int prePreMax=nums[0];
		int max_index=-1;
		
		for(int i=0;i<numsLength;i++) {
			
			if(nums[i]>=max && max_index!=i) {
				prePreMax=preMax;
				preMax=max;
				max=nums[i];
				max_index=i;
				
			}
			
		}

		return prePreMax;
		
		
	}

}

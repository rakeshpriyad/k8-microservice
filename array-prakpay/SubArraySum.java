package arrayPractice;

import java.util.Arrays;

public class SubArraySum {
		
	public SubArraySum() {
	
	}
	public void subArraySum(int [] ar, int sum){
		int startIndex=0;
		int conSum=0;
		int endIndex=0;
		 
		for(int i=startIndex;i<ar.length;i++){
			
			if(conSum>sum){
				startIndex++;
				i=startIndex;
				conSum=0;
			}
			if (conSum==sum){
				endIndex=i-1;
				break;
			}
			conSum+=ar[i];
		}
		int consucutiveArray[]=new int[endIndex+1-startIndex];
		System.out.println("Coonscutive Array for sum "+sum +"is :");
		for(int i=startIndex,j=0;i<=endIndex;i++,j++){
			consucutiveArray[j]=ar[i];
			System.out.print(ar[i]+" ");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		SubArraySum sbArray=new SubArraySum();
		sbArray.subArraySum(new int[]{1,2,3,4,5,6,7,8,9,10},15);
//		sbArray.subArraySum(new int[]{1,2,3,7,5},12);
		}
		
		
		
		
}

package arrayPractice;

import java.util.Arrays;

public class ArrayOperation {

	
	public ArrayOperation() {
		
		reverseArrayInGroup();
		trapWater();
		isPytogorianArray();
	}
	public static void main(String[] args) {
		ArrayOperation ao=new ArrayOperation();
	
	}
	private void reverseArrayInGroup(){
		int[] ar=new int[]{10,20,30,40,50,60};
		int reverseInGroup=2;
		int arIndex=reverseInGroup;
		int startIndex,endIndex;
		int start=0;
		while(arIndex<=ar.length){
			startIndex=start;
			endIndex=arIndex;
			for(int i=startIndex,j=endIndex-1;i<j;i++,j--){
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
			start=arIndex;
			arIndex+=reverseInGroup;
			
		}
		System.out.println("Reversed Array is = "+Arrays.toString(ar));
	}
	
	private void trapWater(){
		int[] bar=new int[]{7,4,0,9};
		int totalUnit=0;
		int maxBar=bar[0];
		for(int i=1;i<bar.length;i++){
			if(bar[i]>maxBar){
				maxBar=bar[i];
			}
			else{
				totalUnit+=maxBar-bar[i];	
			}
		}
		System.out.println("total unit of water is =" + totalUnit);
	}
	
	private void isPytogorianArray(){
		
		int[] ar=new int[]{3,2,4,6,5};
		boolean isPythogorian=false;
		for(int i=0;i<ar.length;i++){
			ar[i]=ar[i]*ar[i];
		}
		Arrays.sort(ar);
		
		for(int i=0;i<ar.length-2;i++){
			if(ar[i+2]==ar[i]+ar[i+1]){
				isPythogorian=true;
			}
		}
		
		System.out.println("Given Array is Pythogrian ="+isPythogorian);
		
	}
}

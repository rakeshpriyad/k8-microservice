package arrayPractice;

import java.util.Arrays;

public class RearrangeArrayDemo {

	
	public RearrangeArrayDemo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
	
//		int [] ar=new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
		int [] ar=new int[]{1, 2, 3, 4, 5, 6};
		RearrangeArrayDemo raD=new RearrangeArrayDemo();
		raD.rearrangeArray(ar);
	}


	private void rearrangeArray(int [] rad) {
		int[] finalAr= new int[rad.length];
		int start=0;
		int end=rad.length-1;
		int index=0;
		while(end>start){
			finalAr[index++]=rad[end--];
			finalAr[index++]=rad[start++];
		}
		if(start==end){
			finalAr[index]=rad[start];
		}
		System.out.println("Final rearranged array is ="+Arrays.toString(finalAr));
		
	}
}

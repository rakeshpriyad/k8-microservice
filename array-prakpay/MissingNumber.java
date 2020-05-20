package arrayPractice;

public class MissingNumber {

	void missingNumber(int [] ar ){
		int missingNo=-1;
		for(int i=1;i<ar.length-1;i++){
			int rem =ar[i]-ar[i-1];
			if(ar[i+1]-ar[i]>rem){
				missingNo=ar[i]+rem;
				break;
			}
		}
		System.out.println("Missing no in array is "+missingNo);
	}
	
	public static void main(String[] args) {
		MissingNumber mn =new MissingNumber();
		int ar[]= new int[]{1,2,3,5};
		int ar1[]= new int[]{1,2,3,4,5,6,7,8,10};
		mn.missingNumber(ar1);
		}
}

package arrayPractice;

public class EquilibruimPointDemo {

	
	
	public static void main(String[] args) {
		EquilibruimPointDemo equilibruimPointDemo =new EquilibruimPointDemo();
		
		equilibruimPointDemo.findEquilibrium();
		equilibruimPointDemo.findLeader();
	}

	private void findEquilibrium() {
		int [] ar=new int[]{1,3,5,2,2};
		int start=0;
		int end=ar.length-1;
		int sumEnd=0;
		int sumStart=0;
		int index=0;
		do{
			index++;
			sumStart+=ar[start++];
			sumEnd+=ar[end--];
		}while(!(sumStart==sumEnd));
		
		System.out.println("Equilibrium point is ="+ar[index]);
		
		
	}
	
	
	private void findLeader(){
		int [] ar1=new int[]{16,17, 4, 3, 5, 2};
		int [] ar2=new int[]{1 ,2, 3, 4, 0};
		int [] ar3=new int[]{7 ,4 ,5 ,7 ,3};
		int ar[]=ar3;
		for(int i=0;i<ar.length;i++){
			int leader=ar[i];
			boolean leaderBool=true;
			for(int j=i;j<ar.length;j++){
				if(leader<ar[j]){
					leaderBool=false;
				}
			}
			if(leaderBool||i==ar.length-1){
				System.out.println("Leader is ="+leader + " at index ="+i);
			}
		
		}
	}
}

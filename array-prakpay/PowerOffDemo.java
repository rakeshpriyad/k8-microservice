package arrayPractice;

public class PowerOffDemo {

	public static void main(String[] args) {
		int[] ar1 = new int[] { 1, 2, 6 };
		int ar2[] = new int[] { 1, 5 };
		PowerOffDemo pfd = new PowerOffDemo();
		pfd.comparePowers(ar1, ar2);
	}

	private void comparePowers(int[] ar1, int[] ar2) {
		for(int i =0;i<ar1.length;i++){
			for(int j=0;j<ar2.length;j++){
				if(Math.pow(ar1[i], ar2[j])>Math.pow(ar2[j], ar1[i])){
					System.out.println("Pair is ="+ar1[i]+"^"+ar2[j]+">"+ar2[j]+"^"+ar1[i]);
				}
			}
			
		}
	}

}

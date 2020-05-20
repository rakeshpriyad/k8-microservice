package arrayPractice;

public class PlatformDemo {

	public static void main(String[] args) {
		PlatformDemo pd=new PlatformDemo();
		pd.FindMaxPlatForm();
	}

	void FindMaxPlatForm() {
		String[] arr = new String[] { "0900", "0940", "0950", "1100", "1500", "1800" };
		String dept[] = new String[] { "0910", "1200", "1120", "1130", "1900", "2000" };
		int i = 0, j = 0;
		int usedPlatform = 0, minPlatForm = 0;
		try {
			while (true) {
				int departureTime=Integer.parseInt(dept[j]);
				int arrivalTime=Integer.parseInt(arr[i]);
				
				boolean flag=compareTime(arrivalTime, departureTime);
				
				if (flag) {
					usedPlatform++;
					i=i<arr.length?++i:i;
					
				}
				else if(!flag){
					usedPlatform--;
					j=j<dept.length?++j:j;
				}
				if(usedPlatform>minPlatForm){
					minPlatForm=minPlatForm+1;
				}
				System.out.println("arrival train time ="+arrivalTime+" departure train time ="+departureTime);
				System.out.println("Used PlatForm="+usedPlatform);				
				if(i==arr.length&&j==dept.length){
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("pasrsing exception came");
		}
		
		System.out.println("Minimum Platforms needed are =" + minPlatForm);

	}
	
	private boolean compareTime(int arrival, int departure){
		if(arrival<departure){
			return true;
		}
		return false;
	}
}

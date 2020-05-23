package arrayPractice;

public class StockBuySellDemo {

	public StockBuySellDemo() {

		buySellStock();
	}

	private void buySellStock() {
		int [] ar=new int[]{23,13,25,29,33,19,34,45,65,67};
//		int [] ar=new int[]{100,180,260,310,40,535,695};
		int buyRate=Integer.MIN_VALUE;
		int sellRate=Integer.MAX_VALUE;
		int sellRateIndex = 0,buyRateIndex = 0;
		for(int i=0;i<ar.length-1;i++){
			if(ar[i]<ar[i+1]&& buyRate==Integer.MIN_VALUE){
				buyRate=ar[i];
				buyRateIndex=i;
			}
			else if(ar[i]>ar[i+1]&&buyRate!=Integer.MIN_VALUE|| i+2==ar.length){
				if( i+2==ar.length){
				sellRate=ar[i+1];
				sellRateIndex=i+1;
				}
				else{
					sellRate=ar[i];
					sellRateIndex=i;
				}
				
			}
			if(buyRate!=Integer.MIN_VALUE&&sellRate!=Integer.MAX_VALUE){
				System.out.println("Buying rate is = "+buyRate+" sell rate is = "+sellRate);
				System.out.println("Buying rate index is  = "+buyRateIndex+" sell rate index is = "+sellRateIndex);
				buyRate=Integer.MIN_VALUE;
				sellRate=Integer.MAX_VALUE;
			}
		}

	}

	public static void main(String[] args) {
		StockBuySellDemo stock = new StockBuySellDemo();
		
	}
}

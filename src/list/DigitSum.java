package list;

public class DigitSum {
	public static int digit_sum(long number) {
	      // Write your code here
		String numberString = Long.toString(number);
		int sum = 0;
		for(int i = 0;i<numberString.length();i++){
			try{
				sum+=Integer.parseInt(String.valueOf(numberString.charAt(i)));
			}catch(NumberFormatException e){
				continue;
			}
			
		}
		return sum;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digit_sum(10));
	}

}

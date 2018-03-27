package list;

public class NumberPalindrome {
	public static boolean is_numeric_palindrome(long number) {
		// Write your code here
		String numberString = Long.toString(number);
		
		for(int i = 0, j = numberString.length()-1;i<numberString.length();i++ , j--){
			if(numberString.charAt(i) != numberString.charAt(j)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(is_numeric_palindrome(1221));
	}

}

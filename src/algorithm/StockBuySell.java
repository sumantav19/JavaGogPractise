package algorithm;

//The cost of a stock on each day is given in an array, find the max profit that you can make 
//by buying and selling in those days. 
//
//Input:
//First line contains number of test cases T. Each test case contain the integer value 'N'
//denoting days followed by an array of stock prices in N days.
//Output:
//The maximum profit is displayed as shown below. And if there is no profit then print "No Profit".
//
//
//Constraints:
//1 <=T<= 100
//2 <=N<= 100
//1 <=arr[i]<= 10000
//
//
//Example
//
//Input:
//2
//7
//100 180 260 310 40 535 695
//10
//23 13 25 29 33 19 34 45 65 67
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockBuySell {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases > 0) {
			int testDataLength = Integer.parseInt(br.readLine());
			String[] testDataArray = br.readLine().split("\\s");
			int profitCount = 0;
			try {
				for (int i = 0; i < testDataLength - 1; i++) {
					while (Integer.parseInt(testDataArray[i]) > Integer.parseInt(testDataArray[i + 1])
							&& i < testDataLength) {
						i++;
					}
					System.out.print("(" + i);
					profitCount++;
					i++;
					try {
						while (Integer.parseInt(testDataArray[i]) < Integer.parseInt(testDataArray[i + 1])
								&& i < testDataLength) {
							i++;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.print(" " + i + ") ");

				}
			} catch (IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				if (profitCount == 0) {
					System.out.print("No Profit");
				}
			}
			System.out.println();
			testCases--;
		}

	}

}

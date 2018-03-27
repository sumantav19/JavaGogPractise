package list;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JumpOverNumbers {
	 public static int jump_over_numbers(List<Integer> list) {
	        // Write your code here
		Iterator<Integer> it = list.iterator();
		int count = 0;
		while(it.hasNext()){
			int current =  it.next();
			count++;
			if(current == 0){
				count = -1;
				break;
			}
			while(it.hasNext() && current > 1 ){
				it.next();
				current--;
			}
		}
		return count;
	 }
	 public static void main(String[] arg){
		 List<Integer> testdata = new LinkedList<Integer>();
		 Integer[] testDataArray = {3,4,1,0,5,6,9,0,1,2,3,1};
		 Collections.addAll(testdata,testDataArray);
		 System.out.println(jump_over_numbers(testdata));
	 }
}

package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimilarExpression {	
	public static char toggleOperator(char operator,char toggleOperator){
		return toggleOperator == '-'  ?  toggleUtil(operator) : operator;		 
	}
	public static char toggleUtil(char operator){
		return operator == '-' ? '+' : '-';
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCases ; i ++){
		    String testExpression1 = br.readLine();
		    String testExpression2 = br.readLine();
		    StringBuilder epression1 =  new StringBuilder();
		    Stack<Character> toggleOperatorStack = new Stack<Character>();
		    int count = 0;
		    char operator = 0;
		    for(int j = 0; j < testExpression1.length();j++){		    	
		    	if(testExpression1.charAt(j) == '-' || testExpression1.charAt(j) == '+'){
		    		if(toggleOperatorStack.isEmpty()){
		    			operator = testExpression1.charAt(j);
		    		}else{
		    			operator = toggleOperator(testExpression1.charAt(j),toggleOperatorStack.peek());
		    		}
		    		//operator = testExpression1.charAt(j);
		    	}else if( testExpression1.charAt(j) == '('){
		    		if(!toggleOperatorStack.isEmpty()){
		    			operator = toggleOperator(operator, toggleOperatorStack.peek());
		    		}		    		
		    		toggleOperatorStack.push(operator);
		    	}else if(testExpression1.charAt(j) == ')'){
		    		if(!toggleOperatorStack.isEmpty())
		    			toggleOperatorStack.pop();
		    	}else{
		    		int operand = testExpression1.charAt(j)-'a';
		    		if(operator != 0 || operand != '-'){
		    			count = count + operand;
		    		}else{
		    			count = operator == '-' ? count - operand : count + operand; 
		    		}
		    		
		    	}
		    }
		    System.out.println(count);
		    
//		    if(epression1.toString().equals(testExpression2)){
//		    	System.out.println("YES");	    	
//		    }else{
//		    	System.out.println("NO");
//		    }
		}
		
	}

}

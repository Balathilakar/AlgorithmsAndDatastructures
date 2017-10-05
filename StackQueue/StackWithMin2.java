package cracking.code.interviewQ.StackQueue;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	

	public Stack<Integer> s2;
	
	public StackWithMin2(){
		s2 = new Stack<Integer>();
	}
	
	
	public void push(int value){
		if(value < min()){
			s2.push(value);
		}
		push(value);
	}
	
	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}else {
			return s2.peek();
		}
	}
	
	public Integer pop(){
	
		int value = this.pop();
		
		if(value == min()){
			s2.pop();		
		}
		
		return value;	
	}
}
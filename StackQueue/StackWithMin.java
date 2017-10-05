package cracking.code.interviewQ.StackQueue;

import java.util.Stack;

/*Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.*/

public class StackWithMin extends Stack<NodewithMin>{
	
	public static void main(String ag[]){
			StackWithMin swm = new StackWithMin();
			swm.push(12);
			swm.push(20);
			swm.push(45);
			swm.push(1);
			swm.push(3);
			
			System.out.println(swm.min());
			swm.min();
	}
		
	public void push(int value){
		
		int newMin = Math.min(value, min());
		push(new NodewithMin(value,newMin));
		
	}
	
	public int min(){
		
		if(this.isEmpty()){
			return Integer.MAX_VALUE;//Error value
		}else{
			return peek().min;
		}
		
	}	
}

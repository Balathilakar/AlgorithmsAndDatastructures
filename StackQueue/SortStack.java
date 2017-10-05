package cracking.code.interviewQ.StackQueue;

import java.util.Stack;

/*This algorithm is O ( N2 ) time and O ( N) space.*/

public class SortStack {
	
public void sortStack(Stack<Integer> s){
		
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		/* Copy the elements from r back into s */
		while(!r.isEmpty()){
			s.push(r.pop());
		}	
	}


}

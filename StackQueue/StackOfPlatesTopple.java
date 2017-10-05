package cracking.code.interviewQ.StackQueue;

import java.util.ArrayList;
import java.util.Stack;

/*Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.*/

public class StackOfPlatesTopple {

	// Below logic is sample pseudo code, need to figure out how to set the capacity;See the uncommentedCode below;
	/*ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity = 5;
	
	public void push(int value){
		Stack<Integer> last = getLastStack();

		if(last != null && !last.isFull){
			last.push(value);
		}else{
			Stack<Integer> s = new Stack<Integer>();
			s.push(value);
			stacks.add(s);
		}
	}
	
	public Integer pop(){
		Stack<Integer> last = getLastStack();
		
		if(last == null){
			throw new EmptyStackException();
		}
		int value = last.pop();
		
		if(last.size == 0){
			stacks.remove(stacks.size() -1);
		}
		return value;
	}	*/

	
	
}

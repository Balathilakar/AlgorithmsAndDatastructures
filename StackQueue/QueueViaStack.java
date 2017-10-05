package cracking.code.interviewQ.StackQueue;

import java.util.Stack;

public class QueueViaStack<T> {

	Stack<T> stackNewest, stackOldest;
	
	public QueueViaStack(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public void add(T value){
		stackNewest.push(value);	
	}
	
	public T remove(){
		shiftStack();
		return stackOldest.pop();
	}
	
	public void shiftStack(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek(){
		shiftStack();
		return stackOldest.peek();
	}

}
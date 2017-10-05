package cracking.code.interviewQ.StackQueue;

import java.util.EmptyStackException;

//Three in One: Describe how you could use a single array to implement three stacks.
// Fixed Division
public class FixedMultiStack {
	
	public static void main(String ag[]) throws FullStackException{
		FixedMultiStack fms = new FixedMultiStack(10);
		fms.push(1, 10);
		fms.push(2, 20);
		
		int data = fms.pop(2);
		System.out.println(data);
	}
	
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize){
			stackCapacity = stackSize;
			values = new int[numberOfStacks*stackSize];
			sizes = new int[numberOfStacks];
	}
	
	/* push value into the stack; */
	public void push(int stackNum, int value) throws FullStackException	{
		/* Check we have space for next element */
		if(isFull(stackNum)){
			throw new FullStackException();
		}
		/* Increment stack pointer and then update top value */
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	/* return if stack is full */
	public boolean isFull(int stackNum){
			return sizes[stackNum] == stackCapacity;
	}
	
	
	/* Returns index of the top of the stack */
	public int indexOfTop(int stackNum){
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
	}
	
	/* Return if stack is empty */
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}
	
	/* Return top element */
	public int pop(int stackNum){
			if(isEmpty(stackNum)){
				throw new EmptyStackException();
			}
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex]; //Get top
			values[topIndex] = 0; //clear
			sizes[stackNum]-- ;
			return value;
	}

	/* Return top element */
	public int peek(int stackNum){
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
}

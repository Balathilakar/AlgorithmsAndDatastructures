package cracking.code.interviewQ.StackQueue;

import java.util.EmptyStackException;

public class FlexibleMultiStack {
	
	public static void main(String ag[]) throws FullStackException{
			//4 is numberOfStack and 3 is defaultSize
			FlexibleMultiStack fms = new FlexibleMultiStack(3, 2);
			
			fms.push(2,07);
			fms.push(2,77);
						
			fms.push(1,21);
			fms.push(1,15);
			fms.push(0, 33);
			fms.push(2, 5);
			//System.out.println(fms.pop(1));
			System.out.println();
	}
			
	private class StackInfo {
		
		public int start, size, capacity;
		
		public StackInfo(int start, int capacity){
				this.start = start;
				this.capacity = capacity;
		}
		
		/*check if a index on the full array is within the stack boundaries. the
		stack can wrap around to the start of the array*/
		public boolean isWithinStackCapacity(int index){
			/* If outside of bounds of array, return false */
			if(index < 0 || index >=  values.length){
				return false;
			}
			/* if index wrap around, adjust it */
			int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return start <= contiguousIndex && contiguousIndex < end;
		}
		
		public int lastCapacityIndex(){
			return adjustIndex(start + capacity -1);			
		}
		
		public int lastElementIndex(){
			return adjustIndex(start + size -1);
		}
		
		public boolean isFull() {return size == capacity;}
		
		public boolean isEmpty() {return size == 0;}
	}
	
	private StackInfo[] info;
	private int[] values;
		
	public FlexibleMultiStack(int numberOFStacks, int defaultSize){
		/* Create metadata for all the stacks */
		info = new StackInfo[numberOFStacks];
		for(int i = 0;i < numberOFStacks;i++){
				info[i] = new StackInfo(defaultSize * i, defaultSize);
		}
		values = new int[numberOFStacks * defaultSize];
	}
		
	/* push value onto stack num, shifting/expanding stacks as necessary. throws
	 * exception if stacks are full	
	 */
	public void push(int stackNum, int value) throws FullStackException{
			if(allStacksAreFull()){
				throw new FullStackException();
			}
			
			/* if this stack is full, expand it  */
			StackInfo stack = info[stackNum];
			if(stack.isFull()){
				expand(stackNum);
			}
			
			/* Find the index of the top element in the array + 1, and increment the stack pointer */
			stack.size++;
			values[stack.lastElementIndex()] = value;
	}
	
	/*Remove the element from stack */
	public int pop(int stackNum) throws EmptyStackException{
		
		StackInfo stack = info[stackNum];
		
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		/* Remove last element */
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;//  Clear item
		stack.size--;// Shrink size
		return value;
	}
		
	/* Get top element of stack */	
	public int peek(int stackNum){
		StackInfo stack = info[stackNum];
		return values[stack.lastElementIndex()];
	}
		
	/* Shift items in stack over by one element. if we have available capacity, then 
	 * we will endup shrinking the stack by one element. if we don't have available 
	 * capacity, then we will need to shift the next stack over too	
	 */
	private void shift(int stackNum){
		System.out.println("/// Shifting "+stackNum);
		StackInfo stack = info[stackNum];
	
		/* If this stack is at its full capacity, then you need to move the next stack over by one element.
		 * This stack can now claim the freed index 		 * 
		 */
		if(stack.size >= stack.capacity){
			int nextStack = (stackNum +1) % info.length;
			shift(nextStack);
			stack.capacity++ ; //claim index that next stack lost;
		}
		
		/* shift all elements in the stack over by one */
		int index = stack.lastCapacityIndex();
		while(stack.isWithinStackCapacity(index)){
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
		}
		
		/* Adjust stack data */
		values[stack.start] = 0; //Clear item;
		stack.start = nextIndex(stack.start); //move start
		stack.capacity--; //Shrink capacity		
	}
	
	/* Expand stack by shifting over other stacks */
	private void expand(int stackNum){
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;
	}
	
	/*Returns the number of items actually present in the stack */
	public int numberOfElements(){
		int size = 0;
		for(StackInfo si : info){
			size += si.size;
		}
		return size;		
	}
	
	/* return true is all the stacks are full */
	public boolean allStacksAreFull(){
		return numberOfElements() == values.length;
	}
	
	/*Adjust index  to be within the range of 0 -> length - 1 */
	private int adjustIndex(int index){
			/* java's mod operator can return neg values. example (-11 % 5)  will return -1
			 * not 4 we actually want the value to be 4( since we are wrapping around the index
			 */
		int max = values.length;
		return ((index % max)+max) % max;	
	}
	
	/* Get index after this index, adjusted for wrap around */
	private int nextIndex(int index){
		return adjustIndex(index + 1);
	}
	
	/* Get index before this index, adjusted for wrap around */
	private int previousIndex(int index){
 		return adjustIndex(index-1);
	}	
}

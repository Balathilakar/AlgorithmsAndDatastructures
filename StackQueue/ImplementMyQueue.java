package cracking.code.interviewQ.StackQueue;

import java.util.NoSuchElementException;

public class ImplementMyQueue<T> {

	public class QueueNode<T> {
		T data;
		QueueNode<T> next;
		
		public QueueNode(T dt){
			this.data = dt;		
		}
	}
	
	QueueNode<T> first;
	QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> q = new QueueNode<T>(item);
		
		if(last != null){
			last.next = q;
		}
		
		last = q;
		if(first == null){
			first = last;			
		}
		
	}
	
	public T peek(){
		if(first == null) throw new NoSuchElementException();
		return first.data;
	}
	
	public T remove(){
		if(first == null) throw new NoSuchElementException();
		
		T data = first.data;
		first = first.next;
		
		if(first == null){
			last = null;
		}
		return data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}

}
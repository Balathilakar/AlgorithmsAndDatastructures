
package dataStructure.LinkedList;

//pop(),push(),top(),isEmpty

public class StackImpUsingLL {
	
		Node head = null;
		int top = -1;
	
		class Node{
			
			int value;
			Node next;
			
			public Node(int dt){
				this.value = dt;
			}
			
		}
		
		public static void main(String arg[]){
			StackImpUsingLL sill = new StackImpUsingLL();
			
			System.out.println(sill.isEmpty());
			sill.push(2);
			sill.push(5);
			sill.push(15);
			sill.push(25);
			sill.pop();
			sill.push(50);
			System.out.println(sill.isEmpty());
			System.out.println(sill.head +" head and top values are "+sill.top);
		}
		
		public void push(int dt){
			
			Node temp = new Node(dt);
			top++;
			
			if(head == null){
				head = temp;
				return;
			}
			temp.next = head;
			head = temp;				
		}
		
		public void pop()
		{
		
			if(head == null){
				System.out.println("Stack is empty");
				return;
			}
			
			top--;
			Node temp = head.next;
			head = temp;
		}
		
		public boolean isEmpty(){
		
			if(top == -1){
				return true;	
			}
			return false;
		}
		
}

package dataStructure.LinkedList;

public class ReverseLLIteration {
		
		Node head = null;
	
		public static void main(String a[]){
				ReverseLLIteration rl = new ReverseLLIteration();
				rl.addNode(5);
				rl.addNode(10);
				rl.addNode(15);
				rl.addNode(20);
				rl.addNode(25);
				rl.addNode(30);
				Node newNode = rl.new Node(25);
				rl.print(rl.head);
				Node rev = rl.reverseNode();
				rl.print(rev);                                                                                                                                  
				System.out.println(newNode);
				System.out.println(rl.head); 
				
		}
		
		public void print(Node nd){
			Node tp = nd;
			while(tp!=null){
				System.out.print(tp.data+" ");
				tp = tp.next;
			}
			System.out.println();
		}
		
		private class Node{
			int data;
			Node next;
			
			public Node(int dt){
				this.data = dt;
			}
			public String toString(){
				return "Node is GoodString";
			}
		}
		
		
		public Node reverseNode(){
			
			Node next=null,prev=null, current = head;
			
			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
			
		}
		
		public void addNode(int dt){
			Node nd = new Node(dt);
			
			Node temp = head;
			
			if(temp == null){
				temp = nd;
				head = temp;
				return;
			}
			
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = nd;
		}
		
		public String toString(){
			return "Good_Job";
		}

				
}

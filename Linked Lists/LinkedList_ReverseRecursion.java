package dataStructure.LinkedList;

public class LinkedList_ReverseRecursion {
	
	Node head= null;
	static int i,j;
	public static void main(String[] args) {
		 	LinkedList_ReverseRecursion rr = new LinkedList_ReverseRecursion();
		 	rr.addNodeValue(5);
		 	rr.addNodeValue(10);
		 	rr.addNodeValue(15);
		 	printValue(rr.head);
	}
	
	public static void printValue(Node hd){
			if(hd == null)
				return;
			System.out.println("j "+j++);
			System.out.println(hd.data);
			printValue(hd.next);
			System.out.println("i "+ i++);
	}
	
	public void addNodeValue(int dt){
		Node nd = new Node(dt);
		Node tp = head;
		
		if(head == null){
			head = nd;
			return;
		} 
		
		while(tp.next != null){
			tp = tp.next;
		}
		tp.next = nd;
	}
	
	public class Node{
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;
		}
		
	}

}

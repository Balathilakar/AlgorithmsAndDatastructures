package dataStructure.LinkedList;

public class InsertNthPositionLinkedList {
		
	static Node head = null;
		
	public static void main(String arg[]){
			insertNode(2);
			insertNode(4);
			insertNode(1);
			insertNode(8);
			insertNthLoc(12, 3);
	}
	
	
	static public void insertNthLoc(int dt, int n){
		
		Node temp1 = null;
		InsertNthPositionLinkedList ill = new InsertNthPositionLinkedList();
		
		temp1 = ill.new Node(dt);
		
		Node temp2 = head; 
		
		for(int i = 0;i < n-2;i++){
			temp2 = temp2.next;
		}
		temp1.next = temp2.next;
		temp2.next = temp1;
		
	}
	
	static public void insertNode(int data){
		
		InsertNthPositionLinkedList ill = new InsertNthPositionLinkedList();
		
		Node node = ill.new Node(data);
		
		if(head == null){
			head = node;
		}else{
			Node temp = head;
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = node;
		}
	}
	
	 class Node{
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;
		}
	}
	
}

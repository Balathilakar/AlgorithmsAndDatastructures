package dataStructure.LinkedList;

public class DeleteNthPositionLinkedList {
	
	Node head = null;
	
	public static void main(String arg[]){
		
		DeleteNthPositionLinkedList dll = new DeleteNthPositionLinkedList();
		dll.addElements(34);
		dll.addElements(12);
		dll.addElements(1);
		dll.addElements(10);
		dll.addElements(5);
		dll.addElements(7);
		dll.addElements(25);
		
		dll.deleteElement(2);
		
	}
	
	public void deleteElement(int pos){
		
		Node temp = head;
		Node tp1 = null;
		
		if(pos == 1){
			head = temp.next;
			return;
		}
		
		for(int i = 0;i < pos-2;i++){
			if(temp.next != null){
				temp = temp.next;
			}
		}
		
		tp1 = temp.next;
		temp.next = tp1.next;
		System.out.println("Check the output");
	}
	
	public void addElements(int dt){
		Node nd = new Node(dt);
		
		if(head == null){
			head = nd;
			return;
		}
		
		nd.next = head;
		head = nd;
		
	}
	
	public class Node{
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;
			this.next = null;
		}
	}

}

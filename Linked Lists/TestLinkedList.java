package dataStructure.LinkedList;

//Insert the element in the nth location in the linkedList;
class TestLinkedList {
	
	Node head = null;
	
	public static void main(String args[]){
		
			TestLinkedList tll = new TestLinkedList();
			
			tll.addElement(6);
			tll.addElement(8);
			tll.addElement(11);
			tll.addElement(1);
			tll.addElement(16);
			tll.insert(22,3);
			System.out.println(tll.head);
			
	} 
	
	public void addElement(int dt){
			Node nd = new Node(dt);
			
			Node temp = head;
			
			if(head == null){
				head = nd;
			}else{
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = nd;
			}
			
	}
	
	public void insert(int dt,int pos){
			Node temp = head;
			
			Node nd = new Node(dt);
			
			if(temp == null){
				head = nd;
			}else{
				for(int i = 0;i < pos-2;i++){
					if(temp.next != null){
						temp = temp.next;
					}
				}
				nd.next = temp.next;
				temp.next = nd;
			}
			System.out.println("Element got inserted successfully");
	}
	
	
	private class Node{
			int data;
			Node next;
			
			public Node(int dt){
				this.data = dt;
				this.next = null;
			}
	}
	
	
	
}

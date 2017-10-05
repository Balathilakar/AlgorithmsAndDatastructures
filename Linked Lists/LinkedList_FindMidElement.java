package dataStructure.LinkedList;

public class LinkedList_FindMidElement {
	
	Node head;
	int size = 0;
		
	public void addValuesToList(int data){
		
		Node node = new Node(data);
		
		Node temp = head;
				
		if(head == null){
			head = node;
			size++;
		}else{
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
			size++;
		}
		//System.out.println(size);		
	}	
	
	public void printValues(){
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public Node findMidNode(){
		
		Node slowPointer, fastPointer;
		
		slowPointer = head;
		fastPointer = head;
		
		while(fastPointer.next != null){
			 fastPointer = fastPointer.next;
			 
			 if( fastPointer.next !=null){
				 slowPointer = slowPointer.next;
				 fastPointer = fastPointer.next;
			 }
		}
		return slowPointer;
	}
	
	public static void main(String arg[]){
		LinkedList_FindMidElement fme = new LinkedList_FindMidElement();
		fme.addValuesToList(5);
		fme.addValuesToList(1);
		fme.addValuesToList(10);
		fme.addValuesToList(3);
		
		
		fme.printValues();
		System.out.println("The mid value is : "+fme.findMidNode().data);
	}
	
	class Node{
		int data;
		Node next;
		
		public Node(int d){
			this.data = d;
		}
	}
	
}

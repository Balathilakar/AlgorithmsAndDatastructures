package dataStructure.LinkedList;

public class PrintLLReverseRecursion {
	
	Node head = null;
	
	public static void main(String arg[]){
		PrintLLReverseRecursion pl = new PrintLLReverseRecursion();
		pl.addNode(5);
		pl.addNode(6);
		pl.addNode(14);
		pl.addNode(41);
		pl.addNode(50);
		
		pl.printValue();
		pl.reversePrint(pl.head);
	}

	public void printValue(){
			Node x = head;
			while(x != null){
				System.out.print(x.data+" ");
				x = x.next;
			}
			System.out.println();
	}	

	public void addNode(int d){
		
		Node nd = new Node(d);
		Node temp = head;
		if(head == null){
			head = nd;
			return;
		}
		
		while(temp.next != null){
			temp = temp.next;
		}		
		temp.next = nd;
		
		
	}

	public void reversePrint(Node nd){
		
		if(nd == null){
			return;
		}
		
		Node node = nd;
		reversePrint(node.next);
		System.out.print(node.data+" ");
	}

 public class Node{
	
	int data;
	Node next;
	
	public Node(int dt){
		this.data = dt;
	}
	
}

} 
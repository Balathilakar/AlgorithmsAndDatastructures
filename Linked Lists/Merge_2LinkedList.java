package dataStructure.LinkedList;

public class Merge_2LinkedList {

	public static void main(String args[]){

		 Node head1 = null;
		 Node head2 = null; 
		 
		 Merge_2LinkedList ml = new Merge_2LinkedList();
		 
		 head1 =  ml.new Node(0);
		 
		 ml.addNode(2, head1);
		
		 
		 System.out.println(ml);
		 
		 head2 = ml.new Node(9);
		 
		 ml.addNode(11, head2);
		 ml.addNode(13, head2);
		 ml.addNode(15, head2);
		 ml.addNode(17, head2);
		 
		 System.out.println("Merge two list");
		 
		 //ml.mergeTwoList(head1, head2);
		 ml.mergeTwoLists(head1, head2);
	}	
	
	public Node mergeTwoLists(Node l1, Node l2) {
		Node head = new Node(0);
		Node p=head;
	 
		Node p1=l1;
		Node p2=l2;
	    while(p1!=null && p2!=null){
	        if(p1.data < p2.data){
	            p.next = p1;
	            p1 = p1.next;
	        }else{
	            p.next = p2;
	            p2 = p2.next;
	        }
	        p=p.next;
	    }
	 
	    if(p1!=null){
	        p.next = p1;
	    }
	 
	    if(p2!=null){
	        p.next = p2;
	    }
	 
	    return head.next;
	}
	
	
	
	public Node addNode(int dt, Node hd){
		
		Node node = new Node(dt);
		
		if(hd == null){
			hd = node;
		}else{
		Node temp = hd;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		}	
		
		return hd;
	}
	
	class Node{
	
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}	
	}	
	
}

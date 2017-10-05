package cracking.code.interviewQ.LinkedList;

public class PrintKthToLast {
	

	static public class Node {
	
	int data;
	Node next;
	
	public Node(int dt){
		this.data = dt;
	}	
	}
	
	public static void main(String ag[]){
		
		Node root = new Node(2);
		
		root.next = new Node(5);
		root.next.next = new Node(8);
		root.next.next.next = new Node(12);
		root.next.next.next.next = new Node(15);
		root.next.next.next.next.next = new Node(1);
		
		PrintKthToLast pkl = new PrintKthToLast();
		
		pkl.nthToLast(root,3);	
	}
	
	public Node nthToLast(Node root,int k){
		
		Node p1 = root;
		Node p2 = root;
		
		for(int i = 0; i < k;i++){
			p1 = p1.next;
		}
		
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	//Not working because of i is 0 on each recursion	
	/*public Node nthToLast(Node head,int k){
		int i = 0;
		return nthToLast(head,k,i);
	}
	
	//Not working because of i is 0 on each recursion
	public Node nthToLast(Node head,int k,int i){
		
		if(head == null){
				return null;
		}
		
		Node nd = nthToLast(head.next, k, i);
		i = i + 1;
		if(i == k){
				return head;			
		}
		return nd;
	}
	*/
/*
 * public int printKthToLast(Node rt,int k){
	
	if(rt == null){
		return 0;
	}
	
	int index = printKthToLast(rt.next,k) + 1;
	if(index == k){
		System.out.println("value of kth to last element : "+rt.data);
	}
	return index;
}*
 */


}

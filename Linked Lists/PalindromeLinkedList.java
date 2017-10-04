/*
 * Check if the LinkedList is palindrome or not
 */

public class PalindromeLinkedList {
	
	static public class Node {
		
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;	
		}
	}

	public static void main(String ag[]){

		PalindromeLinkedList pll = new PalindromeLinkedList();
			
			 Node head = null;
		
			 head = pll.createNode(0,head);
		     head = pll.createNode(1,head);
		     head = pll.createNode(2,head);
		     head = pll.createNode(1,head);
		     head = pll.createNode(0,head);
		     
		     boolean bol = pll.isPalindrome(head);
		     System.out.println(bol);
	}

	public boolean isPalindrome(Node head){
		Node rev = reverseLL(head);
		return isEqual(head, rev);
	}
	
	public boolean isEqual(Node hd,Node rev){
		while(hd != null || rev != null){
			if(hd.data != rev.data){
				return false;
			}
			hd = hd.next;
			rev = rev.next;
		}
		return hd.next == null && rev.next == null;
		
	}

	public Node reverseLL(Node hd){
		
		Node head = null;
		
		while(hd != null){
			Node n = new Node(hd.data);
			n.next = head;
			head = n;
			hd = hd.next;
		}
		return head;
	}
	
	public Node createNode(int dt,Node root){
		Node nd = new Node(dt);
		
		if(root == null){
			root = nd;
			return root;
		}
		
		Node hd = root;
		
		while(hd.next != null){
				hd = hd.next;
		}	
		hd.next = nd;
		
		return root;
	}
}

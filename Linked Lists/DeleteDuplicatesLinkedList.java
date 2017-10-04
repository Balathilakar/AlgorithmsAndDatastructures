import java.util.HashSet;

/*
 * Delete Duplicate values in LinkedList; 
 */

public class DeleteDuplicatesLinkedList {
	
	static public class Node 
  {
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;
		}	
	}
	
	
	public static void main(String arg[])
  {
		DeleteDuplicatesLinkedList dd = new DeleteDuplicatesLinkedList();
		
		Node root = new Node(2);
		root.next = new Node(5);
		root.next.next = new Node(8);
		root.next.next.next = new Node(2);
		dd.print(root);
		System.out.println();
		Node uniq = dd.removedups(root);
		
		dd.print(uniq);
		
	}
	
	public void print(Node uniq)
  {
		while(uniq  != null){
			System.out.print(uniq.data+" ");
			uniq = uniq.next;
		}
	}
	
	public Node removedups(Node root)
  {
		Node n = root;
		Node previous = null;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(n != null){
			if(hs.contains(n.data)){
				previous.next = n.next;
			}else{
				hs.add(n.data);
				previous = n;
			}
			n = n.next; 
		}
		return root;
	}

}

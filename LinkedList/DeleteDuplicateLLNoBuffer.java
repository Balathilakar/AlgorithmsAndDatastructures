/*
 * Delete Duplicate values in the LinkedList no buffer
 */

public class DeleteDuplicateLLNoBuffer {	
	
	static class Node{
			
		int data;
		Node next;
		
		public Node(int dt){
			this.data = dt;
		}
	}
	
	public static void main(String[] ag){
		
		Node root = new Node(2);
		root.next = new Node(5);
		root.next.next = new Node(8);
		root.next.next.next = new Node(2);
		root.next.next.next.next = new Node(5);

		DeleteDuplicateLLNoBuffer ddll = new DeleteDuplicateLLNoBuffer();
		ddll.deleteDup(root);
		System.out.print(root);
	}
	
	public void deleteDup(Node head)
	{
		Node current = head;

		while(current != null){
				Node runner = current;
				while(runner.next != null){
					if(runner.next.data == current.data){
						runner.next = runner.next.next;
					}else{
						runner = runner.next;
					}
				}
			current = current.next;		
			}
		}
}

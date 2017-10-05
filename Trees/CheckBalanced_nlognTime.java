package cracking.code.interviewQ.TreeGraph;

public class CheckBalanced_nlognTime {
	
	static public class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;		
		}	
	}
	
static public void main(String ag[]) {
		
		Node head = null;
		
		head = new Node(10);
		head.left = new Node(5);
		head.right = new Node(15);
		
		head.left.left = new Node(1);
		head.left.left.right = new Node(4);
		head.left.left.left = new Node(8);
		
		CheckBalanced_nlognTime cb = new CheckBalanced_nlognTime();
		boolean bl = cb.isBalanced(head);
		System.out.println(bl);
	}
	
	public int getHeight(Node root) {
		if(root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public boolean isBalanced(Node root) {
		
		if(root == null){
			return true;
		}
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		if(Math.abs(heightDiff) > 1){
			return false;
		} else{
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

}

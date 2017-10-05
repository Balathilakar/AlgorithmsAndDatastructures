// In-order	  => <left><data><right>
// Pre-order  => <data><left><right>
// Post-order => <left><right><data>


public class BinaryTreeTraversal {
	
	public static void main(String ag[]){
			BinaryTreeTraversal btt = new BinaryTreeTraversal();
			Node root = btt.new Node(12);
			root.left = btt.new Node(5);
			root.right = btt.new Node(24);
			
			root.left.left = btt.new Node(2);
	}
	
	void InOrderTraversal(Node node){
		if(node != null){
			InOrderTraversal(node.left);
			System.out.println(node.data);
			InOrderTraversal(node.right);
		}
	}
	
	void preOrderTraversal(Node node){
		if(node != null){
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);	
		}
	}
	
	void postOrderTraversal(Node node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data);
		}
	}
	
	public class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;
			left = right = null;
		}
	}

}

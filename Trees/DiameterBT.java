package algorithm.binaryTree.LevelOfNode;

public class DiameterBT {

class Node{
	
		int data;
		Node left, right;
		
		public Node(int item){
			this.data = item;
			left = right = null;
		}
	}
	
	Node root;
	
	public int diameter(Node root){
		if(root == null){
			return 0;
		}
	//Get the height of left and right subtree;	
	int lheight = height(root.left);
	int rheight = height(root.right);
	
	//Get the diameter of left and right subtree;
	int ldiameter = diameter(root.left);
	int rdiameter = diameter(root.right);
	
	return Math.max(lheight+rheight+1,Math.max(ldiameter, rdiameter));
	}
	
	int diameter(){
		return diameter(root);
	}
	
	static int height(Node node){
		if(node == null){
			return 0;
		}
		return (1 + Math.max(height(node.left), height(node.right)));
	}
	
	public static void main(String[] args) {
		
	DiameterBT dbt = new DiameterBT();
	dbt.root = dbt.new Node(1);
	
	dbt.root.left = dbt.new Node(2);
	dbt.root.right = dbt.new Node(3);
	dbt.root.left.left = dbt.new Node(4);
	dbt.root.left.right= dbt.new Node(5);
	
	System.out.println("The diameter of the given binary tree is :" +dbt.diameter());
	
	}

}

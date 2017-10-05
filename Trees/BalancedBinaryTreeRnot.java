package algorithm.binaryTree;

public class BalancedBinaryTreeRnot {
		
	class TreeNode{
		
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int dt){
			this.value = dt;
		}
	}
	
	TreeNode root;
	
	private TreeNode createTree(){
		this.root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		root.left = n1;
		root.right = n2;
		
		n1.left = n3;
		n1.right = n4;
		
		n2.left = n5;
		n3.right = n6;
		
		n5.left = n7;
		n6.right = n8;
		
		return root;
	}
	
	private int checkBalance(TreeNode currentNode){
		if(currentNode == null){
			return 0;
		}
		
		int leftSubtreeHeight = checkBalance(currentNode.left);
		if(leftSubtreeHeight == -1) return -1;
		
		int rightSubtreeHeight = checkBalance(currentNode.right);
		if(rightSubtreeHeight == -1) return -1;
		
		if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1){
			return -1;
		}
		
		return (Math.max(leftSubtreeHeight, rightSubtreeHeight) +1);
	}
	
	public boolean checkIfBalanced(){
		if(checkBalance(root) == -1)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String arg[]){
		BalancedBinaryTreeRnot balancedTree = new BalancedBinaryTreeRnot();
		
		balancedTree.createTree();
		
		System.out.println("Tree is balanced: "+balancedTree.checkIfBalanced());
		
	}
	
	
}

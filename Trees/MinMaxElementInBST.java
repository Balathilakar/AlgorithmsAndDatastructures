package algorithm.binaryTree;

public class MinMaxElementInBST {
		
	public static void main(String arg[]){
		MinMaxElementInBST minMax = new MinMaxElementInBST();
		BSTNode root = null;
				
		root = minMax.insert(root,20);
		root = minMax.insert(root,19);
		root = minMax.insert(root,35);
		root = minMax.insert(root,45);
		root = minMax.insert(root,22);
		root = minMax.insert(root,15);
		root = minMax.insert(root,5);
		root = minMax.insert(root,17);
		
		BSTNode minNode = minMax.findMin(root);
		System.out.println("Value of min node is :"+minNode.val);
		
		BSTNode maxNode = minMax.findMax(root);
		System.out.println("Value of max node is :"+maxNode.val);
	}
	
	public BSTNode insert(BSTNode rt, int dta){
		
		if(rt == null) rt = new BSTNode(dta);
		else if(dta <= rt.val)  rt.left = insert(rt.left, dta);
		else 			 rt.right = insert(rt.right,dta);
		
		return rt;
	}
	
	
	public BSTNode findMin(BSTNode nd){
		
		BSTNode current = nd;
		
		if(current == null) return null;
		
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
	
	public BSTNode findMax(BSTNode nd){
		BSTNode current = nd;
		
		if(current == null) return null;
		
		while(current.right != null){
			current = current.right;
		}
		
		return current;
	}
		
		public class BSTNode{
				int val;
				BSTNode left;
				BSTNode right;
				
				public BSTNode(int data){
					this.val = data;
					this.left = this.right = null;
				}
				
		}
		
		
}

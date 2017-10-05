package algorithm.binaryTree;

import algorithm.binaryTree.DepthFirstTraversal.Node;

/*
 * Option : 01
 * Check if a given binary tree is BST(Binary Search Tree)
*/
public class BinaryTreeIsBST {
		public static void main(String arg[]){
			
			Node root = null;
			
			BinaryTreeIsBST dft = new BinaryTreeIsBST();
			
			root = dft.insert(root,20);
			root = dft.insert(root,25);
			root = dft.insert(root,15);
			root = dft.insert(root,17);
			root = dft.insert(root,5);
			root = dft.insert(root,3);
			root = dft.insert(root,7);
			root = dft.insert(root,40);
			root = dft.insert(root,22);
			root = dft.insert(root,30);
			root = dft.insert(root,45);
			
			if(dft.isBinarySearchTree(root)){
				System.out.println("The binary tree is binary search tree");
			}else{
				System.out.println("The binary tree is not binary search tree");
			}
			
		}
		
		public boolean isBinarySearchTree(Node root){
			
			if(root == null) return true;
			
			if(isSubTreeLesser(root.left, root.data) && isSubTreeGreater(root.right,root.data)
					&& isBinarySearchTree(root.left) && isBinarySearchTree(root.right))
				return true;
			else
				return false;
		}
		
		public boolean isSubTreeLesser(Node root,int value){
			if(root == null) return true;
			if(root.data <= value && isSubTreeLesser(root.left, value) && isSubTreeLesser(root.right, value)) 
				return true;
			else
				return false;
		}
		
		public boolean isSubTreeGreater(Node root,int value){
			if(root == null) return true;
			if(root.data > value && isSubTreeGreater(root.left, value) && isSubTreeGreater(root.right, value) )
				return true;
			else
				return false;
		}
		
		public Node insert(Node rt,int value){
			
			if(rt == null)
				rt = getNewNode(value);
			else if(value <= rt.data)
				rt.left = insert(rt.left,value);
			else
				rt.right = insert(rt.right,value);
			return rt;
			
		}
		
				
		public Node getNewNode(int vl){
			Node n = new Node(vl);
			return n;
		}
		
		public class Node{
				int data;
				Node left;
				Node right;
				
				public Node(int dt){
					this.data = dt;
					this.left = this.right = null;
				}
		}
		
/*
 * Option : 02
 * Other alternative approach is using permissible range;
 * 		for left side range should be (-infinity, 20)
 *  	for right side range should be (20, infinity)
 *  	isBinarySearchTree(Node root, int minValue, int maxValue)
*/	
		
		public boolean isBSTUsingRange(Node root){
			return isBinarySearchTreeUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		public boolean isBinarySearchTreeUtil(Node root,int minValue,int maxValue){
				if(root == null) return true;
				if(root.data > minValue && root.data < maxValue 
						&& isBinarySearchTreeUtil(root.left, minValue, root.data) 
						&& isBinarySearchTreeUtil(root.right, root.data, maxValue))
					return true;
				else
					return false;
		}
		
	/*
	 * Option : 3
	 * Do in-order traversal and check current data traversing is greater than previous data;
	 * 
	*/
		
}

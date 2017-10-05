package algorithm.binaryTree;

import algorithm.binaryTree.BreadthFirstTraversalBT.Node;

/*
Binary tree traversal;
Depth first - PreOrder, InOrder, PostOrder
PreOrder  = visit - <root><left><right>
InOrder   = visit - <left><root><right>
PostOrder = visit - <left><right><root>

*/

public class DepthFirstTraversal {
		
	public static void main(String[] arg){
		
		DepthFirstTraversal dft = new DepthFirstTraversal();
		
		Node root = null;
		
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
		System.out.println("Pre-order traversal");
		dft.preOrderTraversal(root);
		System.out.println();
		System.out.println("In-order traversal");
		dft.inOrder(root);
		System.out.println();
		System.out.println("Post-order traversal");
		dft.postOrder(root);
	}
	
	// <root><left><right>
	public void preOrderTraversal(Node root){
		if(root == null) return;
		System.out.print(root.data +" ");
		if(root.left != null)  preOrderTraversal(root.left);
		if(root.right != null) preOrderTraversal(root.right);
	}
	
	// <left><root><right>
	// InOrder traversal will give element in sorted order;
	// Time complexity = O(n)
	public void inOrder(Node root){
		if(root == null) return;
		if(root.left != null) inOrder(root.left);
		System.out.print(root.data+" ");
		if(root.right != null) inOrder(root.right); 
	}	
	
	// <left><right><data>;
	// postOrder traversal
	public void postOrder(Node root){
		if(root == null) return;
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		System.out.print(root.data+" ");
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
		
		public Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
}

package algorithm.binaryTree;

import algorithm.binaryTree.ConstructBinarySearchTree.Node;

/*
 * InOrder successor in a Binary Search Tree
 * Function to find the successor 
*/

public class InOrderSucessorBST {
	
	public static void main(String arg[]){
		
		Node root = null;
		
		InOrderSucessorBST ios = new InOrderSucessorBST();
		
		root = ios.insert(root,20);
		root = ios.insert(root,25);
		root = ios.insert(root,15);
		root = ios.insert(root,17);
		root = ios.insert(root,5);
		root = ios.insert(root,3);
		root = ios.insert(root,7);
		root = ios.insert(root,40);
		root = ios.insert(root,22);
		root = ios.insert(root,30);
		root = ios.insert(root,45);
		
		Node nd = ios.getSuccessor(root, 17);
		System.out.println(nd);
	}
	/*
	 * Function to find InOrder successor in BST
	 * Time complexity = O(H)
	 * 
	*/
	public Node getSuccessor(Node root,int data){
			//Search the Node - O(h)
			Node current = find(root,data);
			if(current == null) return null;
			// Case 1: Node has right subtree
			if(current.right != null){
				return findMin(current.right);
			}
			// Case 2 : No right subtree
			else {
				Node successor = null;
				Node ancestor  = root;
				while(ancestor != current){
					
					if(current.data < ancestor.data){
						successor = ancestor;
						ancestor = ancestor.left;
					}else{
						successor = ancestor;
						ancestor = ancestor.right;
						
					}
					
				}
				return successor;
			}
	}
	
	public Node find(Node rt, int dt){
		if(rt.data == dt) return rt;
		if(dt < rt.data) return find(rt.left,dt);
		else return find(rt.right,dt);
	}
	
	
	public Node findMin(Node rt){
		while(rt.left != null) rt = rt.left;
		return rt;
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
	
	
	class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;
			this.left = right = null;
		}
	}

	

}

package algorithm.binarySearchTree;

public class MaxMinBinaryTree {
	
	public class Node {
		int dt;
		Node left;
		Node right;
		
		public Node(int data){
			this.dt = data;
			this.left = null;
			this.right = null;
		}	
	}

	public static void main(String arg[]) {
		MaxMinBinaryTree mmbt = new MaxMinBinaryTree();
		
		Node root = mmbt.new Node(2);
		Node n1 = mmbt.new Node(7);
		Node n2 = mmbt.new Node(5);
		Node n3 = mmbt.new Node(6);
		Node n4 = mmbt.new Node(9);	
		Node n5 = mmbt.new Node(1);
		Node n6 = mmbt.new Node(11);
		Node n7 = mmbt.new Node(4);
		
		root.left = n1;
		root.right = n2;
		
		n1.right = n3;
		n2.right = n4;
		
		n3.left = n5;
		n3.right = n6;
		
		n4.left = n7;
		
		System.out.println(mmbt.findMax(root));	
		System.out.println(mmbt.findMin(root));
	}

	public int findMax(Node rt){
		
		if(rt == null) return Integer.MIN_VALUE;
		
		int res = rt.dt;
		
		int lres = findMax(rt.left);
		int rres = findMax(rt.right);
		
		if(lres > res){
			res = lres;
		}
		if(rres > res){
			res = rres;
		}
		return res;
	}

	public int findMin(Node rt){
		
		if(rt == null) return Integer.MAX_VALUE;
		
		int res = rt.dt;
		
		int lres = findMin(rt.left);
		int rres = findMin(rt.right);
		
		if(lres < res) 
			res = lres;
		if(rres < res)
			res = rres;
		
		return res;
	}
		
}

package algorithm.binaryTree;

import java.util.Queue;
import java.util.LinkedList;
//Binary tree traversal
//breadth-first - level order traversal;
public class BreadthFirstTraversalBT {
	
		public static void main(String arg[]){
			
			BreadthFirstTraversalBT cbst = new BreadthFirstTraversalBT();
			Node root = null;
			
			root = cbst.insert(root,20);
			root = cbst.insert(root,25);
			root = cbst.insert(root,15);
			root = cbst.insert(root,17);
			root = cbst.insert(root,5);
			root = cbst.insert(root,3);
			root = cbst.insert(root,7);
			root = cbst.insert(root,40);
			root = cbst.insert(root,22);
			root = cbst.insert(root,30);
			root = cbst.insert(root,45);
			
			cbst.levelOrderTraverse(root);
			
		}
		
		public void levelOrderTraverse(Node root){
			
				Queue<Node> q = new LinkedList<Node>();
				q.add(root);
				
				while(!q.isEmpty()){
					Node current = q.poll();
					System.out.print(current.data +" ");
					if(current.left != null) q.add(current.left);
					if(current.right != null) q.add(current.right);
				}
				System.out.println();
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
		
		public class Node {
			int data;
			Node left;
			Node right;
			
			public Node(int data){
					this.data = data;
					this.left = this.right =null;
			}
			
		}
		
}

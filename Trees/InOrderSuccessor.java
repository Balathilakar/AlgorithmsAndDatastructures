package cracking.code.interviewQ.TreeGraph;


public class InOrderSuccessor {
	
	public static void main(String ag[]){
		
		InOrderSuccessor ios = new InOrderSuccessor();
		
		Node root = null;
		
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
		
		Node nd = ios.getInOrderSuccessor(root, 17);
		System.out.println(nd);
	}
	
public Node insert(Node rt,int value){
		
		if(rt == null)
			rt = new Node(value);
		else if(value <= rt.data)
			rt.left = insert(rt.left,value);
		else
			rt.right = insert(rt.right,value);
		return rt;
		
	}
	
	public Node getInOrderSuccessor(Node root,int k) {
		
		Node head = root;
		Node n = findNode(head,k);

		if(n.right != null){
			return findMin(n.right);
		}else {
			Node successor = null;
			Node ancestor = root;
			if(n != ancestor){
				if(n.data < ancestor.data){
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
	
	public Node findNode(Node n,int k){
		if(k == n.data){
			return n;
		}else if(k < n.data){
			return findNode(n.left,k);
		}else{
			return findNode(n.right,k);
		}
	}
	

	public Node findMin(Node n){
		while(n.left != null) n = n.left;
		return n;
	}
	
	static public class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int d){
				this.data = d;
		}
		
	}

}

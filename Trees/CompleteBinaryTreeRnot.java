package algorithm.binaryTree;

public class CompleteBinaryTreeRnot {
	
	public static void main(String arg[]){
		
		CompleteBinaryTreeRnot cbt = new CompleteBinaryTreeRnot();

		Node root = cbt.new Node(50);
		
		Node n1 = cbt.new Node(35);
		Node n2 = cbt.new Node(20);
		
		root.right = n2;
		root.left = n1;
		
		Node n3 = cbt.new Node(5);
		Node n4 = cbt.new Node(15);
		
		Node n5 = cbt.new Node(25);
		Node n6 = cbt.new Node(45);
		
		Node n7 = cbt.new Node(23);
		Node n8 = cbt.new Node(65);
	
		Node n9 = cbt.new Node(77);
		
		n1.left = n3;
		n1.right = n4;
		
		n2.left = n5;
		n2.right = n6;
		
		n4.left = n7;
		n4.right = n8;
		
		//n5.left = n9;
		
		int index = 0;
		int node_count = cbt.countNodes(root);
		if(cbt.isComplete(root,index, node_count)){
		System.out.println("The binary tree is complete");
		}else{
			System.out.println("The binary tree is not complete");
		}
	
	}
	 /* This function checks if the binary tree is complete or not */
    boolean isComplete(Node root, int index, int number_nodes)
    {
        // An empty tree is complete
        if (root == null)        
           return true;
  
        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index >= number_nodes)
           return false;
  
        // Recur for left and right subtrees
        return (isComplete(root.left, 2 * index + 1, number_nodes)
            && isComplete(root.right, 2 * index + 2, number_nodes));
  
    }
	
	//Count number of node in the binary tree
    public int countNodes(Node rt){
		
		if(rt == null)
			return 0; 
		return (1+ countNodes(rt.left)+countNodes(rt.right));		
	
	}
	
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;
			right = left = null;
		}
	}

	
}

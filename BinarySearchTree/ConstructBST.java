
import java.util.Scanner;

public class ConstructBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		
		Node root=null;
		
		int t = scan.nextInt();
		
		while(t-- > 0){
			int data = scan.nextInt();
			root =insert(root,data);
		}
		scan.close();
		//int height = findHeight(root);
		int height = findHeightOfTree(root);
		System.out.println("Height of the tree : "+height);
	}
	
	static public int findHeight(Node root){
		if(root == null)
			return 0;
		else{
			int lDepth = findHeight(root.left);
			int rDepth = findHeight(root.right);
			
			System.out.println(Math.max(lDepth , rDepth) + 1);
			
			if(lDepth > rDepth)
				return lDepth + 1;
			else
				return rDepth +1;
		}
	}
	
	static public int findHeightOfTree(Node root){
			
		if(root == null) return -1;
			return Math.max(findHeightOfTree(root.left), findHeightOfTree(root.right)) + 1;
	}
	
	public static Node insert(Node root, int data){
		
		if(root == null){
			return new Node(data);
		}
		if(data <= root.data){
			Node curr = insert(root.left,data);
			root.left = curr;
		}else if(data >= root.data){
			Node curr = insert(root.right, data);
			root.right = curr;
		}
		return root;
	}
	
	static public class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int d){
			this.data = d;
			left = null;
			right = null;
		}
	}

}

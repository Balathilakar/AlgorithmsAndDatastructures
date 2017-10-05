package algorithm.binaryTree;


public class HeightOfBST {

	public class Node {
	
		int dt;
		Node left;
		Node right;
		
		public Node(int data)
		{
			this.dt = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String arg[])
	{
		
		//	HashSet<Integer> hs = new HashMap<Integer,Integer>();
			HeightOfBST hbst = new HeightOfBST();
			Node root = hbst.new Node(15);
			
			Node n1 = hbst.new Node(10);
			Node n2 = hbst.new Node(20);
			Node n3 = hbst.new Node(8);
			Node n4 = hbst.new Node(12);
			Node n5 = hbst.new Node(17);
			Node n6 = hbst.new Node(25);
			
			root.left = n1;
			root.right = n2;
			
			n1.left = n3;
			n1.right = n4;
			
			n2.left = n5;
			n2.right = n6;
			
			int height = hbst.findHeight(root);
			System.out.println(height);
	}
	
	public int findHeight(Node rt)
	{
		if(rt == null) return -1;
		return Math.max(findHeight(rt.left),findHeight(rt.right)) + 1;
	}	

}
package cracking.code.interviewQ.TreeGraph;

/*
Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
*/

public class PathsWithSum {
	
	static public class TreeNode {
			int data;
			TreeNode left;
			TreeNode right;
			
			public TreeNode(int dt){
					this.data = dt;
			}
	}
	
	public static void main(String arg[]){
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		
		root.right.right = new TreeNode(11);
		
		root.left.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		
		root.left.right.right = new TreeNode(1);
		
		root.left.left.right = new TreeNode(-2);
		
		root.left.left.left = new TreeNode(3);
		
		PathsWithSum pws = new PathsWithSum();
		int totalPath = pws.countPathWithSum(root, 8);
		System.out.println(totalPath);				
	}
	
	
	int countPathWithSum(TreeNode root, int targetSum){
		if(root == null){
				return 0;
		}
		
		/*Count paths with sum starting from the root*/
		int pathFromRoot = countPathWithSumFromNode(root, targetSum, 0);
		
		/*Try the nodes on the left and right.*/
		int pathOnLeft = countPathWithSum(root.left, targetSum);
		int pathOnRight = countPathWithSum(root.right, targetSum);
		
		return pathFromRoot + pathOnLeft + pathOnRight;		
	}
		
	public int countPathWithSumFromNode(TreeNode node, int targetSum, int currentSum){
			
		if(node == null){
				return 0;
		}
		
		currentSum += node.data;
		
		int totalPaths = 0;
		
		if(targetSum == currentSum){
			totalPaths++;
		}
		
		totalPaths += countPathWithSumFromNode(node.left, targetSum, currentSum);
		totalPaths += countPathWithSumFromNode(node.right, targetSum, currentSum);
		
		return totalPaths;		
		
	}

}

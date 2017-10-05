package cracking.code.interviewQ.TreeGraph;

/*Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height.
*/
public class CreateMinimalBST{
	
	public static void main(String ag[]){
		CreateMinimalBST cmb = new CreateMinimalBST();
		
		int arr[] = {1,4,7,10,13,14,20,25,30,32};
		int end = arr.length - 1;
		Node root = cmb.createMinimalBST(arr,0,end);
		System.out.println(root);
	}
	
static class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;
			this.left = this.right = null;
		}		
	}

public Node createMinimalBST(int[] arr, int start, int end){
	if(end < start){
		return null;
	}
	int mid = (start + end)/2;
	Node rt = new Node(arr[mid]);
	
	rt.left = createMinimalBST(arr, start, mid-1);
	rt.right = createMinimalBST(arr, mid+1, end);
	return rt;
}

}

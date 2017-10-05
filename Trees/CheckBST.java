package cracking.code.interviewQ.TreeGraph;

public class CheckBST {

 /*-----------------------------------------------------------------------------------*/	

	int index = 0;
	
	public boolean isBST(Node node) {
		int arr[] = new int[node.size()];
		checkBST(node, arr);
		for(int i = 1;i < arr.length;i++){
			if(arr[i] <= arr[i-1]){
				return false;
			}
		}
		return true;
	}
	
	public void checkBST(Node node, int[] arr){
		if(node == null) return;
		checkBST(node.left, arr);
		arr[index++] = node.data;
		checkBST(node.right, arr);
	}
	
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data =  dt;
		}
		
		public int size(){
			return 0;
		}
	}
 /*-----------------------------------------------------------------------------------*/	
	
	
//Implement without having the array;

Integer last_Print = Integer.MIN_VALUE;
	
public boolean checkBST(Node head){
	
		if(head == null) return true;
		
		if(!checkBST(head.left)) return false;
		
		if(last_Print != Integer.MIN_VALUE && head.data <= last_Print){
			return false;	
		}
		
		last_Print = head.data;
		
		if(!checkBST(head.right)) return false;
		
		return true; //All good
	}
	
/*	------------------------------------------------------------------------------------*/
	
//All left nodes must be less than or equal to the current node, which must be less than all the right nodes;

public static void main(String ag[]){
	
	Node head = null;
	CheckBST cbst = new CheckBST();
	cbst.isBST(head,null,null);
}
	
public boolean isBST(Node node, Integer min, Integer max){
	
	if(node == null) return true;
	
	if((min != null && node.data <= min) || (max != null && node.data > max)){
		return false;
	}
	
	if(!isBST(node.left, min, node.data) || !isBST(node.right, node.data, max)){
		return false;
	}
	
	return true; // All good;
	
}

	
	
	
	
	
	
	
	
	
	
	
	
}

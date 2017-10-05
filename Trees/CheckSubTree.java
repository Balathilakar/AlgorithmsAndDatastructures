package cracking.code.interviewQ.TreeGraph;

/*Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical.*/

public class CheckSubTree {
	
	public class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;
		}
		
	}
	
	public static void main(String arg[]){
		Node t1 = null;
		Node t2 = null;
		CheckSubTree cst = new CheckSubTree();
		boolean isSubTree = cst.containSubtree(t1, t2);
	}
	
	public boolean containSubtree(Node t1, Node t2){
		
			StringBuilder string1 = new StringBuilder();
			StringBuilder string2 = new StringBuilder();
		
			 getOrderString(t1, string1);
			 getOrderString(t2, string2);
		
			return string1.indexOf(string2.toString()) != -1;
		
	}
	
	public void getOrderString(Node nd, StringBuilder str){
			if(nd == null){
				str.append("X"); // Add null indicator
				return;
			}
			str.append(nd.data+" ");	  // Add root
			getOrderString(nd.left, str); // Add left
			getOrderString(nd.right, str);// Add right
	}

	/*-------------------------------------------------------------------*/
	
	boolean containsTree(Node t1,Node t2){
				if(t2 == null){
					return true; // t2 is null which is subtree of t1
				}else{
					return subTree(t1,t2);
				}
	}
	
	public boolean subTree(Node r1, Node r2){
			if(r1 == null){
					return false;
			}else if(r1.data == r2.data && matchSubTree(r1,r2)){
				return true;
			}else{
				return subTree(r1.left,r2) || subTree(r1.right, r2);
			}
	}
	
	public boolean matchSubTree(Node r1, Node r2){
		if(r1 == null && r2 == null){
				return true; //nothing left in the subTree;
		} else if(r1 == null || r2 == null){
				return false; // exactly tree is empty, therefore tree doesn't match
		}else if(r1.data != r2.data){
				return false;
		}else{
			return matchSubTree(r1.left, r2.left) && matchSubTree(r1.right, r2.right);
		}		
	}	

	
	
	
	
	
	
}

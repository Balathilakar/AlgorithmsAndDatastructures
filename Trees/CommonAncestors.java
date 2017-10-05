package cracking.code.interviewQ.TreeGraph;

public class CommonAncestors {
	
/*---------------------------------------------*/	

static public class Node {
		
		int data;
		Node parent;
		Node left;
		Node right;
		
		public Node(int dt){
			this.data = dt;		
		}
}


/*---------------Solution #1: With Links to Parents---------------------------*/
/*This approach will take 0( d) time, where d is the depth of the deeper node.*/
/*----------------------------------------------------------------------------*/
public static void main(String[] ag){
	
	Node root = new Node(40);
	
	root.left = new Node(30);
	root.right = new Node(55);
	root.left.parent = root;
	root.right.parent = root;
	
	root.left.left = new Node(15);
	root.left.right = new Node(32);
	root.left.left.parent = root.left;
	root.left.right.parent = root.left;
	
	root.right.left = new Node(45);
	root.right.right = new Node(60);
	root.right.left.parent = root.right;
	root.right.right.parent = root.right;
	
	root.left.right.left = new Node(12);
	root.left.right.right = new Node(4);
	root.left.right.left.parent = root.left.right;
	root.left.right.right.parent = root.left.right;
	
	CommonAncestors ca = new CommonAncestors();
	Node p = root.right.left;
	Node q = root.left.right.left;
	
	
	Node ancestors = ca.getCommonAncestor(root,p,q);
	//Node ancestors = ca.findCA(p,q);
	System.out.println(ancestors);
}

public Node findCA(Node p, Node q){
	
	int diff = depth(p) - depth(q);
	Node first = diff > 0 ? q : p; // shallow depth
	Node second = diff > 0 ? p: q; // deep depth
	
	second = goUpBy(second,Math.abs(diff));
	
	// Check for common first ancestor exist or not
	while(first != second && first != null && second != null){
		first = first.parent;
		second = second.parent;
	}
	return (first == null || second == null) ? null : first;				
}

public int depth(Node nd){
	int depth = 0;
	
	while(nd != null){
		nd = nd.parent;
		depth++;
	}
	return depth;
}

public Node goUpBy(Node sec, int diff){
	for(int i = 0; i < diff;i++){
		sec = sec.parent;
	}
	return sec;
}

/*-------------------------------------------------------------*/
/*Solution #2: With Links to Parents (Better Worst-Case Runtime)
 This algorithm takes O(t) time, where tis the size of the subtree for the first common ancestor. In the
 worst case, this will be O( n), where n is the number of nodes in the tree. We can derive this runtime by
 noticing that each node in that subtree is searched once. */


public Node getCommonAncestor(Node rootTree, Node p, Node q){
	
	if(!cover(rootTree,p) || !cover(rootTree,q)){
		return null;
	}else if(cover(p,q)){
		return p;
	}else if(cover(q,p)){
		return q;
	}
	
	Node sibling = getSibling(p);
	Node parent = p.parent;
	
	while(!cover(sibling,q)){
		sibling = getSibling(parent);
		parent = parent.parent;
	}
	return parent;		
}

public boolean cover(Node root, Node n){
	if(root == null) return false;
	else if(root == n) return true;
	else {
	     return cover(root.left,n) || cover(root.right,n); 
	}
}	

public Node getSibling(Node n){
	if(n == null || n.parent == null){
		return null;
	}
	Node parent = n.parent;
	
	return parent.left == n ? parent.right : parent.left;
}

/*-------------------------------------------------------------*/
/*Solution #3: Without Links to Parents
 This algorithm runs in O(n) time on a balanced tree. This is because c overs is called on 2n nodes in the
 first call (n nodes for the left side, and n nodes for the right side). After that the algorithm branches left or
 right, at which point c overs will be called on 2rz nodes, then 2X, and so on. This results in a runtime
 of O(n).
*/


public Node commonAncestor(Node treeNode, Node p, Node q){
		/*Error check - one node is not in the tree*/
		
	if(!cover1(treeNode,p) || !cover1(treeNode,q)){
		return null;
	}
	return ancestorHelper(treeNode, p, q);
}

public Node ancestorHelper(Node root, Node p, Node q){
		
	if(root == null || p == null || q == null){
			return null;
	}
	
	boolean pIsOnLeft = cover1(root.left,p);
	boolean qIsOnRight = cover1(root.right,q);
	
	if(pIsOnLeft != qIsOnRight){ // Nodes are no the different side
		return root;
	}
	
	Node childSide = pIsOnLeft ? root.left : root.right;
	
	return ancestorHelper(childSide, p, q);
	
}

public boolean cover1(Node root,Node n){
	if(root == null) return false;
	else if(root == n) return true;
	else{
		return cover1(root.left,n) || cover1(root.right,n);
	}
}

/*Solution #4: Optimized
 * 
 *Below all codes are not working;
 * 
 * */

/*public class Result {
	
	public Node node;
	public boolean isAncestor;
	
	public Result(Node nd, boolean isAns){
		this.node = nd;
		this.isAncestor = isAns;
	}
	
}


public Node commonAncestorS4(Node root, Node p, Node q){
	 Result r = commonAncestorHelper(root,p,q);
	 if(r.isAncestor){
		 return r.node;
	 }else{
		 return null;
	 }
}


public Result commonAncestorHelper(Node root, Node p, Node q){
	
	if(root == null){
		return new Result(null,false);
	}
	
	if(root == p && root == q){
			return new Result(root,true);
	}
	
	Result lx = commonAncestorHelper(root.left, p, q);
	if(lx.isAncestor){
		return lx;
	}
	
	Result rx = commonAncestorHelper(root.right, p, q);
		if(rx.isAncestor){
			return rx;
		}
	
		if(lx.node != null || rx.node != null){
			return new Result(root,true);
		}else if(root == p || root == q) {
		    boolean isAncestor = lx.node != null || rx.node != null;
		    return new Result(root, isAncestor);
		} else {
			return new Result(lx.node != null ? lx.node : rx.node,false);
		}

}

*/



	
}

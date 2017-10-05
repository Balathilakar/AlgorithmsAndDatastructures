package cracking.code.interviewQ.LinkedList;

/*Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/
public class PartitionLL {
	
public class Node {
		
		int data;
		Node next;
		
		public Node(int str){
			this.data = str;
		}
	}

public static void main(String arg[]){
	PartitionLL fme = new PartitionLL();
	
	Node root = null;
	root = fme.createNode(3,root);
	root = fme.createNode(5,root);
	root = fme.createNode(8,root);
	root = fme.createNode(5,root);
	root = fme.createNode(10,root);
	root = fme.createNode(2,root);
	root = fme.createNode(2,root);
	
	Node mergeNode = fme.partition(root,5);
	
	System.out.println(mergeNode);
}

public Node partition(Node node,int x){
	
	Node beforeStart = null;
	Node beforeEnd = null;
	Node afterStart = null;
	Node afterEnd = null;
	
	while(node != null){
		
		Node next = node.next;
		node.next = null;
		
		if(node.data < x){
			if(beforeStart == null){
				beforeStart = node;
				beforeEnd = beforeStart;
			}else{
				beforeEnd.next = node;
				beforeEnd = node;
			}
		}else{
			if(afterStart == null){
				afterStart = node;
				afterEnd = afterStart;
			}else {
				afterEnd.next = node;
				afterEnd = node;
			}
		}
		node = next;	
	}
	
	if(beforeStart == null){
		return afterStart;
	}
	
	beforeEnd.next = afterStart;
	return beforeStart;
	
}

public Node createNode(Integer str, Node rt){
	
	Node root = rt;
	
	Node nd = new Node(str);
	
	if(root == null){
		root = nd;	
		return root;
	}
	
	while(root.next != null){
		root = root.next;
	}
	
	root.next = nd;
	return rt;
}

}

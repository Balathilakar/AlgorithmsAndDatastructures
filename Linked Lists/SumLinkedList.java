package cracking.code.interviewQ.LinkedList;

/*Sum value from head to tail*/

public class SumLinkedList {
	
	
static public class Node {
		
		int data;
		Node next;
		
		public Node(){
		
		}
		
		public Node(int str){
			this.data = str;
		}
	}

public static void main(String arg[]){
	SumLinkedList sll = new SumLinkedList();
	
	Node ls1 = null;
	
	ls1 = sll.createNode(7,ls1);
	ls1 = sll.createNode(1,ls1);
	ls1 = sll.createNode(6,ls1);		
	
	Node ls2 = null;
	
	ls2 = sll.createNode(5,ls2);
	ls2 = sll.createNode(9,ls2);
	ls2 = sll.createNode(2,ls2);
	
	Node result = addList(ls1, ls2,0);
	
	System.out.println(result);
}

/*public static Node addList(Node ls1,Node ls2,int carry){
	
	if(ls1 == null && ls2 == null && carry ==0){
		return null;
	}
	
	Node result = new Node();
	int value = carry;		
	
	if(ls1 != null){
		value += ls1.data;
	}
	if(ls2 != null){
		value += ls2.data;
	}
	
	result.data = value % 10; //set the second digit 
	
	if(ls1 != null || ls2 != null){
		Node more = addList((ls1.next == null) ? null:ls1.next, (ls2.next == null)?null:ls2.next,(value >= 10) ?1:0);
		result.next = more;
	}
	
	return result;
	
}*/


static public Node addList(Node ls1, Node ls2,int carry){
	
	if(ls1 == null && ls2 == null && carry == 0)  return null;
	
	int value = carry;
	
	if(ls1 != null){
		value += ls1.data;
	}
	
	if(ls2 != null){
		value += ls2.data;
	}
	
	Node result = new Node();
	
	result.data = value % 10;
	
	if(ls1!= null || ls2 != null){
		Node more = addList(ls1.next,ls2.next, value >= 10 ? 1:0);
		result.next = more;
	}
	return result;
}


public Node createNode(int dt, Node root){
	
	Node nd = new Node(dt);
	
	Node rt = root;
	
	if(root == null){
		root = nd;	
		return root;
	}
	
	if(rt.next != null){
		rt = rt.next;
	}
	
	rt.next = nd;
	return root;
}
	

}

package cracking.code.interviewQ.LinkedList;


/*Sum values from tail to head*/

public class PartialSum {
	
public class Node {
		
		int data;
		Node next;
		
		public Node(){
		
		}
		
		public Node(int str){
			this.data = str;
		}
	}
	
	public Node sum = null;
	public int carry = 0;
	
	public static void main(String arg[]){
		PartialSum sll = new PartialSum();
		
		Node ls1 = null;
		
		ls1 = sll.createNode(7,ls1);
		ls1 = sll.createNode(1,ls1);
		ls1 = sll.createNode(6,ls1);		
		
		Node ls2 = null;
		
		ls2 = sll.createNode(5,ls2);
		ls2 = sll.createNode(9,ls2);
		ls2 = sll.createNode(2,ls2);
		
		Node result = sll.addLists(ls1, ls2);
		
		System.out.println(result);
	}
	
	Node addLists(Node l1,Node l2){
			
		int len1 = length(l1);
		int len2 = length(l2);
			
		//Pad shorter with zero's	
		
		if(len1 < len2){
			l1 = padList(l1,len2 - len1);
		}else if(len2 < len1) {
			l2 = padList(l2,len1 - len2);
		}
		
		PartialSum sum = addListHelper(l1,l2);	
		
		//if there was a carry value left over, insert this at the front of the list
		//Otherwise return the linkedlist
		if(sum.carry == 0){
			return sum.sum;
		}else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}
	
	public PartialSum addListHelper(Node l1,Node l2){
			if(l1 == null && l2 == null){
					PartialSum sum = new PartialSum();
					return sum;
			}
			
			//Add smaller digits recursively
			PartialSum sum = addListHelper(l1.next, l2.next);
			
			//Add carry to current data;
			int val = sum.carry + l1.data + l2.data;
			
			//Insert sum of current digit;
			Node full_result = insertBefore(sum.sum, val % 10);
			
			// Return sum so far and the carry value
			sum.sum = full_result;
			sum.carry = val/10;
			return sum;
	}
	
	// Helper function to insert node in front of a linked list;
	public Node insertBefore(Node list, int data){
		Node node = new Node(data);		
		if(list != null){
				node.next = list;
		}
		return node;
	}
	
	public Node padList(Node node,int length){
			Node nd = new Node(0);
		for(int i = 0;i < length;i++){
				nd.next = node;
		}
		return nd;
	}
	
	
	public int length(Node nd){
		
		int count = 0;
		Node head = nd;
		
		while(head != null){
			count++;
			head = head.next;
		}
		
		return count;
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

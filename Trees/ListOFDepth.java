package cracking.code.interviewQ.TreeGraph;

import java.util.LinkedList;
import java.util.ArrayList;

public class ListOFDepth {
	
	public class Node{
		
		int data;
		Node left;
		Node right;

		public Node(int dt){
			this.data = dt;
		}
	}
	
	public static void main(String ag){
		ListOFDepth ld = new ListOFDepth();
		Node root = null;
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		ld.createLevelLinkedLists(root,lists,0);
		System.out.println(lists);
	}
	
	public void createLevelLinkedLists(Node root,ArrayList<LinkedList<Node>> lists,int level){
		
		if(root == null){
			return; //Base case
		}
		
		LinkedList<Node> list = null;
		if(lists.size() == level){
			list = new LinkedList<Node>();
			lists.add(list);
		}else{
			list =lists.get(level);
		}
		list.add(root);
		createLevelLinkedLists(root.left, lists,level+1);
		createLevelLinkedLists(root.right,lists,level+1);
	}
	
}

package cracking.code.interviewQ.TreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 Input:
				2
		1				3

 Output: {2, 1, 3}, {2, 3, 1}
*/
public class BSTSequences {
		
		static public class Node {
			
			int data;
			Node left;
			Node right;
			
			public Node(int dt){
				this.data = dt;				
			}
			
		}
	
		public static void main(String ag[]){
			
			Node node = null;
			node = new Node(2);
			node.left = new Node(1);
			node.right = new Node(3);
			//node.left.left = new Node(0);
			
			BSTSequences bs = new BSTSequences();
			ArrayList<LinkedList<Integer>> ll = bs.allSequences(node);
			System.out.println(ll);
		}
		
		public ArrayList<LinkedList<Integer>> allSequences(Node node){
			
			ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
			
			if(node == null){
				result.add(new LinkedList<Integer>());
				return result;
			}
			
			LinkedList<Integer> prefix = new LinkedList<Integer>();
			prefix.add(node.data);
			
			/*Recurse on left and right subtrees*/
			ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
			ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
			
			/*Weave together each list from left to right sides.*/	
			for(LinkedList<Integer> left : leftSeq){
				for(LinkedList<Integer> right : rightSeq){
					ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
					weaveLists(left, right, weaved, prefix);
					result.addAll(weaved);
				}
			}
			return result;
		}
		
		/* Weave lists together in all possible ways. This algorithm works by removing the
		 * head from one list, recursing, and then doing the same thing with the other
		 * list. */
		void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,
		LinkedList<Integer> prefix){
		/*One list is empty. Add remainder to [a cloned] prefix and store result*/	
		if(first.size() == 0 || second.size() == 0){
				LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
				result.addAll(first);
				result.addAll(second);
				results.add(result);
				return;
		}
		
		/* Recurse with head of first added to the prefix. Removing the head will damage
		 * first, so we'll need to put it back where we found it afterwards. */
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		/*Do the same thing with second, damaging and then restoring the list*/
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);	
			
		}
		
			
		
		
		
}

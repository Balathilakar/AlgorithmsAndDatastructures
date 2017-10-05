package dataStructure.LinkedList;

import java.util.List;
import java.util.ArrayList;

public class ReverseLLRecursion {
		
		Node head = null;
	
		public static void main(String arg[]){
			ReverseLLRecursion rLLr = new ReverseLLRecursion();
			rLLr.addNode(5);
			rLLr.addNode(10);
			rLLr.addNode(15);
			rLLr.addNode(20);
			rLLr.addNode(25);
			rLLr.addNode(30);
			rLLr.addNode(35);
			
			rLLr.reverseLL(rLLr.head);
			System.out.println(rLLr.head);
		}
		
		
		public void addNode(int dt){
			Node node = new Node(dt);
			Node temp = head;
			if(head == null){
				head = node;
				return;
			}
			
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;			
			
		}
		
		public void reverseLL(Node nd){
			
			if(nd.next == null){
				head = nd;
				return;
			}
			
			reverseLL(nd.next);
			Node q = nd.next;
				 q.next = nd;
				 nd.next = null;
			
		}
		
		public class Node{
			int data;
			Node next;
			
			public Node(int dt){
				this.data = dt;
			}
		}
		
}

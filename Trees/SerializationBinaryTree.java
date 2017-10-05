package algorithm.binaryTree;

import java.util.ArrayList; 

/*
 * pre-order traversal for serialization of binary tree
 * 
 * Deserialization of binary tree is below 
 * 
*/
public class SerializationBinaryTree {
	
		public static void main(String ag[]){
				System.out.println("Deserialization of binary tree");
		}
		
		public void serialize(Node root, ArrayList<Integer> array){
			if(root == null)
			{	
				// -1 when any node is null
				array.add(-1);
				return;
			}
			
			array.add(root.data);
			serialize(root.left, array);
			serialize(root.right,array);
			
		}
		
		class Node{
			
			int data;
			Node left;
			Node right;
			
			public Node(int dt){
				this.data = dt;
				this.left = right = null;
			}
		}
		
	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Deserialzation from pre-order traversal Array	
	 * [7,2,1,-1,-1,-1,5,3,-1-1,8,-1,-1] preorder  -1 is presence of null nod in an array
	 *  null = -1
	 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	*/
	
	int index = 0;
	
	Node deserialize(ArrayList<Integer> array)
	{	
		//Base condition
		if(index == array.size() || array.get(index) ==-1)
		{
			index += 1;
			return null;
		}
		
		Node root = new Node(array.get(index));
		
		index += 1;
		
		root.left = deserialize(array);
		root.right = deserialize(array);
		
		return root;
	}
			
}

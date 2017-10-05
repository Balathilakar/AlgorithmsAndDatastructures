package algorithm.binaryTree;

	//Construct binary search tree;
	//Search value in binary search tree;
	//Delete value in binary search tree;

	public class ConstructBinarySearchTree {
			
		public static void main(String arg[]){
			
			ConstructBinarySearchTree cbst = new ConstructBinarySearchTree();
			
			Node root = null;
			
			//Node nd = cbst.new Node(1);
			
			root = cbst.insert(root,20);
			root = cbst.insert(root,25);
			root = cbst.insert(root,15);
			root = cbst.insert(root,17);
			root = cbst.insert(root,5);
			root = cbst.insert(root,3);
			root = cbst.insert(root,7);
			root = cbst.insert(root,40);
			root = cbst.insert(root,22);
			root = cbst.insert(root,30);
			root = cbst.insert(root,45);
			
			System.out.println(cbst.NumOfNode(root));
			
			if(cbst.search(root,3)){
				System.out.println("The search element present in the BST");
			}else {
				System.out.println("The search element not present in the BST");
			}
			
			root = cbst.delete(root, 45);
			
			System.out.println(cbst.NumOfNode(root));
			
			System.out.println("Root");		
		}
		
		public int NumOfNode(Node nd){
				
			if(nd == null)
					return 0;
			else{
					return NumOfNode(nd.left) + NumOfNode(nd.right) +1;
			}
		}
		//Delete node from binary search tree
		public Node delete(Node root,int value){
			
			if(root == null) return root;
			else if(value < root.data) root.left = delete(root.left,value); 
			else if(value > root.data) root.right = delete(root.right,value);
			else{
					//Case :01 - no child
					if(root.left == null && root.right == null){
						  root = null;
					//Case :02 - one child
					}else if(root.left == null) {
						  root = root.right;
					}else if(root.right == null){
						  root = root.left;
					//Case :03 - two child
					}else{
						Node temp = findMinInRight(root.right);
						root.data = temp.data;
						root.right = delete(root.right,temp.data);
					}
			}
			return root;
		}
		
	
		public Node findMinInRight(Node nd){
			
			if(nd == null){
				return null;
			}else {
				return nd;
			}
		}
	
		
		public boolean search(Node rt,int s){
			if(rt == null) return false;
			else if(s == rt.data) return true;
			else if(s < rt.data) return search(rt.left,s);
			else return search(rt.right,s);
		}
		
		public Node insert(Node rt,int value){
		
			if(rt == null)
				rt = getNewNode(value);
			else if(value <= rt.data)
				rt.left = insert(rt.left,value);
			else
				rt.right = insert(rt.right,value);
			return rt;
			
		}
		
				
		public Node getNewNode(int vl){
			Node n = new Node(vl);
			return n;
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
		
	}

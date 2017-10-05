package algorithm.binaryTree.LevelOfNode;

import java.io.ObjectInputStream.GetField;

//Find the level of node;

public class FindLevelOfNode {
		public static void main(String ag[]){
			Node root = newNode(3);			
			int x = 16;
			
			root.left 		= newNode(2);
			root.right 		= newNode(5);
			root.left.left 	= newNode(1);
			root.left.right = newNode(4);
			root.left.right.right = newNode(16);
			
			//for(x = 1;x <= 6;x++){
				int level = getLevelUtil(root, x, 0);
				if(!(level == 0)){
				System.out.printf("Level of %d is %d \n",+x,level);
			}else{
				System.out.printf("%d is not present in the tree \n",x);
			}
//		}	
		}
		
		public static Node newNode(int data){
			 Node temp = new Node();
			 temp.data = data;
			 temp.left = null;
			 temp.right = null;
			 return temp;
		}
		
		//getLevel() method returns level of the data if the data is present in tree, otherwise return 0;
		public static int getLevelUtil(Node node,int data,int level){
			if(node == null){
				return 0;
			}
			if(node.data == data){
				return level;
			}			
			int downlevel = getLevelUtil(node.left, data, level+1);
			if(downlevel != 0){
				return downlevel;
			}
			downlevel = getLevelUtil(node.right,data, level+1);
			return downlevel;
		}
		
}

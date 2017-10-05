package cracking.code.interviewQ;

/*Input
1  2  3
4  5  6
7  8  9

Output:
7  4  1 
8  5  2 
9  6  3 */

public class RotateMatrix90 {
		
	public static void main(String arg[]){
		
				
		RotateMatrix90 rm90 = new RotateMatrix90();
		int[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		rm90.rotate(matrix);
		System.out.println(matrix);
		
	}
	
	public boolean rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		
		for(int layer = 0;layer < n/2;layer++){
				int first = layer;
				int last = n - 1 - layer;
				
				for(int i = first;i < last;i++){
					int offset = i - first;
					int top = matrix[first][i]; // save top
					
					//left  -> top 
					matrix[first][i] = matrix[last - offset][first];
					
					//bottom -> left
					matrix[last-offset][first] = matrix[last][last-offset];
					
					//right -> bottom
					matrix[last][last-offset] = matrix[i][last];
					
					//top -> right
					matrix[i][last] = top; // right <- saved top
					
					
				}
		}
		
		return true;
		
	}
	

}

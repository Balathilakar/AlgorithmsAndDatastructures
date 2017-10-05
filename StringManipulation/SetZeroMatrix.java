package cracking.code.interviewQ;

public class SetZeroMatrix {
	
	
public static void main(String [] ag){
		
		int matrix[][] = {{1,0,5,2,3},{3,6,1,6,4},{7,3,1,0,9}};
		
		SetZeroMatrix sz =new SetZeroMatrix();
		
		sz.setZeros(matrix);
		
		System.out.println(matrix);
	
	}
	
	
	public void setZeros(int[][] matrix){
		
		boolean rows[] = new boolean[matrix.length];
		boolean cols[] = new boolean[matrix[0].length];
		
		for(int i = 0;i < matrix.length;i++){
			for(int j = 0;j < matrix[0].length;j++){
				if(matrix[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
	
	//nullifyRows
	for(int i = 0;i < rows.length;i++){
		if(rows[i]) nullifyrows(matrix,i); 
	}	
	
	//nullifyCols
	for(int i = 0;i < cols.length;i++){
		if(cols[i]) nullifyCols(matrix,i);
	}
	
	System.out.println(matrix);
	
	}
	
	public void nullifyrows(int[][] matrix, int row){
		for(int j = 0;j < matrix[0].length;j++){
			matrix[row][j] = 0;		
		}
	}	
	
	
	public void nullifyCols(int[][] matrix, int cols){
		for(int j = 0;j < matrix.length;j++){
			matrix[j][cols] = 0;
		}
	}	

}

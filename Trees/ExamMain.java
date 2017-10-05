package algorithm.binaryTree;

public class ExamMain {

public static void main(String[] args) {
        
        
        int cityWidth=3;
        int cityLength=5;
        int[] xCordinates ={1};
        int[] yCordinates={1};
    
        printMatrix(cityWidth,cityLength,xCordinates,yCordinates);
        
        
    }

    private static int [][] printMatrix(int cityWidth, int cityLength,
            int[] xCordinates, int[] yCordinates) {
        
    	int abc[][] = new int[cityLength][cityWidth];
    	
        for(int i=0;i<cityLength;i++){
            for(int j=0;j<cityWidth;j++){
                int lockDistance=findNearestLocker(i,j,xCordinates,yCordinates);
                abc[i][j] =lockDistance;
            }
            System.out.println();
        }
        
       return abc; 
    }

    private static int findNearestLocker(int i, int j, int[] xCordinates,
            int[] yCordinates) {
        int totalLocker= xCordinates.length;
        int distance=Integer.MAX_VALUE;
        for(int l=0;l<totalLocker;l++){
            int x=xCordinates[l];
            int y =yCordinates[l];
            int tempDistance=Math.abs(x-j-1)+Math.abs(y-i-1);
            if(distance>tempDistance){
                distance=tempDistance;
            }
        }
        return distance;
    }

    
}

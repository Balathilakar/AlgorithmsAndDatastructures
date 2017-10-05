package cracking.code.interviewQ.BitManipulation;

/*Conversion : Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
EXAMPLE
Input: 29 (or: 11101), 15 (or: 01111)
Output: 2
*/

public class Conversion {
	
	public static void main(String ag[]){
		System.out.println(findBitSwapRequired(29, 15));
	}
	
/*public static int findBitSwapRequired(int a, int b) {
		
		int count = 0;
		
		System.out.println("A " +Integer.toBinaryString(a));
		System.out.println("B " +Integer.toBinaryString(b));
		System.out.println("A^B "+Integer.toBinaryString(a^b));
		
		for(int c = a ^ b; c != 0; c >>>= 1){
			count += c & 1;
		}
		return count;
}*/
	
	public static int findBitSwapRequired(int a, int b) {
		
		int count = 0;
		
		for(int c = a ^ b; c != 0; c = c & (c - 1)){
			count++;
		}
		return count;	
	}

}

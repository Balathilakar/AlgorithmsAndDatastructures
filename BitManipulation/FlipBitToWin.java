package cracking.code.interviewQ.BitManipulation;

/*Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
find the length of the longest sequence of ls you could create.
EXAMPLE
Input: 1775
Output: 8
(or: 11011101111)*/

public class FlipBitToWin {
	
	public static void main(String arg[]){
					FlipBitToWin fbw = new FlipBitToWin();
					fbw.flipBit(1775);
	}
	
	int flipBit(int a){
			if(~a == 0) return a;
			
			int currentLength = 0;
			int previousLength = 0;
			
			int maxLength = 1;  // We can always have a sequence of at least one 1;
			
			while(a != 0){
				System.out.println(Integer.toBinaryString(a));
				
					if((a & 1) == 1){  //Current bit is a 1;
							currentLength++;
					}else if ((a & 1) == 0){ //Current bit is a 0
						/* Update to 0 (if next bit is 0) or CurrentLength(if next bit is 1). */
						previousLength = (a & 2) == 0 ? 0 : currentLength;
						currentLength = 0;
					}
					
				maxLength = Math.max(previousLength + currentLength + 1, maxLength);
				a >>>= 1;

			}
			return maxLength;
	}
}

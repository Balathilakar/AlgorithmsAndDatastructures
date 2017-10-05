package cracking.code.interviewQ.BitManipulation;

import java.math.BigInteger;

/*Input: N 10000000000, M	10011, i 2, j 6
Output: N = 10001001100
*/

public class InsertionBit {
	
	public static void main(String ag[]){
			InsertionBit ibit = new InsertionBit();
			BigInteger bg = new BigInteger("10000000000");
			updateBits(bg, 10011, 2, 6);
	}
	
	static public int updateBits(BigInteger n, int m, int i, int j){
		
		/* Create a mask to clear bits i through j in n. EXAMPLE: i = 2, j = 4. Result
		 * should be 11100011. For simplicity, we'll use just 8 bits for the example. */
		int allOnes = ~0;	// will equal sequence of all 1s
		
		// 1s before position j, then 0s. left = 11100000
		int left = allOnes << (i + 1);
		
		// 1's after position i. right = 00000011
		int right = ((1 << i) - 1);
		
		//All 1s, except for 0's between i and j. mask = 11100011
		int mask = left | right;
		
		 
		/* clean bits j through i then put m in there */
		int n_cleared = n.byteValue() & mask; // Clears bits j through i.
		int m_shifted = m << i; // Move m into correct position.		
		
		return n_cleared | m_shifted; // Or them, and we are done!
	}

}

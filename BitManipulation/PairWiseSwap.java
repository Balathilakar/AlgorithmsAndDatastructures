package cracking.code.interviewQ.BitManipulation;

/*
 * Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
*/

public class PairWiseSwap {
	
		public static void main(String ag[]){
			System.out.println(Integer.toBinaryString(120));
			int oddEven = swapOddEvenBits(120);
			System.out.println(oddEven);
			System.out.println(Integer.toBinaryString(oddEven));
		}
		
		public static int swapOddEvenBits(int x){
			/*
			 *	x 				= 1111000
			 * 	x & 0xaaaaaaaa 	= 0101000
			 *  x & 0x55555555  = 1010000
			 * 		
			 */
			System.out.println(Integer.toBinaryString(x & 0xaaaaaaaa));
			System.out.println(Integer.toBinaryString(x & 0x55555555));
			System.out.println(Integer.toBinaryString((x & 0xaaaaaaaa)  >>> 1));
			System.out.println(Integer.toBinaryString((x & 0x55555555) << 1));
			
			return ((x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1);
		}

}

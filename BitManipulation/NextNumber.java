package cracking.code.interviewQ.BitManipulation;

public class NextNumber {
	
	public static void main(String ar[]){
		NextNumber nn = new NextNumber();
		//System.out.println(Integer.toBinaryString(13948));
		//int next = nn.getNext(13948);
		//System.out.println(next);
		//System.out.println(Integer.toBinaryString(next));
		System.out.println("13948");
		System.out.println(Integer.toBinaryString(13948));
		int prev = nn.getPrev(13948);
		System.out.println(prev);
		System.out.println(Integer.toBinaryString(prev));
	}
	
	public int getNext(int n){
			/*Compute c0 and c1*/
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while(((c & 1) == 0) && (c != 0)){
			c0++;
			c >>= 1;
		}
		
		/*Error: if n == 11..1100...00, then there is no bigger number with the same number of 1s*/
		
		if(c0 + c1 == 31 || c0 + c1 == 0){
				return -1;
		}
		
		int p = c0 + c1; // position of rightmost non-tailing zero
		
		n  |= (1 << p);  // Flip rightMost non-tailing zero
		
		n &= ~(1 << p) -1; // Clear all bits to the right of P
		
		n |= (1 << (c1 - 1)) - 1; // insert (c1-1) ones on the right.
		
		return n;
		
	}
	
	public int getPrev(int n){
			int temp = n;
			int c0 = 0;
			int c1 = 0;
			
			while((temp & 1) == 1){
					c1++;
					temp  >>= 1;
			}
			
			while(((temp & 1) ==0 ) && (temp != 0)){
				c0++;
				temp >>= 1;
			}
			
			int p = c0 + c1; 	// position of rightmost non- tailing one - Initial number
			n &= ((~0) << (p + 1));  // clears from bit p onwards
			
			/* the above one line can be written as  
			 * int a = ~0;		      = -1	// Sequence of 1s
			 * int b = a << (p + 1);  = -8
			 * n &= b;                =    // 11011001111100 & 11000 = 11011001111000 
			 * 
			 */
			
			System.out.println(Integer.toBinaryString(n));
			int mask = (1 << (c1 + 1)) 	- 1; // Sequence of (c1 + 1) ones
			
			n |= mask << (c0 - 1);
			
			return n;			
	}
	
	

}

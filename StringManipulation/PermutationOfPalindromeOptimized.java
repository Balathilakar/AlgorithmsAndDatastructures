package cracking.code.interviewQ;

public class PermutationOfPalindromeOptimized {
	
	public static void main(String ag[]){
		PermutationOfPalindromeOptimized pop = new PermutationOfPalindromeOptimized();
		System.out.println(pop.isPermutataionOfPalindrome("Tact Coa"));
	}
	
	/*Map each character to a number a -> 0 b -> 1 c -> 3 etc
	This case insensitive and non-letter characters map to -1*/
	public int getCharNumber(Character c){
	
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		
		if(val <= a && val <= z){
			return val - a;
		}		
		return -1;
	}
	
	public boolean isPermutataionOfPalindrome(String phase){
		int countOdd = 0;
		
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(char c : phase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
				if(table[x] % 2 == 1){
					countOdd++;
				}else{
					countOdd--;
				}
			}
			
		}
		return countOdd <= 1;
	}
	
}

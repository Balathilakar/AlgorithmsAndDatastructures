package cracking.code.interviewQ;

public class PermutationOfPalindrome {
	
		public static void main(String arg[]){
			PermutationOfPalindrome pp = new PermutationOfPalindrome();
			System.out.println(pp.isPermutationOfPalindrome("abbcceedd"));
		}
		
		public boolean isPermutationOfPalindrome(String phase){
			int[] table = buildCharFrequencyTable(phase);
			return checkMaxOneOdd(table);
		}
		
		/*Map each character to a number a -> 0 b -> 1 c -> 3 etc
		This case insensitive and non-letter characters map to -1*/
		public int getCharNumber(Character c){
		
			int a = Character.getNumericValue('a');
			int z = Character.getNumericValue('z');
			int val = Character.getNumericValue(c);
			
			if(a <= val || val <= z){
				return val - a;
			}		
			return -1;
			
		}
		
		//Count how many times the character appears
		public int[] buildCharFrequencyTable(String phase){
		
		int[] table = new int[Character.getNumericValue('z') - 
				Character.getNumericValue('a') + 1];
				
		for(char c : phase.toCharArray()){
			int x = getCharNumber(c);
			
			if(x != -1){
				table[x]++;
			}
		}
		return table;
		}

		
		//Check no more than one character has an odd number;
		public boolean checkMaxOneOdd(int[] table){
			boolean oddFound = false;	
			
			for(int x : table){
				if(x %2 != 0){
					if(oddFound){
						return false;
					}
					oddFound = true;
				}
			}
			return true;
		}
	
}

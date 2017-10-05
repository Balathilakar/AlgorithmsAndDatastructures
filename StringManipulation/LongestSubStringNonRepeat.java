package string.manipulation;

/*Longest Substring with non-Repeating Characters
 * Input : ABCDABDEFGCABD
 * Output: ABDEFGC
 * http://www.ideserve.co.in/learn/longest-substring-with-non-repeating-characters
*/

public class LongestSubStringNonRepeat {
	
	public static void main(String args[]){
		String str = "ABCDABDEFGCABD";
		String longestSubString = getLongestSubStringNonRepeatingChars(str);
		System.out.println("Longest substring non repeating chars by linear time method:\t"+longestSubString);
	}
	
	//Linear time algorithm for finding the longest substring without repeating character
	
	public static String getLongestSubStringNonRepeatingChars(String str){
			
		if(str == null){
			return null;			
		}
		
		int n = str.length();
		
		if(n < 2){
			return str;
		}
		
		int[] charIndexes = new int[256];
		//array to store last index of string characters seen in string, initialized to -1
		for(int i = 0;i < 256;i++){
			charIndexes[i] = -1;
		}
		
		//set index of first character
		charIndexes[str.charAt(0)] = 0;
		
		int currLength = 1; //Length of current non-repecting substring
		int maxLength = 1;	//Length of longest substring with non repeating characters found
		int prevIdx = 0;	//Previous index of current charactor
		int startIdx = 0;	//Starting index of longest substring with non repeating characters found		
		
		for(int i = 1;i < n;i++){
			prevIdx = charIndexes[str.charAt(i)];
			if(prevIdx == -1 || i - currLength > prevIdx){
				currLength ++;
			}else{
				if(currLength > maxLength){
					maxLength = currLength;
					startIdx = i - maxLength;
				}
				currLength = i -prevIdx;
			}
			charIndexes[str.charAt(i)] = i;
		}
		
		//Check if longest substring with non repeating characters ends at ends of the string
		if(currLength > maxLength){
			maxLength = currLength;
			startIdx = n - maxLength;
		}
		return str.substring(startIdx, startIdx+maxLength);
	}
	
}

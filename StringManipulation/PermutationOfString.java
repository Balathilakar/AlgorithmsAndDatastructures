package string.manipulation;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class PermutationOfString {
	
/*	public static void main(String[] args) {
		String str = "abc";
		HashSet<String> permutations = getAllPermutations(str);
		System.out.println(permutations.toString());
	}
	
	public static HashSet<String> getAllPermutations(String str){
		
		HashSet<String> permutations = new HashSet<String>();
		
		if(str == null || str.length() ==0 ){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainingString = str.substring(1);
		
		HashSet<String> words = getAllPermutations(remainingString);
		for(String word:words){
			for(int i = 0;i <= word.length();i++){
				String prefix = word.substring(0,i);
				String suffix = word.substring(i);
				permutations.add(prefix + first +suffix);
			}
		}
		return permutations;
	}*/ 
	
	/*public static void main(String arg[]){
		String str = "ABC";
		HashSet<String> hashset = getAllPermutations(str);	
		System.out.println(hashset.toString());
	}
	
	public static HashSet<String> getAllPermutations(String str){
		
		HashSet<String> permutations = new HashSet<String>();
		
		if(str == null || str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainingString = str.substring(1);
		
		HashSet<String> words = getAllPermutations(remainingString);
		
		for(String word : words){
			for(int i=0;i<=word.length();i++){
				String prefix = word.substring(0,i);
				String suffix = word.substring(i);
				permutations.add(prefix+first+suffix);
			}
		}
		
		return permutations;
		
	}
*/

/*public static void main(String agr[]){
		
		Pattern pt = Pattern.compile("ab");
		Matcher mt = pt.matcher("abcdabkab");
		int count = 0;

		while(mt.find()){
			count++;
			System.out.print(mt.start());
		}
		System.out.println();
		System.out.print(count);
	}
*/
	public static void main(String ags[]) {
		permutations("","ABC");		
	}
	
	public static void permutations(String perm,String word){
		
		if(word.isEmpty()){
			System.out.println(perm);
		}else{
			for(int i = 0;i < word.length();i++){
				permutations(perm+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
			}
		}	
	}

	
	
}
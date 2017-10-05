package string.manipulation;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesLetterInString {
	
//Convert String to char array and remove duplicates	
/*public static void main(String ag[]){
		
		String str = "aereddakwertreka";
		char[] ch = str.toCharArray();
		int n = ch.length;
		Arrays.sort(ch);
		System.out.println(str);
		System.out.println(ch.length);
		
		for(int i = 1;i < n;i++){
			if(ch[i] == ch[i-1]){
				int j = i;
				while(j != n-1){
					ch[j] = ch[j+1];
					j++;
				}
				n = n-1;
				i = i -1;
			}
		}
		System.out.println(ch.length);
		ch = Arrays.copyOf(ch,n);
		System.out.println(new String(ch));
	}*/

	public static void main(String arg[]){
		String str = "aereddakwertreka";
		
		char[] ch = str.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		
		for(Character c : ch){
			set.add(c);
		}
		System.out.println(str);
		System.out.println(set.toString());
		
	}

}

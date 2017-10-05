package string.manipulation;

import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagram implements Comparator<String> {
		
	public static void main(String arg[]){
		String[] strArray = {"abcd","abc","abce", "acd","abdc","abc","acb","ecba"};
			
		Arrays.sort(strArray,new GroupAnagram());
		System.out.println(strArray);
	}
	
	@Override
	public int compare(String s,String s1){
		return sortChar(s).compareTo(sortChar(s1));
	}
	
	public String sortChar(String srt){
		char[] content = srt.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
		
}

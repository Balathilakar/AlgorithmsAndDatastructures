package cracking.code.interviewQ;

import java.util.Arrays;

public class CheckPermutation {
	
	public static void main(String ag[]){
		CheckPermutation cp = new CheckPermutation();
		System.out.println(cp.checkPermArray("god","dog"));
	}
	
	//check if two string identical character count
	
public boolean checkPermArray(String s, String t){
		
		int[] s_array = new int[128];
		
		for(int i = 0;i < s.length();i++){
			int k = s.charAt(i);
			s_array[k]++;			
		}	
		
		for(int j = 0;j < t.length();j++){
			int k = t.charAt(j);
			s_array[k]--;
			if(s_array[k] < 0){
				return false;
			}
		}
		
		return true;
	
	}
	
	public boolean checkPerm(String s, String t){
		if(s.length() != t.length()) return false;
		return sort(s).equals(sort(t));
	}
	
	public String sort(String str){
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}	
	
}

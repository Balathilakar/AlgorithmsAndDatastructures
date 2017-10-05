package string.manipulation;

import java.util.ArrayList;
import java.util.Collections;

public class LargestRepitativeSeq {
	
	public static void main(String ags[]){
		
		String s="ABCDABDEFGCABD";
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0;i < s.length();i++)
		{
			list.add(s.substring(i,s.length()));			
		}	
		
		Collections.sort(list);
		
		String rep ="";
		int longest = 0;
		
		for(int i = 1; i < list.size();i++){
			
			String st = list.get(i);
			String st1 = list.get(i-1);
			int maxlength = 0;
			for(;maxlength < Math.min(st.length(),st1.length());maxlength++){
				if(st.charAt(maxlength) != st1.charAt(maxlength)) break;
			}
			
			if(maxlength>longest){
				longest = maxlength;
				rep = st.substring(0,maxlength);
			}
		}
		
		System.out.println(rep +" sequence of length"+longest);
		}


}

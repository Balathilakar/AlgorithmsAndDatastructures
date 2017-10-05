package string.manipulation;

import java.util.List;

public class HasStringUniCharacter {
	
	public static void main(String arg[]){

		isUniqueChar("FlyFlower");

	}

	public static boolean isUniqueChar(String str){

		if(str.length() > 128) return false;
	
 		
		boolean char_str[] = new boolean[128];
		
		for(int i = 0;i < 128;i++){		
			int val = str.charAt(i); 

			if(char_str[val]){
				return false;	
			}
			char_str[val] = true;	
		}
		return false;

	}

	

}

package string.manipulation;

import java.util.Arrays;

public class RemoveSpaceString {
	
	public static void main(String arg[]){
		String s = "Hi,how are you";
		char[] str = s.toCharArray();
		RemoveSpaceString rs = new RemoveSpaceString();
		System.out.println(str.length);
		System.out.println(str);
		str = rs.removeSpace(str,0,str.length-1);
		System.out.println(str.length);
		System.out.println(new String(str));
	}

	public char[] removeSpace(char[] a,int start, int end){
			int numSpaces = 0;
			for(int i = 0;i <=end;i++){
				if(a[i]==' ' && i > 0){
					numSpaces += 1;
				}else{
					a[i-numSpaces] =a[i];
				}
			}
			
			a = Arrays.copyOf(a, a.length-numSpaces);
			return a;
	}
	
	
	
}

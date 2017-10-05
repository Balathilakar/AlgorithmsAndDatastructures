package cracking.code.interviewQ;

/*Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"*/

public class URLLify {
		
	public static void main(String[] arg){
		
		char[] str = "Mr John Smith    ".toCharArray();
		URLLify u = new URLLify();
		u.replaceSpaces(str,13);
	}
	
	public void replaceSpaces(char[] str,int trueLength){
			int spaceCount = 0, index, i = 0;
			
			for(;i < trueLength;i++){
				if(str[i] == ' '){
					spaceCount++;
				}
			}
			
			index = trueLength + spaceCount*2;
			
			if(trueLength < str.length) str[trueLength] = '\0';
			
			for(i = trueLength - 1;i >= 0; i--){
				if(str[i] ==' '){
					str[index - 1] = '0';
					str[index - 2] = '2';
					str[index - 3] = '%';
					index = index - 3;
				}else{
					str[index - 1] = str[i];
					index--;
				}
			}
		System.out.println(new String(str));	
	}
	
}

package cracking.code.interviewQ;

public class StringCompress {
	
	public static void main(String ar[]){
		StringCompress sc = new StringCompress();
		System.out.println(sc.getStringCompress("aabcccccaaa"));;
	}
	
	public String getStringCompress(String str){
			
			String compressString = "";
			int consecutiveCount = 0;
			
		for(int i = 0;i < str.length();i++){
			consecutiveCount++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressString +=""+str.charAt(i) + consecutiveCount;
				consecutiveCount=0;
			}
		}
		
		return compressString.length() < str.length() ? compressString:str;
			
	}

}

package cracking.code.interviewQ;

/*Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures*/

public class StringAllUniqueCharacter {
	
		public static void main(String arg[]){
			StringAllUniqueCharacter sluc = new StringAllUniqueCharacter();
			boolean b = sluc.allUnique("JacJ");
			
			System.out.println(b);
			
		}
		
		public boolean allUnique(String str){

			if(str.length() > 128){
				return false;
			}
			
			boolean[] br = new boolean[128];
			
			for(int i = 0;i < str.length();i++){
				
				int k = str.charAt(i);
				
				if(br[str.charAt(i)]){
					return false;
				}else{
					br[str.charAt(i)] = true;
				}
			}
			
			return true;
				
		}
	
}

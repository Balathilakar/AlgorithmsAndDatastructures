package cracking.code.interviewQ;

/*pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false*/

public class OneAwayDiff {
	
	public static void main(String ar[]){
		OneAwayDiff oa = new OneAwayDiff();
		System.out.println(oa.IsOneAway("palas","pale"));		
	}
	
	public boolean IsOneAway(String str, String str1){
		if(str.length() == str1.length()){
			return isOneEditInsert(str,str1);
		}else if(str.length()+1 == str1.length()){
			return isOneEditInsert(str,str1);
		}else if(str.length() - 1 == str1.length()){
			return isOneEditInsert(str,str1);
		}
		return false;
	}
	
public boolean isOneEditInsert(String str, String str1){
		
		String s1 = str.length() < str1.length() ? str : str1;
		String s2 = str.length() < str1.length() ? str1 : str;
		
		int index = 0;
		int index1 = 0;
		boolean founddifference = false;		
		
		while(index < s1.length() && index1 < s2.length()){
			if(s1.charAt(index) != s2.charAt(index1)){
				if(founddifference) return false;
				founddifference = true;
				if(str.length() == str1.length()){
					index++;
				}
			}else{
				index++;
			}
			index1++;
		}
		
		return true;
	}
	
	/*public boolean isOneEditInsert(String str,String str1){
		
		 int index0 = 0;
		 int index1 = 0;
		 
		 while(index0 < str.length() && index1 < str.length()){
		 		if(str.charAt(index0) != str1.charAt(index1)){
		 			if(index0 != index1){
		 				return false;
		 			}
		 			index1++;
		 		}else{
		 			index0++;
		 			index1++;
		 		}
		 }	
		 return true;
	}
	
	public boolean isOneEditReplace(String s1, String s2){
		boolean foundDifference = false;
		
		for(int i = 0;i < s1.length();i++){
		
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifference) return false;
				foundDifference = true;
			}
			
		}
		return true;
	}*/

}

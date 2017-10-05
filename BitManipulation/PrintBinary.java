package cracking.code.interviewQ.BitManipulation;

public class PrintBinary {
	
	public static void main(String[] ag){
		PrintBinary pb = new PrintBinary();
		System.out.println(pb.printBinary(4));
	}
	
	public String printBinary(double num){
		
		/*if(num >= 1 && num <= 0){
				return "Error";
		}*/
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num > 0){
			/*Setting a limit on length: 32 characters*/
			if(binary.length() >= 32){
				return "Error";
			}
	
		double r = num*2;
		if(r >= 1){
			binary.append(1);
			num = r - 1;
		}else{
			binary.append(0);
			num = r;
		}
	  }
	return binary.toString();
	}
}

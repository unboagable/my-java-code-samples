package solutions;

public class BitManipulation {
	//ctci:P5.5
	public static int bitsRequiredToConvert(int A, int B){
		String bitA=Integer.toBinaryString(A);
		String bitB=Integer.toBinaryString(B);
		int iA=bitA.length()-1;
		int iB=bitB.length()-1;
		int switchCount=0;
		while((iA >= 0) && (iB >= 0)){
			if (bitA.charAt(iA) != bitB.charAt(iB)){
				switchCount++;
			}
			iA--;
			iB--;
		}
		if (iA == iB){
			return switchCount;
		}else if (iA >= 0){
			for (int i=0;i<(iA+1);i++){
				if (bitA.charAt(i)=='1'){
					switchCount++;
				}
			}
			return switchCount;
		}else {
			for (int j=0;j<(iB+1);j++){
				if (bitB.charAt(j)=='1'){
					switchCount++;
				}
			}
			return switchCount;
		}
	}
	
	public static int bitsRequiredToConvert2(int a, int b){
		int c=0;
		for(int i=0; i<32;i++){
			if(!isEq(a,b,i)){
				c++;
			}
		}
		return c;
	}
	
	public static boolean isEq(int a, int b, int p){
		return ((a>>p)&1)==((b>>p)&1);
	}
	
}

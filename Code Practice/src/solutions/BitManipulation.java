package solutions;

public class BitManipulation {
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
}

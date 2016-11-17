package solutions;

public class SortingAndSearch {
	//ctci:P9.1
	//assuming A has space for B
	/**
	* Merge 2 sorted integer arrays with extra space in the first
	* @param A sorted int[] with space for int[] b
	* @param l length of sorted list within A (1 more than index of last element in A)
	* @param B sorted int[]
	* @return int[] A with all elements from A and B sorted
	*/
	public static int[] mergeSortedArrays(int[] A, int l, int[] B){
		int al =l-1;
		int bl = B.length-1;
		for(int i=A.length-1; i>=0;i--){
			if(bl >= 0){
				if(B[bl] < A[al]){
					A[i]=A[al];
					al--;
				}else{
					A[i]=B[bl];
					bl--;
				}
			}else{
				A[i]=A[al];
				al--;
			}
		}
		return A;
	}
}

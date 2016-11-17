package testSuite;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import solutions.SortingAndSearch;

public class TestSortingAndSearching {

	@Test
	public void testMergeSortedArrays() {
		//mergeSortedArrays
		
		int[] A = new int[10];
		for(int i=0; i<5; i++){A[i]=i;} //0 1 2 3 4
		int[] B = new int[5];
		for(int j=0; j<5; j++){B[j]=2*j;} //0 2 4 6 8
		
		int[] sol=new int[10];
		//0 0 1 2 2 3 4 4 6 8
		sol[0]=0;
		sol[1]=0;
		sol[2]=1;
		sol[3]=2;
		sol[4]=2;
		sol[5]=3;
		sol[6]=4;
		sol[7]=4;
		sol[8]=6;
		sol[9]=8;
		
		Assert.assertArrayEquals(SortingAndSearch.mergeSortedArrays(A,5,B), sol);
	}

}

package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;
import solutions.BitManipulation;

public class TestBitManipulation {

	@Test
	public void testbitsRequiredToConvert() {
		assertEquals("BitManipulation.bitsRequiredToConvert(31,14)=2", 2, BitManipulation.bitsRequiredToConvert(31,14));
		assertEquals("BitManipulation.bitsRequiredToConvert(1,2)=2", 2, BitManipulation.bitsRequiredToConvert(1,2));
		assertEquals("BitManipulation.bitsRequiredToConvert(18,18)=0", 0, BitManipulation.bitsRequiredToConvert(18,18));
	}

}

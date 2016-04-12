package testSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.ArraysnStrings;

public class TestArraysnStrings {

	@Test
	public void testisUnique() {
		assertEquals("'hi' must be true", true, ArraysnStrings.isUnique("hi"));
		assertEquals("'hih' must be false", false, ArraysnStrings.isUnique("hih"));
	}
	
	@Test
	public void testisUniqueWOAddStructs() {
		assertEquals("'hi' must be true", true, ArraysnStrings.isUniqueWOAddStructs("hi"));
		assertEquals("'hih' must be false", false, ArraysnStrings.isUniqueWOAddStructs("hih"));
	}
	
	@Test
	public void testreverseString() {
		assertEquals("reverse 'won' is 'now'", "now", ArraysnStrings.reverseString("won"));
		assertEquals("reverse 'snap' is 'pans'", "pans", ArraysnStrings.reverseString("snap"));
	}
	
	@Test
	public void testremoveDuplicates() {
		char[] noDups = {'a','b','c','d','e','f','\0'};
		char[] hasDups = {'a','a','b','a','c','b','\0'};
		char[] nosize = {'\0'};
		ArraysnStrings.removeDuplicates(noDups);
		ArraysnStrings.removeDuplicates(hasDups);
		ArraysnStrings.removeDuplicates(nosize);
		System.out.println(String.valueOf(noDups));
		System.out.println(String.valueOf(hasDups));
		System.out.println(String.valueOf(nosize));
	}
	
	@Test
	public void testisAnagram() {
		assertTrue("dog, god is anagram", ArraysnStrings.isAnagram("dog", "god"));
		assertFalse("dog, gode is not anagram", ArraysnStrings.isAnagram("dog", "gode"));
		assertFalse("dog, '' is not anagram", ArraysnStrings.isAnagram("dog", ""));
		assertTrue("lameness, nameless is anagram", ArraysnStrings.isAnagram("lameness", "nameless"));
		assertTrue("painter, pertain is anagram", ArraysnStrings.isAnagram("painter", "pertain"));
	}
	
	@Test
	public void testPalindromePairs(){
		//palindromePairs(String[] words)
	}
}

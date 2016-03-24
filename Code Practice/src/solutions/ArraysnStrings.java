package solutions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ArraysnStrings {
	
	//P1.1
	public static Boolean isUnique(String input){
		Set<Character> seenCharacters = new HashSet<Character>();
		for (char ch: input.toCharArray()){
			if (seenCharacters.contains(ch)){
				return false;
			}
			seenCharacters.add(ch);
		}
		return true;
	}
	
	//P1.1
	public static Boolean isUniqueWOAddStructs(String input){
		int slen = input.length();
		char[] inputCA =input.toCharArray();
		char cchar;
		for (int i=0; i < slen-1; i++ ){
			cchar=inputCA[i];
			for (int j=i+1; j < slen; j++){
				if (cchar == inputCA[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	//P1.2
	public static String reverseString(String input){
		char[] inputCharA = input.toCharArray();
		int length = input.length();
		char[] outputCharA = new char[length];
		int j;
		for (int i= 0; i < length; i++){
			j=length-1-i;
			outputCharA[i]=inputCharA[j];
		}
		return String.valueOf(outputCharA);
	}
	
	//helper removeDuplicates
	static void moveOneBack(char[] str, int i){
		char cc=str[i];
		while (cc != '\0'){
			str[i]=str[i+1];
			i=i+1;
			cc=str[i];
		}
	} 
	
	//P1.3
	public static void removeDuplicates(char[] str) {
		int i=0;
		int j;
		while(str[i]!= '\0'){
			j=i+1;
			while(str[j]!='\0'){
				if (str[j] == str[i]){
					moveOneBack(str,j);
				} else {
					j++;
				}
			}
			i++;
		}
	}
	
	//P1.4
	public static boolean isAnagram(String str1, String str2){
		Map <Character,Integer> let2char = new HashMap<Character,Integer>(); //letter to character

		//counts letters in str1
		for (char c: str1.toCharArray()){
			if ( let2char.containsKey(c)){
				let2char.put(c, let2char.get(c) + 1);
			}
			else{ 
				let2char.put(c, 1);
			}
		}

		int ccount;
		for (char c: str2.toCharArray()){
			if ( let2char.containsKey(c)){
				ccount=let2char.get(c);
				if (ccount -1 == 0){let2char.remove(c);}
				else {let2char.put(c,  ccount-1);}
			}
			else{ return false;}
		}
		if (let2char.size() == 0){ return true;}
		return false;
	}
	
}

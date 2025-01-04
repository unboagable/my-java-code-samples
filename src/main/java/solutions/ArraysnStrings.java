package solutions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ArraysnStrings {

    //ctci:P1.1
    public static Boolean isUnique(String input){
        if(input == null || input.isEmpty()){ return true;}

        Set<Character> seenCharacters = new HashSet<Character>();
        for (char ch: input.toCharArray()){
            if (seenCharacters.contains(ch)){
                return false;
            }
            seenCharacters.add(ch);
        }
        return true;
    }
	
	//ctci:P1.1
    public static Boolean isUniqueWOAddStructs(String input){
        if(input == null || input.isEmpty()){ return true;}

        int slen = input.length();
        for (int i=0; i < slen-1; i++ ){
            for (int j=i+1; j < slen; j++){
                if (input.charAt(i) == input.charAt(j)){
                    return false;
                }
            }
        }
        return true;
	}
	
	//ctci:P1.2
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
	
	//ctci:P1.3
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
	
	//ctci:P1.4
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
	
	//leetcode Palindrome Pairs
    public List<List<Integer>> palindromePairs(String[] words) {
        LinkedList<List<Integer>> sol= new LinkedList<List<Integer>>();
        Map<String, Integer> w2i=new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++){
            if (words[i].length() > 0){
                w2i.put(words[i],i);
            }else{
                sol.addAll(allPalindromesForEmpty(words, i));
            }
        }
        for(int i=0; i<words.length; i++){
            if (words[i].length() > 0){
                sol.addAll(currentWordPalindromePairs(w2i, words[i], i));
            }
        }
        return sol;
    }
    
    private LinkedList<List<Integer>> currentWordPalindromePairs(Map<String, Integer> w2i, String currentWord, int myindex){
        int cwl=currentWord.length();
        
        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();
        int ll,rl;//left length, right length, new length
        
        for(int i=0; i<cwl; i++){
            ll=i;
            rl=cwl-1-i;
            //sides aren't equal and i is valid midpoint of possible palindrome
            if (ll != rl && isValidPalindromeMidpoint(currentWord, i, true)){
                List<Integer> toAdd=makeIndicesArray(ll, rl, currentWord, w2i, myindex);
                if (toAdd != null){sol.add(toAdd);}
            }
            rl=cwl-i;
            //sides aren't equal and i is valid immediate right of midpoint of possible palindrome
            if (ll != rl && isValidPalindromeMidpoint(currentWord, i, false)){
                List<Integer> toAdd=makeIndicesArray(ll, rl, currentWord, w2i, myindex);
                if (toAdd != null){sol.add(toAdd);}
            }
        }
        return sol;
        
    }
    
    private boolean isPalindrome(String word){
        //if odd
        int wl=word.length();
        return isValidPalindromeMidpoint(word, wl/2, wl%2 == 1);

    }
    
    //checks if word is palindrome with midp as the center
    private boolean isValidPalindromeMidpoint(String currentWord, int midp, boolean isCenter){
        int cwl=currentWord.length();
        
        int lc=midp-1;
        int rc=midp;
        if(isCenter){rc++;}
        
        while((lc>=0)&&(rc<cwl)){
            if (currentWord.charAt(lc) != currentWord.charAt(rc)){
                return false;
            }
            lc--;
            rc++;
        }
        return true;
    }
    
    
    private List<Integer> makeIndicesArray(int ll, int rl, String currentword, Map<String, Integer> w2i, int myindex){
        int cwl=currentword.length();
        int nl; //new length
        if (ll>rl){//left side is bigger
            nl=ll-rl;
            char[] completingword=new char[nl];
            for(int j=0; j<nl;j++){
                completingword[j]=currentword.charAt(nl-1-j);
            }
            if (w2i.containsKey(String.valueOf(completingword)) && w2i.get(String.valueOf(completingword)) != myindex){
                List<Integer> toAdd=new ArrayList<Integer>();
                toAdd.add(myindex);
                toAdd.add(w2i.get(String.valueOf(completingword)));
                return toAdd;
            }else{return null;}
        }else{//right side is bigger
            nl=rl-ll;
            char[] completingword=new char[nl];
            for(int j=0; j<nl;j++){
                completingword[j]=currentword.charAt(cwl-1-j);
            }
            if (w2i.containsKey(String.valueOf(completingword)) && w2i.get(String.valueOf(completingword)) != myindex){
                List<Integer> toAdd=new ArrayList<Integer>();
                toAdd.add(w2i.get(String.valueOf(completingword)));
                toAdd.add(myindex);
                return toAdd;
            }else{return null;}
        }
    }
    
    private LinkedList<List<Integer>> allPalindromesForEmpty(String[] words, int myi){
        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();
        for(int i=0; i<words.length; i++){
            if (i != myi && isPalindrome(words[i])){
                List<Integer> toAdd=new ArrayList<Integer>();
                toAdd.add(i);
                toAdd.add(myi);
                sol.add(toAdd);
                List<Integer> toAdd2=new ArrayList<Integer>();
                toAdd2.add(myi);
                toAdd2.add(i);
                sol.add(toAdd2);
            }
        }
        return sol;
    }
	
}

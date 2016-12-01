package structures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomSet<E> {
	Set<E> set;
	Random random;
	
	public RandomSet(){
		set=new HashSet<E>();
		random=new Random();
	}
	
	public boolean insert(E e){
		return set.add(e);
	}
	
	public boolean remove(E e){
		return set.remove(e);
	}
	
	public E GetRandomElement(){
		int n=random.nextInt(set.size());
		Iterator<E> it=set.iterator();
		while(it.hasNext() && n > 0){
			it.next();
			n--;
		}
		
		if(n==0 && it.hasNext()){
			return it.next();
		}
		
		return null;
	} 
}

package solutions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Recursive {
	//ctci:P8.3
	public static Set<Set<Integer>> allSubsetsRecursive(Set<Integer> s){
		Set<Set<Integer>> sol = new HashSet<Set<Integer>>();
		if (s==null || s.size() == 0){
			sol.add(new HashSet<Integer>());
			return sol;
		}
		
		Integer r = s.iterator().next();
		
		s.remove(r);
		
		sol.addAll(allSubsetsRecursive(s));
		
		Iterator<Set<Integer>> I = sol.iterator();
		
		Set<Set<Integer>> sol2 = new HashSet<Set<Integer>>();
		Set<Integer> cs;
		while(I.hasNext()){
			cs = new HashSet<Integer>(I.next());
			cs.add(r);
			sol2.add(cs);
		}
		sol.addAll(sol2);
		return sol;
		
		
		
	}
}

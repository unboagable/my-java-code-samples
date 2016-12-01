package testSuite;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import solutions.Recursive;

public class TestRecursive {

	@Test
	public void testAllSubsetsRecursive() {
		Set<Integer> s=new HashSet<Integer>();
		s.add(0);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		Set<Set<Integer>> sol = Recursive.allSubsetsRecursive(s);
		
		if(sol != null){
			System.out.println("{");
			
			Iterator<Set<Integer>> solI=sol.iterator();
			Iterator<Integer> csI;
			while(solI.hasNext()){
				System.out.print("{");
				csI=solI.next().iterator();
				while(csI.hasNext()){
					System.out.print(csI.next().intValue());
					System.out.print(" ");
				}
				System.out.println("}");
				
			}
			
			System.out.println("}");
		}
	}

}

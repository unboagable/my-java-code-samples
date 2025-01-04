import org.junit.Test;

import structures.RandomSet;

public class TestRandomSet {

	@Test
	public void testRandomSet(){
		RandomSet<Integer> rs = new RandomSet<Integer>();
		rs.insert(5);
		rs.insert(9);
		rs.insert(5555);
		rs.insert(99999);
		rs.remove(99999);
		for(int i=0; i<10; i++){
			System.out.println(rs.GetRandomElement());
		}
	}

}

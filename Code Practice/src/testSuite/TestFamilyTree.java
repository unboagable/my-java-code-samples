package testSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import structures.BinaryTreeNode;
import structures.family_tree.FamilyDemograpgic;
import solutions.family_tree.FamilyTree;

public class TestFamilyTree {

	@Test
	public void testGirl() {
		System.out.println("lily says.. ");
		BinaryTreeNode lily = FamilyTree.familyTree(new FamilyDemograpgic(2), "Lily Wilslet", 3);
		assertEquals(lily.val,1);
		assertNull(lily.left);
		assertNull(lily.right);
		System.out.println("lily says do my homework between here ?!?!?!");
	}
	
	@Test
	public void testChang() {
		System.out.println("Chang says..5 grown BP people ");
		System.out.println("Chang says..4 brothers 1 sister");
		BinaryTreeNode mbuguss = FamilyTree.familyTree(new FamilyDemograpgic(2), "Chang-Hyun Mungai", 7);
		assertEquals(mbuguss.val,1);
		assertNull(mbuguss.left);
		assertNull(mbuguss.right);
		System.out.println("Chang-Hyun says do my homework between here ?!?!?!");
	}

}

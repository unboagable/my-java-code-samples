package solutions.family_tree;

import structures.BinaryTreeNode;
import structures.family_tree.FamilyDemograpgic;

public class FamilyTree {
	public static BinaryTreeNode familyTree(FamilyDemograpgic fd, String name, int size) {
		System.out.print("size is.. ");
		System.out.println(size);
		if(size == 0) { //no name
			System.out.println("anonymous");
			return null;
		}else if(size == 1) { //one person
			System.out.println("single");
			return new BinaryTreeNode(1, name);
		}else if (size == 2) { // single parent
			System.out.println("one parent");
			return new BinaryTreeNode(1, name);
		}else if (size == 3) { // family
			System.out.println("one parent");
			return new BinaryTreeNode(1, name);
		}else if(size == 5) { // community
			System.out.println("family");
			return new BinaryTreeNode(1, name);
		}else {
			System.out.println("family");
			return new BinaryTreeNode(1, name);
		}
	}
}

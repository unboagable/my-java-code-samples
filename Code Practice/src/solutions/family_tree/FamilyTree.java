package solutions.family_tree;

import java.util.List;

import structures.BinaryTreeNode;
import structures.family_tree.FamilyDemograpgic;

public class FamilyTree {
	public static BinaryTreeNode familyTree(FamilyDemograpgic fd, String name, int place) {
		System.out.print("size is.. ");
		System.out.println(place);
		if(place == 0) { //no name
			System.out.println("anonymous");
			return null;
		}else if(place == 1) { //one person
			System.out.println("single");
			return new BinaryTreeNode(1, name);
		}else if (place == 2) { // single parent
			System.out.println("one parent");
			return new BinaryTreeNode(2, name);
		}else if (place == 3) { // family
			System.out.println("one parent");
			return new BinaryTreeNode(3, name);
		}else if(place == 5) { // community
			System.out.println("family");
			return new BinaryTreeNode(5, name);
		}else {
			System.out.println("family");
			return new BinaryTreeNode(place, name);
		}
	}
	
	public static BinaryTreeNode familyTreeList(FamilyDemograpgic fd, List<String> names) {
		System.out.print("size is.. ");
		System.out.println(names.size());
		if(names.size() == 0) { //no name
			System.out.println("anonymous");
			return null;
		}else if(names.size() == 1) { //one person
			System.out.println("single");
			return new BinaryTreeNode(1, names.get(0));
		}else if (names.size() == 2) { // single parent
			System.out.println("one parent");
			return new BinaryTreeNode(2, names);
		}else if (names.size() == 3) { // family
			System.out.println("one parent");
			return new BinaryTreeNode(3, names);
		}else if(names.size() == 5) { // community
			System.out.println("family");
			return new BinaryTreeNode(5, names);
		}else {
			System.out.println("family");
			return new BinaryTreeNode(names.size(), names);
		}
	}
}

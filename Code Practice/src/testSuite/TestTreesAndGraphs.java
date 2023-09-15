package testSuite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import solutions.TreesAndGraphs;
import structures.BinaryTreeNode;
import structures.LinkedListNode;

public class TestTreesAndGraphs {
	
	@Test
	public void testisBalanced() {
		BinaryTreeNode unbal = new BinaryTreeNode(5);
		unbal.left = new BinaryTreeNode(3);
		unbal.left.left = new BinaryTreeNode(2);
		unbal.left.right = new BinaryTreeNode(4);
		BTreePrinter.printNode(unbal);
		assertFalse("unbal must be false", TreesAndGraphs.isBalanced(unbal));
		BinaryTreeNode bal = new BinaryTreeNode(5);
		bal.left = new BinaryTreeNode(3);
		bal.left.left = new BinaryTreeNode(2);
		bal.left.right = new BinaryTreeNode(4);
		bal.right = new BinaryTreeNode(7);
		bal.right.right = new BinaryTreeNode(8);
		BTreePrinter.printNode(bal);
		assertTrue("bal must be true", TreesAndGraphs.isBalanced(bal));
	}
	
	@Test
	public void testmakeTree() {
		int[] num = {1,2,3,4,5,6,7};
		BTreePrinter.printNode(TreesAndGraphs.makeTree(num));
	}
	
	@Test
	public void testlinkedListPerDepth() {
		BinaryTreeNode bal = new BinaryTreeNode(5);
		bal.left = new BinaryTreeNode(3);
		bal.left.left = new BinaryTreeNode(2);
		bal.left.right = new BinaryTreeNode(4);
		bal.right = new BinaryTreeNode(7);
		bal.right.right = new BinaryTreeNode(8);
		LinkedListNode[] llpd = TreesAndGraphs.linkedListPerDepth(bal);
		assertNotNull("llpd not null",llpd);
		assertEquals("llpd must have 3 linked lists", 3, llpd.length);
		assertNotNull("1st linked list not null",llpd[0]);
		assertEquals("1st element in 1st linked list is 5", 5, llpd[0].getData());
		
		assertNotNull("2nd linked list not null",llpd[1]);
		LinkedListNode ll = llpd[1];
		boolean isSeven = false;
		boolean isThree = false;
		while(ll != null) {
			if(ll.getData() == 7) {isSeven = true;}
			if(ll.getData() == 3) {isThree = true;}
			ll=ll.getNext();
		}
		assertTrue("2nd linked list contains 5 and 7", isSeven && isThree);
	}

}

//http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(BinaryTreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode> newNodes = new ArrayList<BinaryTreeNode>();
        for (BinaryTreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(BinaryTreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

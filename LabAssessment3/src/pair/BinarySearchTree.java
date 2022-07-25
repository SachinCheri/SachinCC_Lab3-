package pair;

import java.util.*;

import pair.BinarySearchTree.Node;

public class BinarySearchTree {
	    static class Node {
	        int data;
	        Node left, right;
	    };
	 
	    static Node NewNode(int data)
	    {
	        Node temp = new Node();
	        temp.data = data;
	        temp.left = null;
	        temp.right = null;
	        return temp;
	    }
	 
	    static Node insert(Node root, int key)
	    {
	        if (root == null)
	            return NewNode(key);
	        if (key < root.data)
	            root.left = insert(root.left, key);
	        else
	            root.right = insert(root.right, key);
	        return root;
	    }
	 
	    public static boolean findPair(Node root, int target, Set<Integer> set)
	    {
	        if (root == null) {
	            return false;
	        }

	        if (findPair(root.left, target, set)) {
	            return true;
	        }
	        if (set.contains(target - root.data))
	        {
	            System.out.println("Pair found (" + (target - root.data) + ", "+ root.data + ")");
	            return true;
	        }

	        else {
	            set.add(root.data);
	        }

	        return findPair(root.right, target, set);
	    }
	 
	    static void findPair(Node root, int sum)
	    {
	        HashSet<Integer> set = new HashSet<Integer>();
	        if (!findPair(root, sum, set))
	            System.out.print("Pairs do not exit");
	    }
	    
	    public static void main(String[] args) {
			Node root = null;
	        root = insert(root, 40);
	        root = insert(root, 20);
	        root = insert(root, 60);
	        root = insert(root, 10);
	        root = insert(root, 30);
	        root = insert(root, 50);
	        root = insert(root, 70);
	       
	 
	        int sum = 130;
	        findPair(root, sum);
	    

		}
}


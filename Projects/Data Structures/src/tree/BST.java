package tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// BST does not allow duplicates
// T is any type that implement compareTo
public class BST<T extends Comparable<T>> {

	BSTNode<T> root;
	int size;
	
	public BST() {   // constructor initializes tree to empty
		root = null;
		size = 0;
	}
	
	// search method returns matching object
	public T search(T key) {
		BSTNode<T> ptr = root;
		while (ptr != null) {
			int c = key.compareTo(ptr.data);
			if (c == 0) {
				return ptr.data;
			}
			/*
			if (c < 0) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
			*/
			// this is the same thing as the if-else block, using the TERNARY operator
			ptr = c < 0 ? ptr.left : ptr.right;
		}
		return null;
	}
	
	public void insert(T item) 
	throws IllegalArgumentException {
		BSTNode<T> prev=null, ptr=root;
		int c=0;
		while (ptr != null) {   // search until fail
			c = item.compareTo(ptr.data);
			if (c == 0) { // duplicate, not allowed
				throw new IllegalArgumentException("Duplicate key: " + item);
			}
			prev=ptr;
			ptr = c < 0 ? ptr.left : ptr.right;
		}
		// create new node for item
		BSTNode<T> temp = new BSTNode<T>(item);
		if (prev == null) { // tree was empty
			root = temp;
			size = 1;
			return;
		}
		if (c < 0) {
			prev.left = temp;
		} else {
			prev.right = temp;
		}
		size++;
	}
	
	public T delete(T item)
	throws NoSuchElementException {
		// search and locate x
		BSTNode<T> x=root, p=null;
		while (x != null) {
			int c = item.compareTo(x.data);
			if (c == 0) {
				break;
			}
			p = x;
			x = c < 0 ? x.left : x.right;
		}
		if (x == null) {
			throw new NoSuchElementException(item + " not found");
		}
		
		T temp = x.data; // to be returned at end of method
		// Case 3
		if (x.left != null && x.right != null) {
			// find inorder predecessor of x
			BSTNode<T> y = x.left;  // left turn
			p = x;
			// right turns until dead end
			while (y.right != null) {
				p = y;
				y = y.right;
			}
			x.data = y.data;  // copy y into x
			x = y; // reset y to drop into case 1 or case 2
		}
		
		if (p == null) {
			root = x.left != null ? x.left : x.right; // case 1 and 2
			size--;
			return temp;
		}
		
		// works for case 2 (two combos) and case 2 (4 combos)
		if (x == p.right) {
			p.right = x.left != null ? x.left : x.right;
		} else {
			p.left = x.left != null ? x.left : x.right;
		}
		size--;
		return temp;	
	}
	
	public ArrayList<T> sort() {
		ArrayList<T> list = new ArrayList<T>(size);
		inorder(root, list);
		return list;
	}
	
	private static <T extends Comparable<T>>
	void inorder(BSTNode<T> root, ArrayList<T> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);  // L
		list.add(root.data);  // V
		inorder(root.right, list);  // R
	}
	
	
}

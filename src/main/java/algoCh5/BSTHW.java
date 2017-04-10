
package algoCh5;

import java.lang.Comparable;


@SuppressWarnings("unchecked")
class BSTHW <Key extends Comparable<? super Key>, E>
    extends BST<Key,E> {

    // Problem #1
	public int height() {
		if (this.root == null) {
			return 0;
		} else {
			return 1 + Math.max(height(this.root.left()), height(this.root.right()));
		}
	}
	
	private int height(BSTNode<Key, E> n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.left()), height(n.right()));
		}
	}

	// Problem #2
	public int leaves() {
	    return leaves(this.root);
	}
	
	public int leaves(BSTNode<Key, E> node) {
	    if (node == null) {
	        return 0;
	    } else if (node.left() == null && node.right() == null) {
	        return 1;
	    } else {
	        return leaves(node.left()) + leaves(node.right());
	    }
	}

	// Problem #3
	public int lessThanOrEqualTo(Key k) {
	    return lessThanEqualTo(root, k);
	}
	
	public int lessThanEqualTo(BSTNode<Key, E> n, Key k) {
	    if (n == null) {
	        return 0;
	    } else if (n.key().compareTo(k) <= 0) {
	        return 1 + lessThanEqualTo(n.left(), k) + lessThanEqualTo(n.right(), k);
	    } else {
	        return lessThanEqualTo(n.left(), k);
	    }
	    
	}
	

}

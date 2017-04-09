
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
			return 1 + Math.max(heightHelp(this.root.left()), heightHelp(this.root.right()));
		}
	}
	
	private int heightHelp(BSTNode<Key, E> n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + Math.max(heightHelp(n.left()), heightHelp(n.right()));
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
	    return leqHelp(root, k);
	}
	
	public int leqHelp(BSTNode<Key, E> n, Key k) {
	    if (n == null) {
	        return 0;
	    } else if (n.key().compareTo(k) <= 0) {
	        return 1 + leqHelp(n.left(), k) + leqHelp(n.right(), k);
	    } else {
	        return leqHelp(n.left(), k);
	    }
	    
	}
	

}

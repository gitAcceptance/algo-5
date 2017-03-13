
package algoCh5;

import java.lang.Comparable;


@SuppressWarnings("unchecked")
class BSTHW <Key extends Comparable<? super Key>, E>
    extends BST<Key,E> {

    // put height() here
	public int height() {
		if (this.root == null) {
			return 0;
		} else {
			return 1 + Math.max(heightHelp(this.root.left()), heightHelp(this.root.right()));
		}
	}
	
	private int heightHelp(BSTNode<Key, E> rt) {
		if (rt == null) {
			return 0;
		} else {
			return 1 + Math.max(heightHelp(this.root.left()), heightHelp(this.root.right()));
		}
	}

    // put leaves() here

    // put lessThanOrEqualTo(Key k) here

}

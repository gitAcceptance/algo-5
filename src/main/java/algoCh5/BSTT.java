/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/
package algoCh5;

import java.lang.Comparable;


/** Binary Search Tree implementation for Dictionary ADT */
@SuppressWarnings("unchecked")
class BSTT <Key extends Comparable<? super Key>, E>
             extends BST <Key, E> {


    
    // override inserthelp()
    /*
    protected BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) {
        if (rt == null) 
           // TODO change this constructor to use the new threaded one
           return new BSTNode<Key,E>(k, e);
        if (rt.key().compareTo(k) > 0)
           rt.setLeft(inserthelp(rt.left(), k, e));
        else
          rt.setRight(inserthelp(rt.right(), k, e));
        return rt;
    }
    */
    // override printhelp()



}

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

    protected BSTTNode<Key,E> root;
    
    /** Insert a record into the tree.
    * @param k Key value of the record.
    * @param e The record to insert.
    *  
    */
    public void insert(Key k, E e) {
        root = inserthelp(root, k, e, null, null);
        nodecount++;
    }
    
    // override inserthelp()
    protected BSTTNode<Key,E> inserthelp(BSTTNode<Key,E> rt, Key k, E e, BSTTNode<Key,E> p, String direction) {
        if (rt == null) 
            
            if (direction.equals("LEFT")) {
                return new BSTTNode<Key,E>(k, e, p, p);
            } else if (direction.equals("RIGHT")) {
                if (p.getThread() == null) {
                    BSTTNode<Key, E> me = new BSTTNode<Key,E>(k, e, p, null);
                    p.setThread(me);
                    return me;
                } else {
                    BSTTNode<Key, E> me = new BSTTNode<Key,E>(k, e, p, p.parent());
                    p.setThread(me);
                    return me;
                }
                
            }
            
            
            
           
        if (rt.key().compareTo(k) > 0)
           rt.setLeft(inserthelp(rt.left(), k, e, rt, "LEFT"));
        else
          rt.setRight(inserthelp(rt.right(), k, e, rt, "RIGHT"));
        return rt;
    }
    
    
    
    // override printhelp()
    protected void printhelp(BSTTNode<Key,E> rt) {
        BSTTNode<Key,E> curr = rt.getThread();
        while (curr != null) {
            printVisit(curr.key(), curr.element());
            curr = curr.getThread();
        }
        
    }


}

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

package algoCh5;

import java.lang.Comparable;


/** Binary Search Tree implementation for Dictionary ADT */
class BST<Key extends Comparable<? super Key>, E>
                                  implements Dictionary<Key, E> {

  protected BSTNode<Key,E> root; // Root of the BST
  protected int nodecount;             // Number of nodes in the BST

  /** Constructor */
  BST() {
      root = null; 
      nodecount = 0; 
  }

  /** Reinitialize tree */
  public void clear() { 
     root = null; nodecount = 0; 
  }

  /** @return The number of records in the dictionary. */
  public int size() { 
     return nodecount; 
  }

  /** Insert a record into the tree.
      @param k Key value of the record.
      @param e The record to insert. */
  public void insert(Key k, E e) {
    root = inserthelp(root, k, e);
    nodecount++;
  }

  /** Remove a record from the tree.
      @param k Key value of record to remove.
      @return The record removed, or null if there is none. */
  public E remove(Key k) {
    E temp = findhelp(root, k);   // First find it
    if (temp != null) {
      root = removehelp(root, k); // Now remove it
      nodecount--;
    }
    return temp;
  }

  /** @return Record with key value k, null if none exist.
      @param k The key value to find. */
  public E find(Key k) { 
     return findhelp(root, k); 
  }


  protected E findhelp(BSTNode<Key,E> rt, Key k) {

     if (rt == null) return null;

     if (rt.key().compareTo(k) > 0)
        return findhelp(rt.left(), k);
     else if (rt.key().compareTo(k) == 0)
        return rt.element();
     else 
        return findhelp(rt.right(), k);
   }

   protected BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) {
      if (rt == null) 
         return new BSTNode<Key,E>(k, e);
      if (rt.key().compareTo(k) > 0)
         rt.setLeft(inserthelp(rt.left(), k, e));
      else
        rt.setRight(inserthelp(rt.right(), k, e));
      return rt;
   }


   /** Remove a node with key value k
      @return The tree with the node removed */
   protected BSTNode<Key,E> removehelp(BSTNode<Key,E> rt, Key k) {

        if (rt == null) return null;

        if (rt.key().compareTo(k) > 0)
             rt.setLeft(removehelp(rt.left(), k));
        else if (rt.key().compareTo(k) < 0)
             rt.setRight(removehelp(rt.right(), k));

        else { // Found it

            if (rt.left() == null)
               return rt.right();
 
           else if (rt.right() == null)
              return rt.left();

           else { // Two children
              BSTNode<Key,E> temp = getmin(rt.right());
              rt.setElement(temp.element());
              rt.setKey(temp.key());
              rt.setRight(deletemin(rt.right()));
           }
        }
        return rt;
   }

   protected BSTNode<Key,E> getmin(BSTNode<Key,E> rt) {
      if (rt.left() == null)
         return rt;
      else 
         return getmin(rt.left());
   }

   protected BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) {
       if (rt.left() == null)
          return rt.right();
       else {
          rt.setLeft(deletemin(rt.left()));
         return rt;
       }
   }

  public String toString() {
     out = new StringBuffer(100);
     printhelp(root);
     return out.toString();
  }

  protected StringBuffer out;
 
  protected void printhelp(BSTNode<Key,E> rt) {
      if (rt == null) return;
      printhelp(rt.left());
      printVisit(rt.key(), rt.element());
      printhelp(rt.right());
  }

  protected void printVisit(Key k, E it) {
       out.append(k + "=" + it + " ");
  }


  /** Remove and return the root node from the dictionary.
      @return The record removed, null if tree is empty. */
  public E removeAny() {
    if (root != null) {
      E temp = root.element();
      root = removehelp(root, root.key());
      nodecount--;
      return temp;
    }
    else return null;
  }

  // S. Haller Check that this is a BST tree
  public boolean isBSTTree() {
      return isBSTTree(root);
  }

  protected boolean isBSTTree(BSTNode<Key,E> rt) {
      if (rt == null || rt.isLeaf())
	  return true;
      // right child is null and this key > left child, continue to 
      // check that left subtree is a BST
      if (rt.right() == null && rt.key().compareTo(rt.left().key()) > 0)
	  return isBSTTree(rt.left());
      // left child is null and this key <= right child, continue to 
      // check the right subtreeis a BST
      if (rt.left() == null && rt.key().compareTo(rt.right().key()) <= 0)
	  return isBSTTree(rt.right());
      // else, check this key > left child, this key <= right child,
      // check both subtrees are BST trees
      return rt.key().compareTo(rt.left().key()) > 0 &&
             rt.key().compareTo(rt.right().key()) <= 0 &&
             isBSTTree(rt.left()) && isBSTTree(rt.right());
  }


}

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/
package algoCh5;

import java.lang.Comparable;
import java.util.*;

/** Binary Search Tree implementation for Dictionary ADT */
class BSTS <Key extends Comparable<? super Key>, E>
             extends BST <Key, E> {

 
    // Problem #4
    protected void printhelp(BSTNode<Key,E> rt) {
        if (rt == null) return;
        
        Stack<BSTNode<Key,E>> stack = new Stack<BSTNode<Key,E>>(); 
        BSTNode<Key,E> currentNode = rt;
        
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left();
        }
        
        while (stack.size() > 0) {
            currentNode = stack.pop();
            printVisit(currentNode.key(), currentNode.element());
            if (currentNode.right() != null) {
                currentNode = currentNode.right();
                
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left();
                }
            }
        }
        
        
       // FIXME Write tests for problem #4 printhelp().
    }
 
}

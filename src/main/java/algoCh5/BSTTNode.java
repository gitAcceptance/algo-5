package algoCh5;

class BSTTNode<Key,E> extends BSTNode<Key,E> {
 
    boolean isThreaded = true;
    BSTNode<Key, E> thread = null;
    
    public BSTTNode(Key k, E val, BSTNode<Key,E> l, BSTNode<Key,E> r, BSTNode<Key,E> t) {
        super(k, val, l, r);
        this.thread = t;
        
    }

}

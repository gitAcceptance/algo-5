package algoCh5;

class BSTTNode<Key,E> extends BSTNode<Key,E> {
    
    private BSTTNode<Key,E> left;  // Pointer to left child
    private BSTTNode<Key,E> right; // Pointer to right child
 
    boolean isThreaded = true;
    BSTTNode<Key, E> parent;
    BSTTNode<Key, E> thread;
    
    public BSTTNode(Key k, E val, BSTTNode<Key,E> p, BSTTNode<Key, E> t) { 
        this(k, val, null, null, p, t);
    }
    
    public BSTTNode(Key k, E val, BSTTNode<Key,E> l, BSTTNode<Key,E> r, BSTTNode<Key,E> p, BSTTNode<Key, E> t) {
        super(k, val, null, null);
        this.left = l;
        this.right = r;
        this.thread = t;
        this.parent = p;
    }
    
    public BSTTNode<Key, E> getThread() {
        return thread;
    }
    
    public void setThread(BSTTNode<Key, E> t) {
        this.thread = t;
    }
    
    public BSTTNode<Key, E> parent() {
        return this.parent;
    }
    
    public void setParent(BSTTNode<Key, E> p) {
        this.parent = p;
    }

    public BSTTNode<Key, E> left() {
        return left;
    }

    public void setLeft(BSTTNode<Key, E> left) {
        this.left = left;
    }

    public BSTTNode<Key, E> right() {
        return right;
    }

    public void setRight(BSTTNode<Key, E> right) {
        this.right = right;
    }
    

}

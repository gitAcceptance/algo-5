/*
 * Author: Andrew Valancius
 * 
 * 
 */


package algoCh5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBSTHW {

	@Test
	public void testHeight() {
		BSTHW<Integer, Integer> tree = new BSTHW<Integer, Integer>();
		assertEquals("Empty tree height.", 0, tree.height());
		
		tree.insert(30, 30);
		assertEquals("Only root node tree height", 1, tree.height());
		
		tree.insert(20, 20);
		tree.insert(40, 40);
	    assertEquals("Two child nodes off the root node.", 2, tree.height());
	}
		
	
	@Test
	public void testLeaves() {
	    BSTHW<Integer, Integer> tree = new BSTHW<Integer, Integer>();
	    assertEquals("Empty tree leaf count.", 0, tree.leaves());
	    
	    tree.insert(30, 30);
	    assertEquals("Single tree leaf count.", 1, tree.leaves());
	    
	    tree.insert(20, 20);
        tree.insert(40, 40);
        assertEquals("Two leaf count.", 2, tree.leaves());
	    
	}
	
	@Test
	public void testLessThanEqualTo() {
	    BSTHW<Integer, Integer> tree = new BSTHW<Integer, Integer>();
	    
        tree.insert(30, 30);
        tree.insert(20, 20);
        tree.insert(40, 40);
        tree.insert(40, 40);
        
        tree.insert(10, 10);
        tree.insert(5, 5);
        
        
        assertEquals("LessThanOrEqualTo", 4, tree.lessThanOrEqualTo(30));
        
        assertEquals("LessThanOrEqualTo", 6, tree.lessThanOrEqualTo(40));
        
        assertEquals("LessThanOrEqualTo", 3, tree.lessThanOrEqualTo(20));
	}
	
}

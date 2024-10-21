package npiTest;

import npi.calculette.StackConcret;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }
    @Test
    public void isEmpty() {
        // Given
        StackConcret stackConcretVide = new StackConcret() ;
        StackConcret stackConcretnonVide = new StackConcret() ;
        stackConcretnonVide.getStack().add(2.5) ;
        stackConcretnonVide.getStack().add(8.0) ;
        // When - Then
        assertTrue(stackConcretVide.isEmpty());
        assertFalse(stackConcretnonVide.isEmpty());
    }
   @Test
    public void getSize() {
        StackConcret stackConcretSiz = new StackConcret();
        StackConcret stackConcret2 = new StackConcret();
        assertEquals(stackConcret2.getSize(), 0);
        stackConcretSiz.getStack().add(1.0);
        stackConcretSiz.getStack().add(2.34);
        stackConcretSiz.getStack().add(3.22);
        assertEquals(stackConcretSiz.getSize(), 3);
        stackConcret2.getStack().add(12.0);
        assertEquals(stackConcret2.getSize(), 1);
        assertFalse(stackConcret2.isEmpty());
    }
    @Test
    public void push() {
        // Given
        StackConcret stack1 = new StackConcret() ;
        StackConcret stack2 = new StackConcret() ;
        stack2.getStack().add(2.4) ;
        stack2.getStack().add(6.1) ;
        // When
        stack1.push(1.3);
        stack2.push(8.2);
        // Then
        assertEquals(stack1.getStack().size(), 1);
        assertEquals(stack1.getStack().getLast(), 1.3,0.001);
        assertEquals(stack2.getStack().size(), 3);
        assertEquals(stack2.getStack().getLast(), 8.2, 0.001);
    }
    @Test()
    public void peekStackNonVide() {
        StackConcret stack1 = new StackConcret();
        stack1.getStack().add(12.23);
        stack1.getStack().add(3.34);
        double last = stack1.peek();
        assertEquals(stack1.getStack().size(),2);
        assertEquals(stack1.getStack().getLast(), 3.34, 0.001);
        assertEquals(last,3.34, 0.001);
    }
    @Test(expected = EmptyStackException.class)
    public void peekStackVide() {
        // given
        StackConcret stackVide = new StackConcret();
        // When - Then
        double lastElt = stackVide.peek();
    }
    @Test
    public void popStackVide() {
        // Given
        StackConcret stackVide = new StackConcret() ;
        // When - Then
        assertThrows(EmptyStackException.class, stackVide::pop);
    }
    @Test
    public void popStackNonVide() {
        // Given
        StackConcret stack = new StackConcret() ;
        stack.getStack().add(97.1) ;
        stack.getStack().add(3.7) ;
        // When
        double lastElt = stack.pop() ;
         //Then
        assertEquals(stack.getStack().size(), 1);
        assertEquals(lastElt, 3.7, 0.001);
        assertEquals(stack.getStack().getLast(), 97.1, 0.001);
    }
}
package npiTest;

import npi.calculette.RPNCalculette;
import npi.calculette.StackConcret;
import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;
import npi.interfaces.Calc;
import npi.interfaces.Stack;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RPNCalculetteTest {

    @Test
    public void enterValue() throws NotEnoughOperandsOnStackException {
        Calc cal = new RPNCalculette();
        cal.enterValue(2.0);
         assertEquals(2.0, cal.displayValueOnTop(),0.001);
    }
    @Test
    public void add() throws NotEnoughOperandsOnStackException{
        Calc cal = new RPNCalculette();
        Calc cal1 = new RPNCalculette();
        cal.enterValue(12.0);
        cal.enterValue(23.0);
        cal.add();
        cal1.enterValue(0.0);
        cal1.enterValue(11.0);
        cal1.add();
        assertEquals(35.0,cal.displayValueOnTop(),0.001);
        assertEquals(11.0, cal1.displayValueOnTop(),0.001);
    }
    @Test
    public void substrac() throws NotEnoughOperandsOnStackException{
        Calc stack = new RPNCalculette();
        Calc stack1 = new RPNCalculette();

        stack.enterValue(23.10);
        stack.enterValue(11.10);
        stack.subtract();
        assertEquals(12.0, stack.displayValueOnTop(),0.001);
        stack.enterValue(11.10);
        stack.enterValue(20.10);
        stack.subtract();
        assertEquals(-9.0, stack.displayValueOnTop(),0.001);
        stack1.enterValue(-2.0);
        stack1.enterValue(-2.0);
        stack1.subtract();
        assertEquals(0.0, stack1.displayValueOnTop(),0.001);
        stack1.enterValue(10.0);
        stack1.enterValue(0.0);
        stack1.subtract();
        assertEquals(10.0,stack1.displayValueOnTop(),0.001);
    }
    @Test
    public void multiply() throws  NotEnoughOperandsOnStackException{
        Calc stack = new RPNCalculette();
        Calc stack1 = new RPNCalculette();
        stack.enterValue(0.0);
        stack.enterValue(2.0);
        stack.multiply();
        assertEquals(0.0, stack.displayValueOnTop(),0.001);
        stack1.enterValue(23.0);
        stack1.enterValue(1.0);
        stack1.multiply();
        assertEquals(23,stack1.displayValueOnTop(),0.001);
        stack.enterValue(4.0);
        stack.enterValue(3.0);
        stack.multiply();
        assertEquals(12,stack.displayValueOnTop(),0.001);
    }
    @Test
    public void divide() throws DivideByZeroException, NotEnoughOperandsOnStackException {
        Calc stack = new RPNCalculette();
        stack.enterValue(24.0);
        stack.enterValue(0.0);
        assertThrows(DivideByZeroException.class, stack::divide);
        Calc stack1 = new RPNCalculette();
        stack1.enterValue(23.0);
        stack1.enterValue(1.0);
        stack1.divide();
        assertEquals(23.0, stack1.displayValueOnTop(), 0.001);
        Calc stack2 = new RPNCalculette();
        stack2.enterValue(23.0);
        stack2.enterValue(2.0);
        stack2.divide();
        assertEquals(11.5, stack2.displayValueOnTop(),0.001);
    }
}

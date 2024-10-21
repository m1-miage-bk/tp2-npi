package npi.calculette;
import npi.interfaces.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackConcret implements Stack {
    private ArrayList<Double> stack = new ArrayList<Double>() ;
    // Ce getter est une solution alternative a l'accesseur public
    public ArrayList<Double> getStack() {
        return stack;
    }
    @Override
    public boolean isEmpty() {
        return stack.isEmpty() ;
    }
    @Override
    public int getSize() {
        return stack.size() ;
    }
    @Override
    public void push(double item) {
        stack.add(item);
    }
    @Override
    public double peek() throws EmptyStackException {
        double lastElt ;
        try {
            lastElt = stack.getLast() ;
        }
        catch (Exception e) {
            throw new EmptyStackException() ;
        }
        return lastElt ;
    }
    @Override
    public double pop() throws EmptyStackException {
        double lastPop;
        try {
            lastPop = stack.removeLast();

        } catch (Exception e) {
            throw new EmptyStackException ();
        }
        return lastPop;
    }
}

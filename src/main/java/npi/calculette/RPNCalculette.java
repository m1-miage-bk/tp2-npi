package npi.calculette;

import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;
import npi.interfaces.Calc;
import npi.interfaces.Stack;

public class RPNCalculette implements Calc {
    private Stack calc = new StackConcret();
    /**
     * pushes a value on the RPN stack
     * @param value
     */
    @Override
    public void enterValue(double value) {
        calc.push(value);
    }
    /**
     * adds the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    @Override
    public void add() throws NotEnoughOperandsOnStackException {
        try {
            if (calc.getSize() < 2) {
                throw new NotEnoughOperandsOnStackException();
            }
            double a = calc.pop();
            double b = calc.pop();
            calc.push(b + a);
        } catch (Exception e) {
            throw new NotEnoughOperandsOnStackException();
        }
    }
    /**
     * subtracts the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {
        try{
            if (calc.getSize() < 2) {
                throw new NotEnoughOperandsOnStackException();
            }
            double a = calc.pop();
            double b = calc.pop();
            calc.push(b - a);
        } catch (Exception e) {
            throw new NotEnoughOperandsOnStackException();
        }
    }
    /**
     * multiplies the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     */
    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {
        try{
            if (calc.getSize() < 2) {
                throw new NotEnoughOperandsOnStackException();
            }
            double a = calc.pop();
            double b = calc.pop();
            calc.push(b * a);
        } catch (Exception e) {
            throw new NotEnoughOperandsOnStackException();
        }
    }
    /**
     * divides the two last values, replacing them with the result on top
     * @throws NotEnoughOperandsOnStackException
     * @throws DivideByZeroException
     */
    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if (calc.getSize() < 2) {
            throw new NotEnoughOperandsOnStackException();
        }
        double diviseur = calc.pop();
        if (diviseur == 0) {
            throw new DivideByZeroException();
        }
        double dividende = calc.pop();

        double resultat = dividende / diviseur;
        calc.push(resultat);
    }
    /**
     * displays the last value on top of the stack
     * @return the last value
     * @throws NotEnoughOperandsOnStackException
     */
    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        if (calc.isEmpty()) {
            throw new NotEnoughOperandsOnStackException();
        }
        return calc.peek();
    }
}

package npi.calculette;
import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;
import npi.interfaces.Calc;
import npi.interfaces.RPNParser;
import java.text.ParseException;

public class RPN implements RPNParser {
    Calc calculette = new RPNCalculette();
    /**
     * parses the string, computing and display the last result
     * @param toParse
     * @return the last result
     */
    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        String[] expressions = toParse.split(" ");
        for(String expression: expressions){
            try {
                double val = Double.parseDouble(expression);
                calculette.enterValue(val);
            } catch (NumberFormatException e) {
                switch( expression){
                    case "+" :
                        calculette.add();
                        break;
                    case "-" :
                        calculette.subtract();
                        break;
                    case "*" :
                        calculette.multiply();
                        break;
                    case "/" :
                        calculette.divide();
                        break;
                    default :
                        throw new ParseException("Expression Invalide: "+expression,0);
                }
            }
        }
        return calculette.displayValueOnTop();
    }
}


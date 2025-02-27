package npi.interfaces;

import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;

import java.text.ParseException;

public interface RPNParser {

    /**
     * parses the string, computing and display the last result
     * @param toParse
     * @return the last result
     */
    double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException;

}
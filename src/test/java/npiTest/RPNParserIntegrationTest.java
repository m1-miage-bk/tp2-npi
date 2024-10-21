package npiTest;

import npi.calculette.RPN;
import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;
import npi.interfaces.RPNParser;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RPNParserIntegrationTest {

    @Test
    public void testExpressionWifAdd() throws ParseException, DivideByZeroException, NotEnoughOperandsOnStackException {
        RPNParser toPars = new RPN();
        double resultat = toPars.parseAndDisplayResult("2 3 2 + +");
        assertEquals(7,resultat,0.001 );
    }
    @Test
    public void testExpressionWifAddMult() throws  ParseException, DivideByZeroException,NotEnoughOperandsOnStackException{
        RPNParser toParse = new RPN();
        double resultat = toParse.parseAndDisplayResult("4 3 1 * +");
        assertEquals(7,resultat,0.001);
    }
    @Test
    public void testExpresionSubtract()throws ParseException, DivideByZeroException,NotEnoughOperandsOnStackException{
        RPNParser toPars = new RPN();
        double resultat = toPars.parseAndDisplayResult("12 4 -");
        assertEquals(8,resultat,0.001);
    }
    @Test
    public void testExpressionWifDiv() throws ParseException, DivideByZeroException,NotEnoughOperandsOnStackException{
        RPNParser toPars = new RPN();
        double resulat = toPars.parseAndDisplayResult("1 2 /");
        assertEquals(0.5,resulat,0.001);
    }
    @Test
    public void testExpressionInvalide() throws  ParseException, DivideByZeroException,NotEnoughOperandsOnStackException{
        RPNParser toPars = new RPN();
        assertThrows(NotEnoughOperandsOnStackException.class, ()->toPars.parseAndDisplayResult("4 + +"));
    }
    @Test
    public void testDivByZero()throws ParseException,DivideByZeroException,NotEnoughOperandsOnStackException{
        RPNParser parser = new RPN();
        assertThrows(DivideByZeroException.class, ()-> parser.parseAndDisplayResult("4 0 /"));
    }

}

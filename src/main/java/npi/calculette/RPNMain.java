package npi.calculette;

import npi.exceptions.DivideByZeroException;
import npi.exceptions.NotEnoughOperandsOnStackException;
import npi.interfaces.RPNParser;

import java.text.ParseException;
import java.util.Scanner;

public class RPNMain {
    public static void main(String[] args){
        // Les scanner
        Scanner scanner = new Scanner(System.in);
        RPNParser paser = new RPN();

        System.out.println("RPN Calc");
        System.out.println("Taper '.exit' pour quitter \n");

        String input;

        while (true){
            System.out.print("Entrer un NPI expression -> ");
            input = scanner.nextLine();

            if(input.equals(".exit")){
                break;
            }
            try{
                double resultat = paser.parseAndDisplayResult(input);
                System.out.println(resultat);
            } catch (NotEnoughOperandsOnStackException e) {
                System.out.println(" Pas assez d'opérandes, Réessayer ou taper '.exit' pour quitter");
            } catch (DivideByZeroException e ) {
                System.out.println(" Division par zéro impossible, Réessayer ou taper '.exit' pour quitter");
            } catch (ParseException e ) {
                System.out.println(" Expression Invalide ,Réessayer ou taper '.exit' pour quitter ");
            }
        }
    scanner.close();
        System.out.println("Sortie du NPI. A bientot ");
    }

}
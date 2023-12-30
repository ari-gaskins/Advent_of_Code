package DayOne;
/**
 * Trebuchet
 */

import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;


public class Trebuchet {

    public static void main(String[] args) {
        //Scanner scnr = new Scanner();
        FileInputStream fileByteStream = null;
        Scanner inFS = null;
        String fileName;
        Integer firstDigit;
        Integer lastDigit;
        Integer bothDigit;
        Integer total; 
        ArrayList<Integer> digitList = new ArrayList<Integer>();
        String line;
        char[] characters;
        int i;

        // setup file input
        try {
            fileName = "trebuchet_data.txt";
            fileByteStream = new FileInputStream(fileName);
        }

        catch (IOException ioe) {
            System.out.println("Error locating file: ");
            ioe.printStackTrace();
        }
        
        inFS = new Scanner(fileByteStream);
        
        // set total 
        total = 0;

        // check for end of file
        while (inFS.hasNextLine()) {
            line = inFS.nextLine();
            characters = line.toCharArray();
            firstDigit = null;
            digitList.clear();

            for (i = 0; i < characters.length; i++) {
                if (Character.isDigit(characters[i])) {
                    // System.out.println("Digit found: " + characters[i]);
                    digitList.add(Integer.parseInt(String.valueOf(characters[i])));
                    // System.out.println("Digit added to list: " + Integer.parseInt(String.valueOf(characters[i])));
                } 
            }
            
            /*for (Integer digit : digitList) {
                System.out.print("Digits in list: ");
                System.out.println(" " + digit);
            }*/


            // get first digit in line
            firstDigit = digitList.get(0);

            // get last digit in line
            lastDigit = digitList.get(digitList.size() - 1);

            // concatenate first + last digits
            bothDigit = Integer.valueOf(String.valueOf(firstDigit) + String.valueOf(lastDigit));

            // add to total
            //System.out.println("Digit being added to total: [" + bothDigit + "]");
            total += bothDigit;
            //System.out.println("Current total: " + total);

        }


        System.out.println("Final total: " + total);

        System.out.println("Closing Scanner...");
        inFS.close();
        System.out.println("Scanner closed.");
    }
}
/*
 * CubeGame - Day Two
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;


public class CubeGame {
    public static void main(String[] args) {
        // sum of IDs that meet bench mark
        int idTotal;
        int numCubes;
        int id;
        int goodGames;
        // for testing
        // int count;
        int i;
        boolean redBenchmark; 
        boolean greenBenchmark; 
        boolean blueBenchmark; 
        boolean redMeetsRequirements;
        boolean greenMeetsRequirements;
        boolean blueMeetsRequirements;
        boolean gameMeetsRequirements;
        String[] line;
        String currColor;
        String redString;
        String greenString;
        String blueString;
        String fileName;
        FileInputStream fileByteStream;
        Scanner inFS;

        idTotal = 0;
        numCubes = 0;
        id = 0;
        goodGames = 0;
        // count = 0;

        // Benchmarks, 12 red, 13 green, 14 blue
        redBenchmark = false;
        greenBenchmark = false;
        blueBenchmark = false;
        redMeetsRequirements = false;
        greenMeetsRequirements = false;
        blueMeetsRequirements = false;
        gameMeetsRequirements = true;

        line = new String[100];
        currColor = "";
        redString = "red";
        greenString = "green";
        blueString = "blue";

        fileByteStream = null;
        inFS = null;

        // get file
        try{
            fileName = "cube_game_data.txt";
            fileByteStream = new FileInputStream(fileName);
        }
        catch (IOException ioe) {
            System.out.println("Error locating file: ");
            ioe.printStackTrace();
        }

        inFS = new Scanner(fileByteStream);

        while (inFS.hasNextLine()){
            // set default result
            gameMeetsRequirements = true;

            // get line as String
            line = inFS.nextLine().split(" ");

            // get ID by removing colon
            line[1] = line[1].replace(":", "");
            id = Integer.parseInt(line[1]);
            
            // start after id
            for (i = 2; i < line.length; i++) {
                // get number of cubes
                if (line[i].matches("\\d+")) {
                    numCubes = Integer.parseInt(line[i]);
                    // System.out.print("Cubes: " + numCubes);
                    // if getting number of cubes, reset current color
                    currColor = "";
                }
                // set currColor based on word found 
                else if (line[i].contains(redString)) {
                    currColor = redString;
                }
                else if (line[i].contains(greenString)) {
                    currColor = greenString;
                }
                else if (line[i].contains(blueString)) {
                    currColor = blueString;
                }
                
                // if theres no set current color, go back and get one
                if (currColor.equals("")) {
                    continue;
                }

                // System.out.println("Color: " + currColor);

                // check for number of cubes and current color pair
                if (numCubes > 0 && !currColor.equals("")) {
                    // set benchmarks
                    redBenchmark = numCubes <= 12;
                    greenBenchmark = numCubes <= 13;
                    blueBenchmark = numCubes <= 14;

                    // set requirements based on benchmarks and current color
                    switch (currColor) {
                        case "red":
                            if (redBenchmark) {
                                redMeetsRequirements = true;
                            }

                            else {
                                redMeetsRequirements = false;
                                gameMeetsRequirements = false;
                            }

                            // System.out.println("Red is: " + redMeetsRequirements);
                            break;

                        case "green":
                            if (greenBenchmark) {
                                greenMeetsRequirements = true;
                            }

                            else {
                                greenMeetsRequirements = false;
                                gameMeetsRequirements = false;
                            }

                            // System.out.println("Green is: " + greenMeetsRequirements);
                            break;

                        case "blue":
                            if (blueBenchmark) {
                                blueMeetsRequirements = true;
                            }

                            else  {
                                blueMeetsRequirements = false;
                                gameMeetsRequirements = false;
                            }

                            // System.out.println("Blue is: " + blueMeetsRequirements);
                            break;
                        
                        default:
                            break;
                    }

                }
                 
            }


            if (gameMeetsRequirements) {
                // System.out.println("Good Game!");
                // add id to total, increment good games total
                idTotal += id;   
                goodGames++;
            }
            
            // count++;
        }

        
        System.out.println("Good Games: " + goodGames);
        System.out.println("ID Total: " + idTotal);

        System.out.println("Closing Scanner...");
        inFS.close();
        System.out.println("Scanner closed.");
    }
}

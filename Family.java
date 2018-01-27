/**
 * The purpose of this program is to read data from
 * an input file, tally up number of pairs, & display frequencies of family composition.
 *
 * @author Briana Berger
 * @version 11/13/2017
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Family
{
    public static void main(String[] args) throws IOException
    {
        int numberOfFamilies = 0;
        String token = "";
        int boys2 = 0;
        int girls2 = 0;
        int girlBoy = 0;
        File fileName = new File("maleFemaleInFamily.txt");
        Scanner inFile = new Scanner(fileName);

        //while loop will continue while inFile has a next token to read
        while( inFile.hasNext() )
        {
            token = inFile.nextLine( ); //read next token from file
            if(token.equals("BB"))
            {
                boys2++;
                numberOfFamilies++;
            }
            else if(token.equals("GG"))
            {
                girls2++;
                numberOfFamilies++;
            }
            else if(token.equals("GB") || token.equals("BG"))
            {
                girlBoy++;
                numberOfFamilies++;
            }
        }//end while
        double boys2Freq = (((double)boys2)/((double)numberOfFamilies)) * 100;
        double girls2Freq = (((double)girls2)/((double)numberOfFamilies)) * 100;
        double girlBoyFreq = (((double)girlBoy)/((double)numberOfFamilies)) * 100;
        
        boys2Freq = Math.round(boys2Freq * 100.0)/100.0;
        girls2Freq = Math.round(girls2Freq * 100.0)/100.0;
        girlBoyFreq = Math.round(girlBoyFreq * 100.0)/100.0;
        
        inFile.close(); //close input file
        System.out.println("Composition statistics for families with two childern.");
        System.out.println();
        System.out.println("Number of families with");
        System.out.println("        2 boys: " + boys2 + " represents " + boys2Freq + "%");
        System.out.println("       2 girls: " + girls2 + " represents " + girls2Freq + "%");
        System.out.println("1 boy & 1 girl: " + girlBoy + " represents " + girlBoyFreq + "%");
    }//end of main method
}//end of class
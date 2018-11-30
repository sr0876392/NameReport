/*Developer: Stan Razumov
  Date: 11/29/2018
  Name: Name reports 01-10
  Purpose: to create a ranking summary table of names
*/
package namesreport;
import java.io.*;
import java.nio.file.*;

public class NamesReport {

    public static void main(String[] args) {
        // array of paths
        String[] paths = {"src/namesreport/2010.txt",
                          "src/namesreport/2009.txt",
                          "src/namesreport/2008.txt",
                          "src/namesreport/2007.txt",
                          "src/namesreport/2006.txt",
                          "src/namesreport/2005.txt",
                          "src/namesreport/2004.txt",
                          "src/namesreport/2003.txt",
                          "src/namesreport/2002.txt",
                          "src/namesreport/2001.txt"
                                                    }; 
        int year = 2010;
        
        // for-each loop in paths arr
        for (String idx : paths){
            Path path = Paths.get(idx);
            File nameFile = path.toFile();
            try {
                BufferedReader in = new BufferedReader(
                                    new FileReader(nameFile));

                //read data from stream and print to console
                String line = in.readLine();
                System.out.println("Year: " + year);
                //looping throught first 5 rows of each file and getting needed fields
                for (int i = 0; i < 5; i++){
                    // Split the record into fields
                    String[] holdFields = line.split("\t");
                    String rank = holdFields[0];
                    String nameMale = holdFields[1];
                    String nameFemale = holdFields[3];
                    
                    System.out.println("\t" + "Rank: " +  rank + " | Boy Name: "  
                                        + nameMale + " | Girl Name: " + nameFemale);
                    line = in.readLine(); 
                }
                in.close();
            } //end try
            catch (IOException e) {
                System.err.println("Caugh IO Exception " + e.getMessage());
            } //end catch
            year--;
        }//end for-each
    }// end main   
}//end NamesReport class

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
 
public class Sort 
{   
    static class SurnameComparator implements Comparator<String> {
    public int compare(String l1, String l2) {
        String[] p1 = l1.split(" ");
        String[] p2 = l2.split(" ");
        if (p1.length > 1 && p2.length > 1)
            return p1[p1.length-1].compareTo(p2[p2.length-1]);
        else
            return 0;
    }
}
    public static void main(String[] args)
    {    
         BufferedReader reader = null;
         BufferedWriter  writer = null;
                 
        //Create an ArrayList object to hold the lines of input file
         
        ArrayList<String> lines = new ArrayList<String>();
         
        try
        {
            //Using BufferedReader to read lines of an input file
             
          reader = new BufferedReader(new FileReader("/Users/bhanu2/Desktop/Names.txt"));
             
           //Adding all lines to an ArrayList after reading it one by one
             
            String currentLine = reader.readLine();
             
            while (currentLine != null) 
            {
                lines.add(currentLine);
                 
                currentLine = reader.readLine();
            }
             
            //Sorting it on their LastNames
             
          Collections.sort(lines, new SurnameComparator());
             
            //Using BufferedWriter to write lines to an output file
             
            writer = new BufferedWriter(new FileWriter("/Users/bhanu2/Desktop/Surnames.txt"));
             
            //Writing sorted lines into output file
             
            for (String line : lines)
            {
                writer.write(line);
                 
                writer.newLine();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            //Close the space allocated by BufferedReader and BufferedWriter objects
             
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
                 
                if(writer != null)
                {
                    writer.close();
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }    
}

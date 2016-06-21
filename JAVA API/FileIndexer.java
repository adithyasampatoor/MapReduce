import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileIndexer
{

    public static void main(String[] args)           //     Main Method
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile("C:/input1.txt", "r");        // To Read Data From the File and 'raf' is the object created for 'RandomAccessFile'
            Map<String, ArrayList<Position>> index = new HashMap<String, ArrayList<Position>>();/*Hash Map to read the file and arrange the elements in a Map */

            String inputLine = raf.readLine();      // Takes data line by line and assigns to inputLine
            int colNumber = 0;
            int lineNumber = 1;                     // Declaration
            while (inputLine != null)    /*Iterative loop to index each Row and Column till there are no further rows in the input file*/
            {
                for (String key : inputLine.split("\\s"))    //Declaring the key (\\s) escape character
                {
                    if(key !=null && !"".equals(key.trim()))
                    {
                    if (index.containsKey(key))
                    {
                        
                        ArrayList<Position> value = index.get(key);
                        value.add(new Position(lineNumber, inputLine.indexOf(key, colNumber)));
                        index.put(key, value);
                    } else                          // 
                    {
                        ArrayList<Position> value = new ArrayList<Position>();                      
                        value.add(new Position(lineNumber, inputLine.indexOf(key, colNumber)));
                        colNumber=inputLine.indexOf(key, colNumber)+1;
                        index.put(key, value);
                    }
                    }
                }

                inputLine = raf.readLine();
                lineNumber++;
            }
            
            
            System.out.println(index.get("To"));

        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileIndexer
{
    public static void main(String[] args)          
    {
      try
        {
          // To Read Data From the File and 'raf' is the object created for 'RandomAccessFile'
          RandomAccessFile raf = new RandomAccessFile("C:/input1.txt", "r");        
            /*Hash Map to read the file and arrange the elements in a Map */
          Map<String, ArrayList<Position>> index = new HashMap<String, ArrayList<Position>>();
            // Takes data line by line and assigns to inputLine
          String inputLine = raf.readLine();      
          int colNumber = 0;
          int lineNumber = 1;          
            /*Iterative loop to index each Row and Column till there are no further rows
             in the input file*/         
          while (inputLine != null)    
          {
            for (String key : inputLine.split("\\s"))    
            {
                if(key !=null && !"".equals(key.trim()))
                {
                  if (index.containsKey(key))
                  {             
                     ArrayList<Position> value = index.get(key);
                     value.add(new Position(lineNumber, inputLine.indexOf(key, colNumber)));
                       index.put(key, value);
                  } else                          
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

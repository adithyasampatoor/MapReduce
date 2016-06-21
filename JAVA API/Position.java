
public class Position
{     
    /*Constructor method for Position class*/
    public Position(int rowNumber, int columnNumber)
    {
         // 'this' is a keyword referring to this particular class
      this.rowNumber = rowNumber;        
      this.columnNumber = columnNumber;
    }

    int rowNumber;
    int columnNumber;
    
    /*Getter method to return RowNumber*/
    public final int getRowNumber()
    {
      return this.rowNumber;
    }
    
    /*Getter method to return ColumnNumber*/
    public final int getColumnNumber()
    {
      return this.columnNumber;
    }
    
    /*Setter method for RowNumber*/
    public final void setRowNumber(int rowNumber)
    {
      this.rowNumber = rowNumber;
    }
    
    /*Setter method for ColumnNumber*/
    public final void setColumnNumber(int columnNumber)
    {
      this.columnNumber = columnNumber;
    }

    @Override
    public String toString()
    {
      return "Position [rowNumber=" + this.rowNumber + ", columnNumber=" + this.columnNumber + "]";
    }

}


/**
 * Write a description of class StringCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringCell extends Cell<String>
{
    protected String datatype;
    
    public StringCell()
    {
    }
    
    public StringCell(String type, String val)
    {
        datatype = type;
        value = val;
    }
    
    protected void blank()
    {
        value = "";
    }
    
    protected String getType()
    {
        return datatype;
    }
    
    protected void setType(String type)
    {
        datatype = type;
    }
    
    protected String getValue()
    {
        return value;
    }
}


/**
 * Write a description of class NumberCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberCell<T> extends Cell<Integer>
{
    protected T datatype;
    
    public NumberCell()
    {
    }
    
    public NumberCell(T datatype, Integer value)
    {
        this.datatype = datatype;
        super.value = value;
    }
    
    protected void zero()
    {
        value = 0;
    }
    
    protected T getType()
    {
        return datatype;
    }
    
    protected void setType(T type)
    {
        datatype = type;
    }
    
    protected Integer getValue()
    {
        return value;
    }
}

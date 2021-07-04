public class Holiday
{
    private String refNumber;
    private String type;
    private int price;
    
    
    public Holiday(String newRefNumber, String newType, int newPrice)
    {
        refNumber = newRefNumber;
        type = newType;
        price = newPrice;
    }
    public Holiday()
    {
        refNumber = "ABC123";
        type = "beach";
        price = 100;
    }
    public void setRefNumber(String newRefNumber)
    {
        refNumber = newRefNumber;
    }
    
    public String getRefNumber()
    {
        return refNumber;
    }
    
    public void setType(String newType)
    {
        type = newType;
    }
    public String getType()
    {
        return type;
    }
    
    public void setPrice(int newPrice)
    {
    price = newPrice;
    }
    
    public int getPrice()
    {
        return price;
    }
}

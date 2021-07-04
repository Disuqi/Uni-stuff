
public class Friend
{
    private String name;
    private int money;
    
    public Friend(String newName, int newMoney)
    {
        name = newName;
        money = newMoney;
    }
    public Friend()
    {
        name = "Jack";
        money = 1000;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }
    public void setMoney(int newMoney)
    {
        money = newMoney;
    }
    public int getMoney()
    {
        return money; 
    }
    public String toString()
    {
        return "Name: " + name + "\nMoney: £" + money;
    }
}


/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    private String name;
    private int age;
    private Account account;
    
    public Customer(String newName, int newAge)
    {
        name = newName;
        age = newAge;
    }
    public void newAccount(Account newAccount)
    {
        account = newAccount;
        account.setCustomer(this);
    }
    public String getName()
    {
        return name;
    }
}

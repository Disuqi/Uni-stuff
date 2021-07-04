import java.util.ArrayList;
public class Account
{
    private float balance;
    private int overdraftLimit;
    private float overdraftcharge;
    private Customer customer;
    private ArrayList<String> transactions;
    private ArrayList<String> charge;

    public Account()
    {
        balance = 0;
        overdraftLimit = 1000;
        overdraftcharge = 1.01f; 
        transactions = new ArrayList<String>();
        charge = new ArrayList<String>();
        customer = null;
 
    }
    public void setCustomer(Customer newCustomer)
    {
        customer = newCustomer;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public String getName()
    {
        return customer.getName();
    }
    public void depositMoney(float y)
    {
       balance += y;
       transactions.add("Deposit £"+ y);
    }
    
    public float getBalance()
    {
        return balance;
    }
    public void withdraw(float f)
    {
        if(balance - f > -overdraftLimit)
        {
           balance -= f;
           transactions.add("Withdraw £"+ f);
        }
        if(balance < 0)
        {
            balance *= overdraftcharge;
            charge.add("Charge : £" + (balance * -(overdraftcharge - 1.0f)));
        }
    }
    public float getOverdraftlimit()
    {
        return overdraftLimit;
    }
    public void setOverdraftCharge(int newCharge)
    {
        overdraftcharge = newCharge;
    }
    public void transfer(Account transferTo, float howMuch)
    {
        if (howMuch > 0 && balance - howMuch > -overdraftLimit)
        {
            transferTo.transferIn(howMuch);
            balance -= howMuch;
            transactions.add("Transfer out £"+ howMuch);
        }
            if(balance < 0)
        {
            balance *= overdraftcharge;
            charge.add("Charge : £" + (balance * -(overdraftcharge - 1.0f)));
        }
    }
    public void transferIn(float howMuch)
    {
        balance += howMuch;
        transactions.add("Transfer in £" + howMuch);
    }
    
    public void statement()
    {
        System.out.println(transactions);
    }
}

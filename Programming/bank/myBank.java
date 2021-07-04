import java.util.ArrayList;
public class myBank
{
 private ArrayList<Account> accountList;
 
 public myBank()
 {
     accountList = new ArrayList<Account>();
 }
 public void addAccount(Account account)
 {
     accountList.add(account);   
 }
 public void displayHolder()
 {
     System.out.println(accountList);
 }
 public int getNumberOfAccounts()
 {  
     return accountList.size();
 }
 public Account getAccount(String name)
 {
     for(Account account : accountList)
     {
      if(account.getName() == name)
      {
          return account;
      } 
     }
     return null;
 }
 public void transfer(Account yourAccount, Account transferTo, float amount)
 {

        yourAccount.transfer(transferTo, amount);
    
}                                
}

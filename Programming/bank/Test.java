public class Test
{
    public void testDeposit(float money)
    {
        Customer customer = new Customer("Alan", 20);
        Account account = new Account();
        account.depositMoney(money);
        if(account.getBalance() == money)
        {
            System.out.println("it worked");
        }
    }
}

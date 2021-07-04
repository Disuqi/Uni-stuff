import java.util.ArrayList;

public class Member
{
private String email;
private int membershipNumber;
private boolean loggedInStatus;
private Holiday holiday;
private Website website;
private ArrayList<Friend> companions;
private float money;


public Member(String newEmail, int newMembershipNumber)
{
    email = newEmail;
    membershipNumber = newMembershipNumber;
    loggedInStatus = false;
    holiday = null;
    website = null;
    companions = new ArrayList<Friend>();
    money = 0; 
}

public Member()
{
    email = "abc@email.com";
    membershipNumber = 12345;
    loggedInStatus = false;
    holiday = null;
    website = null; 
    companions = new ArrayList<Friend>();
    money = 10000;
}
public void setEmail(String newEmail)
{
    email = newEmail;
}

public String getEmail()
{
    return email;
}

public void setMembershipNumber(int newMembershipNumber)
{
    membershipNumber = newMembershipNumber;
}

public int getMembershipNumber()
{
    return membershipNumber;
}

public void setLoggedInStatus(boolean newLoggedInStatus)
{
    if(website != null){
        loggedInStatus = newLoggedInStatus;
    }else{
        System.out.println("Please select a website first");
    }
}

public boolean getLoggedInStatus()
{
    return loggedInStatus;
}

public void selectHoliday(Holiday newHoliday)
{
    if(loggedInStatus == true && checkMoney(newHoliday.getPrice()) == true)
    {
        holiday = newHoliday;
        System.out.println("member ID: "+ membershipNumber + "\nholiday ref number: "
        + holiday.getRefNumber() + "\nholiday type: " + holiday.getType() + "\nholiday price: £" + holiday.getPrice());
    }
    else
    {
        System.out.println("Please log-in first");
    }
}

public Holiday getHoliday()
{
    return holiday;
}

public void setWebsite(Website newWebsite)
{
    website = newWebsite;
}
public Website getWebsite()
{
return website;
}

public void payForHoliday()
{
    if(holiday != null && loggedInStatus == true && checkMoney(holiday.getPrice())== true)
    {
            for(Friend friend : companions)
            {
                friend.setMoney(friend.getMoney() - holiday.getPrice());
                money += holiday.getPrice();
            }
        website.checkout(this, holiday);
    }
    else
    {
    System.out.println("please select a holiday first");
    }
}

public String toString()
{
    return "mebership number: "+ membershipNumber + "\nemail: " + email +  "\nlogged in status: " + loggedInStatus;
}
public ArrayList<Friend> getCompanions()
{
    return companions;
}
public void setCompanions(ArrayList<Friend> newCompanions)
{
    companions = newCompanions;
}
public void storeFriend(Friend friend)
{
    companions.add(friend);
}
public void removeFriend(Friend friend)
{
    companions.remove(friend);
}
public Friend getFriend(int indexPosition)
{
    if(indexPosition < companions.size())
    {
        return companions.get(indexPosition);
    }
    else
    {
        return null;
    }
}
public void listFriends()
{
    for(Friend friend : companions)
    {
        System.out.println(friend.toString());
    }
}
public int getNumberOfFriends()
{
    return companions.size();
}
public void setMoney(float newMoney)
{
money = newMoney;
}
public float getMoney()
{
    return money;
}
private boolean checkMoney(int cost)

{
    int i = 0;
    boolean found = false;
    if(money >= cost)
    {
        while( i+1 <= companions.size() && found == false)
        {
            if(companions.get(i).getMoney() < cost)
            {
                found = true;
            }
            else
            {
                i ++;
            }
        }
        if(found == true)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    else
    {
        return false;
    }
}
public void whoCannotPay(Holiday holiday)
{
    if(money < holiday.getPrice())
    {
        System.out.println("You have insufficient money to afford this holiday");
    }
    for(Friend friend : companions)
    {
        if(friend.getMoney() < holiday.getPrice())
        {
            System.out.println(friend.getName() + " has insufficient money to afford this holiday");
        }
    }
}
public int companionsSize()
{
    return companions.size();
}
public void returnMoney()
{
    if(holiday != null){
    for(Friend friend : getCompanions())
        {
            friend.setMoney((int)((float)friend.getMoney() + (float)holiday.getPrice() * 0.1f));
            setMoney(getMoney() - (float)holiday.getPrice() * 0.1f);
        }
    }
}
}

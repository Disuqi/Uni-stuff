import java.util.ArrayList;

public class Website
{
    private String websiteName;
    private int hits;
    private float salesTotal;
    private ArrayList<Member> loggedInList;
    private Company company;
    
    public Website(String newWebsiteName)
    {
        websiteName = newWebsiteName;
        hits = 0;
        salesTotal = 0;
        loggedInList = new ArrayList<Member>();
        company = null;
    }
    public Website()
    {
        websiteName = "ABC";
        hits = 9;
        salesTotal = 0;
        loggedInList = new ArrayList<Member>();
    }
    public void setWebsiteName(String newWebsiteName)
    {
        websiteName = newWebsiteName;
    }
    
    public String getWebsiteName()
    {
        return websiteName;
    }
    public void setHits(int newHits)
    {
        hits = newHits;
    }

    public int getHits()
    {
        return hits;
    }
    
    public void setSalesTotal(float newSalesTotal)
    {
        salesTotal = newSalesTotal;
    }
    
    public float getSalesTotal()
    {
        return salesTotal;
    }
    
    public void memberLogin(Member member)
    {
        if(member.getLoggedInStatus() == false)
        {
            member.setWebsite(this);
            member.setLoggedInStatus(true);
            System.out.println( websiteName + " welcomes member " + member.getMembershipNumber() + ", you are now logged in");
            loggedInList.add(member);
            hits ++;
        }
        else
        {
            System.out.println("You have already logged-in");
        }
    }
    public void memberLogout(Member logOffMember)
    {
        if(logOffMember.getLoggedInStatus() == true)
        {
            loggedInList.remove(logOffMember);
            logOffMember.setLoggedInStatus(false);
        }
        else
        {
            System.out.println("You are already logged off");
        }
    }
    
    public void checkout(Member member, Holiday holiday)
    {
        if (member.getLoggedInStatus() == true)
        {
            
            if(checkHitDiscount() == true)
            {
                System.out.println("Congratulations you have received a 10% discount, the new price for you is: £" + holiday.getPrice() * 0.9f);
                member.setMoney(member.getMoney() - (float)holiday.getPrice() * 0.9f * (1+ member.companionsSize()));
                salesTotal += ((float)holiday.getPrice() * 0.9f)*(1+member.companionsSize());
            }
            else
            {
                member.setMoney(member.getMoney()-(holiday.getPrice()*(1+member.companionsSize())));
                salesTotal += holiday.getPrice()*(1+member.companionsSize());
            }
        
            System.out.println("Congratulations member:" + member.getMembershipNumber() +" you successfully purchased your holiday");
            memberLogout(member);
        }
        else
        {
            System.out.println("Please log-in first");
        }
    }
    private boolean checkHitDiscount()
    {
        if(hits % 10 == 0 && hits != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public ArrayList<Member> getLoggedInList()
    {
        return loggedInList;
    }
    public void setLoggedInList(ArrayList<Member> newLoggedInList)
    {
        loggedInList = newLoggedInList;
    }
    public void addLoggedInMember(Member member)
    {
        loggedInList.add(member);
    }
    public void removeLoggedInMember(Member member)
    {
        loggedInList.remove(member);
    }
    public int getNumberOfUsers()
    {
        return loggedInList.size();
    }
    public void listMembersLoggedIn()
    {
        for(Member member :  loggedInList)
        {
            System.out.println(member.toString());
        }
    }
    public Member getLoggedInMember(int indexPosition)
    {
        if(indexPosition < loggedInList.size())
        {
            return loggedInList.get(indexPosition);
        }
        else
        {
            return null;
        }
    }
    public String toString()
    {
        return "Website name: " + websiteName + "\nhits: " + hits + "\nSales total: £" + salesTotal;
    }
    public void setCompany(Company newCompany)
    {
        company = newCompany;
    }
    public Company getCompany()
    {
        return company;
    }

}

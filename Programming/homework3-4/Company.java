import java.util.ArrayList;
public class Company
{
    private ArrayList<Website> websites;

    
    public Company()
    {
        websites = new ArrayList<Website>();
    }
    public void addWebsite(Website website)
    {
        websites.add(website);
        website.setCompany(this);
    }
    public void removeWebsite(Website website)
    {
        websites.remove(website);
    }
    public Website getWebsite(int indexPosition)
    {
        if(indexPosition < websites.size())
        {
            return websites.get(indexPosition);
        }
        else
        {
            return null;
        }
    }
    public ArrayList<Website> getWebsites()
    {
        return websites;
    }
    public void setWebsites(ArrayList<Website> newWebsites)
    {
        websites = newWebsites;
    }
    public int getwebsitesSize()
    {
        return websites.size();
    }
    public ArrayList<Website> findProfitableWebsite(int salesTotal)
    {
        ArrayList<Website> profitableWebsites = new ArrayList<Website>();
        for(Website website : websites)
        {
            if(website.getSalesTotal() >= salesTotal)
            {
                profitableWebsites.add(website);
            }
        }
        return profitableWebsites;
    }
    
   public ArrayList<Member>  findMembersHoliday(Holiday holiday)
   {
       ArrayList<Member> memberList = new ArrayList<Member>();
       for(Website website : websites)
       {
           for(Member member : website.getLoggedInList())
           {
               if(member.getHoliday().equals(holiday))
               {
                   memberList.add(member);
               }
           }
       }
       return memberList;
   }
   public void listWebsitesOwned()
   {
       for(Website website : websites)
       {
            System.out.println(website.toString());
       }
       
   }


}

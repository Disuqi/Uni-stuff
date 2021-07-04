public class Manager
{
    public String surname;
    private String managerID;
    
    public Manager(String newSurname, String newManagerID)
    {
        surname = newSurname;
        managerID = newManagerID;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public void setSurname(String newSurname)
    {
        surname = newSurname;
    }
    
    public String getManagerID()
    {
        return managerID;
    }    
    public void setManagerID(String newManagerID)
    {
        managerID = newManagerID;
    }
}

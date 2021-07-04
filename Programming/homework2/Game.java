public class Game
{
    private String title;
    private String objective;
    private int costInPence;
    private int numberOfDownloads;
    private String bestScoreName;
    private int bestScore;
    private Manager gameManager;
    
    public Game(String newTitle, String newObjective, int newCostInPence, Manager newGameManager)
    {
     title = newTitle;
     objective = newObjective;
     costInPence = newCostInPence;
     numberOfDownloads = 0;
     bestScoreName = "";
     bestScore = 0;
     gameManager = newGameManager;
    }
    public Game()
    {
        title = "title";
        objective = "objective";
        costInPence = 10;
        numberOfDownloads = 1;
        bestScoreName = "bestScoreName";
        bestScore = 1;
        gameManager = new Manager("surname", "managerID");
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }  
    
    public String getObjective()
    {
        return objective;
    }
    
    public void setObjective(String newObjective)
    {
        objective = newObjective;
    }
    
    public int getCostInPence()
    {
        return costInPence;
    }
    
    public void setCostInPence(int newCostInPence)
    {
        costInPence = newCostInPence;
    }
    
    public void download()
    {
        numberOfDownloads ++;
        System.out.println("Congratulations you purchased " + title + " for " + costInPence + "p.");
    }
    
    public void checkScore(int newBestScore, String newBestScoreName)
    {
        if(newBestScore > bestScore)
        {
            bestScore = newBestScore;
            bestScoreName = newBestScoreName;
        }
    }
    
    public String getBestScoreName()
    {
        return bestScoreName;
    }
    
    public void setBestScoreName(String newBestScoreName)
    {
        bestScoreName = newBestScoreName;
    }
    
    public int getBestScore()
    {
        return bestScore;
    }
    
    public void setBestScore(int newBestScore)
    {
        bestScore = newBestScore;
    }
    
    public int getNumberOfDownloads()
    {
        return numberOfDownloads;
    }
    
    public void setNumberOfDownloads(int newNumberOfDownloads)
    {
        numberOfDownloads = newNumberOfDownloads;
    }
    public void setGameManager(Manager newGameManager)
    {
        gameManager = newGameManager;
    }
    public Manager getGameManager()
    {
        return gameManager;
    }
    
    public void printReport()
    {
        System.out.println("Title: " + getTitle() + "\nObjective: " + getObjective() + "\nDownload cost: " + getCostInPence() + 
        "\nNumber of downloads to date: " + getNumberOfDownloads() + "\nBest score to date: " + getBestScore() +
        "\nPlayer with best score: " + getBestScoreName() + "\nEarnings to date: " + calculateEarnings() + "\nManager's name: " + gameManager.getSurname());
    }
    
    public int calculateEarnings()
    {
        return numberOfDownloads * costInPence;
    }
    public String divide(int number, int divisor)

{

return "The number " + number + " divided by " + divisor + " is " + number/divisor + " remainder " + number%divisor;

}
    
}

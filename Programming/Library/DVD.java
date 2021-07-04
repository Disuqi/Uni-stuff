import java.util.Scanner;
public class DVD extends AudioVisual
{
    private String director;
    
    public DVD(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan, int playingTime, String director)
    {
        super(title, itemCode, cost, timesBorrowed, onLoan, playingTime);
        this.director = director;
    }
    public DVD(){}
    public String getDirector()
    {
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The director is " + director + ".");
    }
    public void readData(Scanner scanner)
    {
        director = scanner.next();
        super.readData(scanner);
    }
}

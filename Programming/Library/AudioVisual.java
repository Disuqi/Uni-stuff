import java.util.Scanner;
public abstract class AudioVisual extends LibraryItem
{
    private int playingTime;
    
    public AudioVisual(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan, int playingTime)
    {
        super(title, itemCode, cost, timesBorrowed, onLoan);
        this.playingTime = playingTime;
    }
    public AudioVisual()
    {
    }
    public int getPlayingTime()
    {
        return playingTime;
    }
    public void setPlayingTime(int playingTime)
    {
        this.playingTime = playingTime;
    }
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The playing time is " + playingTime + ".");
    }
    public void readData(Scanner scanner)
    {
        playingTime = scanner.nextInt();
        super.readData(scanner);
    }
}

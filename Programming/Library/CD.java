import java.util.Scanner;
public class CD extends AudioVisual
{
    private String artist;
    private int numberOfTracks;
    
    public CD(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan, int playingTime, String artist, int numberOfTracks)
    {
        super(title, itemCode, cost, timesBorrowed, onLoan, playingTime);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }
    public CD(){}
    public String getArtist()
    {
        return artist;
    }
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }
    public void setNumberOfTracks(int numberOfTracks)
    {
        this.numberOfTracks = numberOfTracks;
    }
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The artist is " + artist + " and it has " + numberOfTracks + " tracks.");
    }
    public void readData(Scanner scanner)
    {
        artist = scanner.next();
        numberOfTracks = scanner.nextInt();
        super.readData(scanner);
    }
}

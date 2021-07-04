import java.util.Scanner;
public class Book extends PrintedItem
{
    private String author;
    private String isbn;
    
    
    public Book(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan, int noOfPages, String publisher, String author, String isbn)
    {
        super(title, itemCode, cost, timesBorrowed, onLoan, noOfPages, publisher);
        this.author = author;
        this.isbn = isbn;
    }
    public Book(){}
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
        public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.println("The author is " + author + " and the isbn is " + isbn );        
    }
    public void readData(Scanner scanner)
    {
        author = scanner.next();
        isbn = scanner.next();
        super.readData(scanner);
    }
}

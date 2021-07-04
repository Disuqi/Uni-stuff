public class House
{
    private String typeOfHouse;
    private String address;
    private int initialPrice;
    private int purchasePrice;
    private int homeEnergyRating;
    private char councilTaxBand;
    private String owner;
    private boolean hasGarage;
    private int numberOfOwners;
    private int numberOfBathrooms;
    private boolean hasDiningRoom;
    private boolean hasGarden;
    private boolean hasParking;
    
    
    public House(String newTypeOfHouse, String newAddress, int newInitialPrice,int newHomeEnergyRating, char newCouncilTaxBand, boolean newHasGarage)
    {
        typeOfHouse = newTypeOfHouse;
        address = newAddress;
        initialPrice = newInitialPrice;
        purchasePrice = newInitialPrice;
        homeEnergyRating = newHomeEnergyRating;
        councilTaxBand = newCouncilTaxBand;
        owner =  null;
        hasGarage = newHasGarage;
        numberOfOwners = 0;
        numberOfBathrooms = 1;
        hasDiningRoom = false;
        hasGarden = false;
        System.out.println(checkHomeEnergy());
    }
    public void setPurchasePrice(int newPurchasePrice)
    {
        purchasePrice = newPurchasePrice; 
    }
    
    public void setOwner(String newOwner)
    {
        owner = newOwner;
        numberOfOwners += 1;
    }
    
    public void goingGreener(int newHomeEnergyRating)
    {
        homeEnergyRating = newHomeEnergyRating;
    }
    
    public String getType()
    {
        return typeOfHouse;
    }
    public String getAdress()
    {
        return address;
    }
    
    public int getPurchasePrice()
    {
        return purchasePrice;
    }
    
    public String checkHomeEnergy()
    {
       return homeEnergyRating < 3 ? "Be aware that extra green taxes may be imposed on this house" : "This house will not be subject to extra taxes";          
    }
    
    public void printDetails()
    {
        System.out.println("This house is a " + typeOfHouse + " at " + address + ", with an original purchase price of £" + initialPrice + ". The current price is £" + purchasePrice + ", its home energy rating is " + homeEnergyRating + " and its council Tax Band is " + councilTaxBand + ". It has had " + numberOfOwners + " owner" + (numberOfOwners == 1 ? "" : "s") + " and the current owner is " + owner + ".");
    }
    
    public void sell(int newPurchasePrice, String newOwner)
    {
        setPurchasePrice(newPurchasePrice);
        setOwner(newOwner);
    }
    
    public void setNumberOfBathrooms(int newNumberOfBathrooms)
    {
        numberOfBathrooms = newNumberOfBathrooms;
    }
    public void setHasDiningRoom(boolean newHasDiningRoom)
    {
        hasDiningRoom = newHasDiningRoom;
    }
    public void setHasGarden(boolean newHasGarden)
    {
        hasGarden = newHasGarden;
    }
    public int checkNumberOfBathrooms()
    {
        return numberOfBathrooms;
    }
    public boolean checkHasDiningRoom()
    {
        return hasDiningRoom;
    }
    public boolean checkHasGarden()
    {
        return hasGarden;
    }
    public int checkNumberOfOwners()
    {
        return numberOfOwners;
    }
    public boolean chekHasParking()
    {
        return hasParking;
    }
    public void setHasParking(boolean newHasParking)
    {
        hasParking = newHasParking;
    }
}

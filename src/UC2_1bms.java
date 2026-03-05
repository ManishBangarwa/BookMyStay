
public abstract class UC2_1bms {


    protected int numberOfBeds;

    protected int squareFeet;
    protected double pricePerNight;

    public UC2_1bms(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Room Details:");
        System.out.println("- Number of Beds: " + numberOfBeds);
        System.out.println("- Square Footage: " + squareFeet + " sq ft");
        System.out.printf("- Price per Night: $%.2f%n", pricePerNight);
    }
}
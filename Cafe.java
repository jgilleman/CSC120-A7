/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    public boolean elevator;

    /*Constructor that makes a new Cafe
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * @param elevator
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean elevator) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe.");
    }

    /* Overloaded Constructor. If elevator status not mentioned, elevator=false
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.elevator=false;
        System.out.println("You have built a cafe.");
    }

    /* Overloaded Constructor. If elevator status not mentioned, elevator=false. If floor number not specified, nFloors=1
     * @param name
     * @param address
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, 1);
        this.elevator=false;
        System.out.println("You have built a cafe.");
    }

    /*Method. Prints the available method options*/
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee(size, nSugarPackets, nCreams)\n");
    }

    /*Method. Doesn't allow movement to other floors
     * @param floorNum
     */
    public void goToFloor(int floorNum) {
         System.out.println("There is no elevator in this building and you aren't allowed to move off this floor. Try something else");
    }

    /* Method sells coffee according to size, sugar, and cream requests. If out of some ingredient, restock.
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1; 

        System.out.println("1 cup of coffee sold.");

        if (this.nCoffeeOunces<=0) {
            restock(60, 0, 0, 0);
        } if (this.nSugarPackets<=0) {
            restock(0, 10, 0, 0);
        } if (this.nCreams<=0) {
            restock(0, 0, 10, 0);
        } if (this.nCups<=0) {
            restock(0, 0, 0, 10);
        }
    }

    /* Method restocks inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("We have restocked the inventory");
    }


    public static void main(String[] args) {
        Cafe myCafe = new Cafe("CompassCafe", "Smith St Northampton", 4, 12, 12, 12, 12);
        myCafe.sellCoffee(12, 7, 1);

        System.out.println("nCoffeOunces: " + myCafe.nCoffeeOunces +
                            " nSugarPackets: " + myCafe.nSugarPackets +
                            " nCreams: " + myCafe.nCreams +
                            " nCups: " + myCafe.nCups);

        myCafe.sellCoffee(12, 3, 12);

        System.out.println("nCoffeOunces: " + myCafe.nCoffeeOunces +
                            " nSugarPackets: " + myCafe.nSugarPackets +
                            " nCreams: " + myCafe.nCreams +
                            " nCups: " + myCafe.nCups);

        myCafe.sellCoffee(12, 3, 12);

        System.out.println("nCoffeOunces: " + myCafe.nCoffeeOunces +
                            " nSugarPackets: " + myCafe.nSugarPackets +
                            " nCreams: " + myCafe.nCreams +
                            " nCups: " + myCafe.nCups);

    }
    
}

/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  public boolean elevator;

  /* Super Constructor makes House by extending Building
   * @param name
   * @param address
   * @param nFloors
   * @param hasDR
   */
  public House(String name, String address, int nFloors, boolean hasDR, boolean elevator) {
    super(name, address, nFloors); //the first set of steps to constructing this house is to construct building
    this.hasDiningRoom = hasDR;
    this.residents = new ArrayList<String>();

    System.out.println("You have built a house.");
  }

  /*Overloaded Constructor. If nFloors wasn't specified then set nFloors to 1.*/
  public House(String name, String address, boolean hasDR, boolean elevator) {
    super(name, address, 1); //the first set of steps to constructing this house is to construct building
    this.hasDiningRoom = hasDR;
    this.residents = new ArrayList<String>();

    System.out.println("You have built a house.");
  }

  /*Overloaded Constructor. If hasDR wasn't specified then set hasDR to true.*/
  public House(String name, String address) {
    super(name, address, 1); //the first set of steps to constructing this house is to construct building
    this.hasDiningRoom = true;
    this.residents = new ArrayList<String>();

    System.out.println("You have built a house.");
  }

  /*Overloaded constructor. If elevator not set, then elevator=false */
  public House(String name, String address, int nFloors, boolean hasDR) {
    super(name, address, nFloors); //the first set of steps to constructing this house is to construct building
    this.hasDiningRoom = hasDR;
    this.elevator = false;
    this.residents = new ArrayList<String>();

    System.out.println("You have built a house.");
  }

  /*Method. Prints the available method options*/
  public void showOptions() {
    System.out.println("Available options at " + this.name + 
    ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(name)\n + moveOut(name)\n + isResident(person)");
 }

  /*method. Sets floor number to number specified. Mimicks elevator.
   * @param floorNum
   */
 public void goToFloor(int floorNum) {
  if (elevator = true) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
  } else {
      System.out.println("There is no elevator in this building. Try something else");
  }
}

  /* Method keeps track of dining room status
   * @return bool Does it have a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /* Method number of residents
   * @return int How many residents live in the house
   */
  public int nResidents() {
    return this.residents.size(); //gets the current size of the array list
  }

  /* Method moves resident into house
   * @param name
   */
  public void moveIn(String name) {
    residents.add(name);
    System.out.println("\nMoving " + name + " in. Done.");
  }
  
  /* Method moves resident out
   * @param name
   * @return String If name not found return "not found"
   */
  public String moveOut(String name) {
    boolean b = residents.remove(name);
    System.out.println("\nMoving " + name + " out. Done.");
    return b ? name : "Name not found"; //fancy pants operator that says if b is true (if name is found in list), removes name, if not return "not found"
  }

  /* Method asks if a person is a resident
   * @param person
   * @return bool Is this person a resident?
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  public static void main(String[] args) {
    House myHouse = new House("GillemanHouse", "40 Spring Street", 2, true);
    System.out.println("\n The statement \"This house has a dining room\" is " + myHouse.hasDiningRoom());
    myHouse.moveIn("Jessie");
    myHouse.moveIn("Joey");
    myHouse.moveIn("Johannes");
    myHouse.moveOut("Jessie");
    System.out.println("\n This house has " + myHouse.nResidents() + "residents.");
    System.out.println("\n The statement \"Jessie is a resident of this house\" is " + myHouse.isResident("Jessie"));
    System.out.println("\n The statement \"Jessie is a resident of this house\" is " + myHouse.isResident("Johannes"));
  }

}
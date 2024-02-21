package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    /*
     * It demonstrates the "Long Parameter List" anti-pattern. 
     * This occurs when a method or constructor takes too many parameters, making the code hard to understand and maintain. 
     * In this case, the addRecord method in Records and the constructor of Frogger
     * both take a long list of parameters related to the frogger's personal details.
     * To fix this, we use the FroggerID record class to store the frogger's personal details.
     */
    private final Records records;
    // private String firstName, lastName, phoneNumber, zipCode, state, gender;
    private FroggerID froggerID;

    public Frogger(Road road, int position, Records records, FroggerID froggerID) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = froggerID;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!road.isValid(nextPosition) || road.isOccupied(nextPosition)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    /*
     * This method presents a case of feature envy. It should be moved to the Road class.
     * the Frogger class is overly reliant on the internal workings of the Road class, particularly on its occupied array. 
     * The "occupied" field should be managed by the Road class.
     * This violates the principle of encapsulation
     * A class should manage its own data and behavior, and not rely on the internal workings of another class.
     */
    // TODO: Do you notice any issues here?
    // public boolean isOccupied(int position) {
    //     if (!isValid(position)) return false;
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }
    
    // public boolean isValid(int position) {
    //     if (position < 0) return false;
    //     boolean[] occupied = this.road.getOccupied();
    //     return position < occupied.length;
    // }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
    //   boolean success = records.addRecord(firstName, lastName, phoneNumber, zipCode, state, gender);
    //   return success;
        return records.addRecord(froggerID);
    }

}

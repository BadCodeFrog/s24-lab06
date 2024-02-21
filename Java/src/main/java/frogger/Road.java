package frogger;

/**
 * Refactor Task 1.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        this.occupied = occupied;
    }

    /**
     * Checks if the position is occupied.
     * @param position the position to check.
     * @return true if the position is occupied, else false.
     */
    public boolean isOccupied(int position) {
        if (position < 0 || position >= occupied.length) {
            return false;
        }
        return occupied[position];
    }

    public boolean isValid(int position) {
        if (position < 0) return false;
        boolean[] occupied = this.getOccupied();
        return position < occupied.length;
    }

    /*
     * Now that the "isOccupied" method has been moved to the Road class, the "getOccupied" method can be private.
     */
    private boolean[] getOccupied() {
        return this.occupied;
    }
}

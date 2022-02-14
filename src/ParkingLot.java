public class ParkingLot {

    private int size=0;
    private int hourFee;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFee(int hours) {
        return hours > 0 : hours;
    }
}

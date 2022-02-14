import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot codeUnderTest;

    @BeforeEach
    void init(){
        codeUnderTest = new ParkingLot();
    }

    @Test
    void parkingLotGetSize(){
        // Give
        int expected = 6;
        codeUnderTest.setSize(6);
        // When

        int actual = codeUnderTest.getSize();

        assertEquals(expected, actual);

    }

    @Test
    void parkingLotGetFee(){
        // Give
        int expected = 6;
        int hours = 3;
        codeUnderTest.setSize(6);
        // When


        int actual = codeUnderTest.getFee(3);

        assertEquals(expected, actual);

    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToDecimalTest {

    RomanToDecimal romanToDecial;

    @BeforeEach
    public void init() {
        romanToDecial = new RomanToDecimal();
    }


    @ParameterizedTest(name ="Test Standart Values for RomanToDecimal {0}" )
    //@ValueSource(ints = {1, 5, 10, 50, 100, 500, 1000})
    @CsvSource({"I,1", "V,5", "X,10", "L, 50,", "C, 100", "D, 500", "M, 1000"})
    public void simpleConvertRomanToDecimal(String input, String expected){

        //Give
        String inputValue = input;

        //When
        int output = romanToDecial.convert(inputValue);

        //Then
        int expectedValue = Integer.parseInt(expected);
        assertEquals(expectedValue, output);
    }

    @Test
    public void subCovertRomanToDecimal(){
        // Give
        String inputValue = "IV";
        String inputValue2 = "IX";

        // When
        int output = romanToDecial.convert(inputValue);
        int output2 = romanToDecial.convert(inputValue2);

        //Then
        int expectedValue = 4;
        int expectedValue2 = 9;

        assertEquals(expectedValue, output);
        assertEquals(expectedValue2, output2);
    }


    @Test
    public void simpleAddtionCovertRomanToDecimal(){
        // Give
        String inputValue = "MMV";

        // When
        int output = romanToDecial.convert(inputValue);

        //Then
        int expectedValue = 2005;

        assertEquals(expectedValue, output);
    }

    @Test
    public void complexConvertTest(){
        // Give
        String inputValue = "MCMXLIV";

        // When
        int output = romanToDecial.convert(inputValue);

        //Then
        int expectedValue = 1944;

        assertEquals(expectedValue, output);
    }

}

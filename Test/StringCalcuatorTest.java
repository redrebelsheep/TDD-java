import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {


//    @Test
//    @DisplayName("StringCalculatorTest 1 Input Null Return zero")
//    public void testStringCalculator_returnZeroWithNullInput() {
//        // GIVEN
//        String input = null;
//
//        // WHEN
//        int output = StringCalculator.add(input);
//
//        // THEN
//        int expected = 0;
//        assertEquals(expected, output);
//    }

    @Test
    @DisplayName("StringCalculatorTest 1 Return zero")
    public void testStringCalculator_returnZeroWithEmptyInput() {
        // GIVEN
        String input = "";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 0;
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("StringCalculatorTest 2 Return a number (1)")
    public void testStringCalculator_returnSingleNumber() {
        // GIVEN
        String input = "1";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 1;
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("StrubgCalculatorTest 3 Return multiNumbers")
    public void testStringCalculator_returnMultipleNumbers() {
        // GIVEN
        String input = "1,2,100,1000";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 103;
        assertEquals(expected, output);
    }
//
    @Test
    @DisplayName("StrubgCalculatorTest 4 Return multiNumbers with Linebreack")
    public void testStringCalculator_returnMultipleNumbersWithSupportForLinebreakAndComma() {
        // GIVEN
        String input = "1,2,100\n1000";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 103;
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("StrubgCalculatorTest 5 Return multiNumbers with new Trenner")
    public void testStringCalculator_returnMultipleNumbersWithCustomDelimiter() {
        // GIVEN
        String input = "//;\n1;2";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("StrubgCalculatorTest 6 Return Expetion if negativ")
    public void testStringCalculator_negativesThrowExceptionsContainingAllNegatives() {
        // GIVEN
        String input = "-1,2";
        String expected = "negatives not allowed -1";

        // WHEN

        // THEN
        Throwable exception = assertThrows(Exception.class, () -> StringCalculator.add(input),
                "Line was expected (negatives not allowed) ");
        assertEquals(expected, exception.getMessage( ));

    }
//
    @Test
    @DisplayName("StrubgCalculatorTest 7 Ignores Numbers bigger then 1000")
    public void testStringCalculator_ignoresNumbersBiggerThanOnethousand() {
        // GIVEN
        String input = "2,1001";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 2;
        assertEquals(expected, output);
    }
//

    @Test
    @DisplayName("StrubgCalculatorTest 8 Ignores Numbers long Deli")
    public void testStringCalculator_longDeli() {
        // GIVEN
        String input = "//[xxx]\n1xxx2xxx3";
        // [ .... ] [ .... ] \n

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 6;
        assertEquals(expected, output);
    }

    @Test
    public void testStringCalculator_allChar() {
        // GIVEN
        String input = "//[+][x]\n1+2x3";
        // [ .... ] [ .... ] \n

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 6;
        assertEquals(expected, output);
    }

}
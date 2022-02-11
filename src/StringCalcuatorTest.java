import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {



    @Test
    public void testStringCalculator_returnZeroWithNullInput() {
        // GIVEN
        String input = null;

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 0;
        assertEquals(expected, output);
    }

    @Test
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
    public void testStringCalculator_returnMultipleNumbers() {
        // GIVEN
        String input = "1,2,100,1000";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 1103;
        assertEquals(expected, output);
    }

    @Test
    public void testStringCalculator_returnMultipleNumbersWithSupportForLinebreakAndComma() {
        // GIVEN
        String input = "1,2,100\n1000";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 1103;
        assertEquals(expected, output);
    }

    @Test
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
    public void testStringCalculator_returnMultipleNumbersWithCustomDelimiterAndManySetup() {
        // GIVEN
        String[] inputs = {
                "//;\n1;2",
                "//\n\n2\n2",
                "//n\n1n1n1",
                "//---\n5---5"
        };
        int[] expected = {
                3,
                4,
                3,
                10
        };

        // WHEN
        int[] outputs = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++) {
            outputs[i] = StringCalculator.add(inputs[i]);
        }

        // THEN
        assertArrayEquals(expected, outputs);
    }

    @Test
    public void testStringCalculator_negativesThrowExceptionsContainingAllNegatives() {
        // GIVEN
        String input = "-1,-2";

        // WHEN

        // THEN
        Throwable exception = assertThrows(Exception.class, () -> StringCalculator.add(input));
        assertEquals(exception.getMessage(), "negatives not allowed: -1, -2");
    }

    @Test
    public void testStringCalculator_ignoresNumbersBiggerThanOnethousand() {
        // GIVEN
        String input = "2,1001";

        // WHEN
        int output = StringCalculator.add(input);

        // THEN
        int expected = 2;
        assertEquals(expected, output);
    }

    @Test
    public void testStringCalculator_foooooooooooo() {
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
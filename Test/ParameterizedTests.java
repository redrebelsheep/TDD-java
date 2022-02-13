import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTests {

    public boolean isPalindrome(String s) {
        return s != null && new StringBuilder(s).reverse().toString().equals(s);
    }

    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @ValueSource(strings = { "12321", "pop" })
    void testPalindrome(String word) {
        assertTrue(isPalindrome(word));
    }
}

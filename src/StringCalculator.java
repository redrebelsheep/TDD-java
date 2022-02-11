import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private final static String CUSTOM_DELIMITER_HEADER = "//";

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        final boolean HAS_CUSTOM_DELIMITER = numbers.startsWith(CUSTOM_DELIMITER_HEADER);
        String delimiter = "[,\n]";

        if (HAS_CUSTOM_DELIMITER) {
            int lineBreakIndex = numbers.indexOf('\n', CUSTOM_DELIMITER_HEADER.length() + 1);
            delimiter = numbers.substring(CUSTOM_DELIMITER_HEADER.length(), lineBreakIndex);
            numbers = numbers.substring(lineBreakIndex + 1);
        }


        if (Arrays.stream(numbers.split(delimiter)).anyMatch(num -> num.startsWith("-"))) {
            List<String> invalidNumbers = Arrays.stream(numbers.split(delimiter))
                    .filter(num -> num.startsWith("-"))
                    .collect(Collectors.toList());
            String errorMessage = "negatives not allowed: " + String.join(", ", invalidNumbers);
            throw new RuntimeException(errorMessage);
        }

        List<Integer> intNumberList = Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .filter(n -> n <= 1000).collect(Collectors.toList());

        return intNumberList.stream()
                .reduce(0, Integer::sum);
    }
}
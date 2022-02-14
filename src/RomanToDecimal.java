import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.in;

public class RomanToDecimal {

    public int convert(String inputValue) {
        inputValue = inputValue.toLowerCase();
        return inputValue.isEmpty() ? 0 : inputValue.length() == 1 ? getNumbers(inputValue.charAt(0)) : complexConvert(inputValue);
    }

    public int getNumbers(char input) {
        switch (input) {
            case 'i':
                return 1;
            case 'v':
                return 5;
            case 'x':
                return 10;
            case 'l':
                return 50;
            case 'c':
                return 100;
            case 'd':
                return 500;
            case 'm':
                return 1000;
        }
        return 0;
    }

    public int complexConvert(String input) {
       List<Character> listTemp = input.toLowerCase().chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());
        int sum = 0;
        int i =0;
        boolean check = false;
        while(i< listTemp.size()-1){
            int value = getNumbers(listTemp.get(i));
            int nextValue = getNumbers(listTemp.get(i+1));
            check = value > nextValue || value == nextValue;
            sum += check ? (value) :  (nextValue-value);
            char index = listTemp.get(i);
            i += check ? 1: 2;
        }
        return listTemp.size() % 2 != 0 && check ? sum + getNumbers(listTemp.get(listTemp.size()-1)): sum;
    }
}



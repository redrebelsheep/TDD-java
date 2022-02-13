import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzzTest;

    @BeforeEach
    public void init(){
        fizzBuzzTest = new FizzBuzz();
    }

    @Test
    public void fizzBuzz_isFizzForDivisibleByThree(){

        //Given
        int input = 3;

        //When
        String output = fizzBuzzTest.fizzBuzz(input);

        //Then
        String expected = "Fizz";
        assertEquals(expected, output);


    }

    @Test
    public void fizzBuzz_isFizzForDivisibleByFive(){

        //Given
        int input = 5;

        //When
        String output = fizzBuzzTest.fizzBuzz(input);

        //Then
        String expected = "Buzz";
        assertEquals(expected, output);


    }

    @Test
    public void fizzBuzz_isFizzForDivisibleByFiveAndThree(){

        //Given
        int input = 15;

        //When
        String output = fizzBuzzTest.fizzBuzz(input);

        //Then
        String expected = "FizzBuzz";
        assertEquals(expected, output);


    }

    @Test
    public void foo(){

        //Given
        int input = 2;

        //When
        String output = fizzBuzzTest.fizzBuzz(input);

        //Then
        String expected = "2";
        assertEquals(expected, output);


    }


}
public class FizzBuzz {



    public String fizzBuzz(int input) {
        String output =  input % 3 == 0 ? "Fizz": "";
        output += input % 5 == 0 ? "Buzz" : "";
        return output.isEmpty() ? String.valueOf(input) : output;
    }

}


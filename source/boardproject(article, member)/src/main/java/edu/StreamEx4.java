package edu;

import java.util.Arrays;
import java.util.List;

public class StreamEx4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfSquares = numbers.stream()
                .filter(num -> num % 2 == 0) //2,4,6,8,10
                .map(num -> num * num) //4, 16, 36, 64, 100
                .reduce(0, (prev, next) -> prev + next); //0 + 4 + 16 + 36 + 64 + 100
        System.out.println("Sum of squares of even numbers: " + sumOfSquares); //220

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        String result = names.stream()
                .filter(name -> name.length() >= 4) //"Alice", "Charlie", "David"
                .map(name -> name.toUpperCase()) //"ALICE", "CHARLIE", "DAVID"
                .reduce("",(prev, next) -> prev.concat(next + " "));
                //"ALICE", "CHARLIE", "DAVID"

        System.out.println(result); //ALICE CHARLIE DAVID
    }
}

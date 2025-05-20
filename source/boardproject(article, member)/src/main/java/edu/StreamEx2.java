package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {
    public static void main (String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 7, 7, 8, 9, 10, 10);

        //ForEach
        List<Integer> uniqueNumber = new ArrayList<>(new HashSet<Integer>(integerList));
        List<Integer> filteredList = new ArrayList<>();
        for(Integer num: uniqueNumber) {
            if(num % 3 != 0) filteredList.add(num);
        }
        System.out.println(filteredList);

        //Stream
        System.out.println(
                integerList.stream().distinct()
                        .filter(num -> num % 3 != 0)
                        .collect(Collectors.toList())
        );
    }
}

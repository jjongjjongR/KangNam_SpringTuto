package edu;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamEx3 {
    public static void main (String[] args) {

        List<String> names =
                Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Alice", "Bob", "Tommy", "Trump");

        System.out.println("\n===========ForEach문===========");
        List<String> filteredNames = new ArrayList<>();
        for(String name: names) {
            if(name.length() >= 3) filteredNames.add(name);
        }

        List<String> upperCaseNames = new ArrayList<>();
        for(String name : filteredNames) upperCaseNames.add(name.toUpperCase());

        Collections.sort(upperCaseNames);

        for(String name: upperCaseNames) {
            System.out.print(name + " ");
        }

        System.out.println("\n===========Stream===========");
        names.stream()
                .filter(name -> name.length() >= 3) //"Jerry", "Spike", "Tyke", "Alice", "Tommy", "Trump"
                .map(name -> name.toUpperCase()) //"JERRY", "SPIKE", "TYKE", "ALICE", "TOMMY", "TRUMP"
                .sorted() //"ALICE", "JERRY", "SPIKE", "TOMMY", "TRUMP", "TYKE"
                .forEach(name -> System.out.print(name + " "));
    }
}

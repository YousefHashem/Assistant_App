package com.yousefh.assistantapp.list;

import com.yousefh.assistantapp.PersonsModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Statements {
    public static void main(String[] args) {
        // Create a list of integers called 'numbers'
        List<Integer> numbers = new ArrayList<>();

        // Sort the list of integers in ascending order
        Collections.sort(numbers);

        ////////////////////////////////////////////////////////////////////////////////////////////

        // Create a list of integers using Arrays.asList with initial values
        List<Integer> numbersList = Arrays.asList(5, 3, 2, 4, 1);

        // Stream the list of integers, sort them, and collect them back into a new list called 'sortedList'
        List<Integer> sortedList = numbersList.stream().sorted().collect(Collectors.toList());

        // Print the sorted list (output will be [1, 2, 3, 4, 5])
        System.out.println(sortedList);

        ////////////////////////////////////////////////////////////////////////////////////////////

        // Create a list of PersonsModel objects called 'sortPersonsByAge'
        List<PersonsModel> sortPersonsByAge = new ArrayList<>();

        // Sort the list of PersonsModel objects by their 'age' property in ascending order
        sortPersonsByAge.sort(Comparator.comparingInt(PersonsModel::getAge));

        // Create a new list 'sortedPersons' containing the sorted persons by age
        List<PersonsModel> sortedPersons = new ArrayList<>(sortPersonsByAge);

        ////////////////////////////////////////////////////////////////////////////////////////////

        // Add elements to a list
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println(fruits); // Output: [Apple, Banana, Cherry]

        // Access elements from a list
        String firstFruit = fruits.get(0);
        System.out.println(firstFruit); // Output: Apple

        // Remove elements from a list
        fruits.remove("Banana");
        System.out.println(fruits); // Output: [Apple, Cherry]

        // Iterate over elements in a list using a for-each loop
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Check if a list contains a specific element
        boolean hasApple = fruits.contains("Apple");
        System.out.println(hasApple); // Output: true

        // Convert a list to an array
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println(Arrays.toString(fruitsArray)); // Output: [Apple, Cherry] // Banana is removed

        // Find the size of a list
        int size = fruits.size();
        System.out.println(size); // Output: 2

        // Clear all elements from a list
        fruits.clear();
        System.out.println(fruits); // Output: []

        // Create a sublist from an existing list
        // Create a list of integers using Arrays.asList with initial values
        List<Integer> numbersSubList = Arrays.asList(5, 3, 2, 4, 1);

        // Print the original list
        System.out.println("Original list: " + numbersSubList); // Output: [5, 3, 2, 4, 1]

        // Create a sublist from the original list from index 1 (inclusive) to index 4 (exclusive)
        List<Integer> subList = numbersSubList.subList(1, 4);

        // Print the sublist
        System.out.println("Sublist: " + subList); // Output: [3, 2, 4]

        // Modify an element in the sublist
        subList.set(0, 99); // Set value in index 0 '5' = 99
    }
}

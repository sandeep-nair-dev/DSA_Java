package com.sandeep.streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 12, 8, 3, 12, 7, 20, 3);
        List<String> words = List.of("stream", "java", "lambda", "map", "filter", "java", "reduce");
        List<List<Integer>> nested = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(), List.of(6, 7, 8, 9));
        String text = "the quick brown fox jumps over the lazy dog";

        record Employee(String name, String dept, int salary) {
        }
        List<Employee> emps = List.of(
                new Employee("Alice", "ENG", 120000),
                new Employee("Bob", "ENG", 95000),
                new Employee("Carol", "HR", 70000),
                new Employee("Dave", "ENG", 110000),
                new Employee("Eve", "HR", 82000),
                new Employee("Frank", "OPS", 65000),
                new Employee("Grace", "OPS", 72000));


        System.out.println("-----------------------------");
        System.out.println("From nums, return the distinct even numbers sorted in descending order as a List<Integer>");
        List<Integer> ans1 = nums.stream().distinct().filter(t -> t % 2 == 0).sorted(Comparator.reverseOrder()).toList();
        System.out.println(ans1);

        System.out.println("-----------------------------");
        System.out.println("From words, return the distinct words, uppercased, sorted alphabetically");
        List<String> ans2 = words.stream().distinct().map(String::toUpperCase).sorted().toList();
        System.out.println(ans2);

        System.out.println("-----------------------------");
        System.out.println("From nums, find the first number greater than 10. Then do the same for greater than 50. What does each return?");
        Optional<Integer> ans3a = nums.stream().filter(t -> t > 10).findFirst();
        Optional<Integer> ans3b = nums.stream().filter(t -> t > 50).findFirst();
        System.out.println(ans3a);
        System.out.println(ans3b);

        System.out.println("-----------------------------");
        System.out.println("On nums, evaluate anyMatch(n -> n == 20), allMatch(n -> n % 2 == 0) and noneMatch(n -> n < 0). Then evaluate anyMatch, allMatch and noneMatch with any predicate on an empty list.");
        boolean ans4a = nums.stream().anyMatch(n -> n == 20);
        boolean ans4b = nums.stream().allMatch(n -> n % 2 == 0);
        boolean ans4c = nums.stream().noneMatch(n -> n < 0);

        List<Integer> nums2 = List.of();
        boolean ans4d = nums2.stream().anyMatch(n -> n == 20);
        boolean ans4e = nums2.stream().allMatch(n -> n % 2 == 0);
        boolean ans4f = nums2.stream().noneMatch(n -> n < 0);

        System.out.println(ans4a);
        System.out.println(ans4b);
        System.out.println(ans4c);
        System.out.println(ans4d);
        System.out.println(ans4e);
        System.out.println(ans4f);


        System.out.println("-----------------------------");
        System.out.println("From text, count (a) words longer than 3 characters and (b) distinct words.");
        long ans5a = Arrays.stream(text.split(" ")).filter(t -> t.length() > 3).count();
        long ans5b = Arrays.stream(text.split(" ")).distinct().count();
        System.out.println(ans5a);
        System.out.println(ans5b);


        System.out.println("-----------------------------");
        //Generating streams (range, iterate, skip, limit)
        System.out.println("Using IntStream, take 1 to 20 inclusive, keep multiples of 3, skip the first, and take the next 3.");
        IntStream ans6 = IntStream.rangeClosed(1, 20).filter(t -> t % 3 == 0).skip(1).limit(3);
        System.out.println(ans6);
        System.out.println("-----------------------------");
        System.out.println("Produce the first 8 powers of 2, starting at 1, using Stream.iterate.");
        List<Integer> ans7 = Stream.iterate(1, t -> t * 2).limit(8).toList();
        System.out.println(ans7);
        System.out.println("-----------------------------");
        System.out.println("Produce the first 8 Fibonacci numbers (starting 0, 1, ...) using Stream.iterate and no loops. Hint: iterate over pairs.");
        List<Integer> ans8 = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(8).map(t -> t[0]).toList();
        System.out.println(ans8);


        //Nested data (flatMap)
        System.out.println("-----------------------------");
        System.out.println("From nested, compute the sum of the squares of all odd numbers.");
        int ans9 = nested.stream().flatMap(Collection::stream).filter(t -> t % 2 != 0).mapToInt(t -> t * t).sum();
        System.out.println(ans9);

        System.out.println("-----------------------------");
        System.out.println("From [\"java\", \"stream\"], return the distinct characters, sorted, as a List<Character>.");
        String[] s = new String[]{"java", "stream"};
        List<Character> ans10 = Arrays.stream(s).flatMap(t -> t.chars().mapToObj(c -> (char) c)).distinct().sorted().toList();
        System.out.println(ans10);

        System.out.println("-----------------------------");
//        Employee problems
        System.out.println("-----------------------------");
        System.out.println("Names of the top 3 earners above 80,000, highest salary first.");
        System.out.println("-----------------------------");
        System.out.println("Names of all ENG employees in alphabetical order.");
        System.out.println("-----------------------------");
        System.out.println("The highest paid HR employee, as an Optional.");
        System.out.println("-----------------------------");
        System.out.println("Total salary of OPS, using a primitive stream.");
        System.out.println("-----------------------------");
        System.out.println("Distinct departments, sorted alphabetically.");
    }
}

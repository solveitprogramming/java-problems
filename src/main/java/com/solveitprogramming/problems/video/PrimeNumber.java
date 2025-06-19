package com.solveitprogramming.problems.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class PrimeNumber {

    public static void main(String[] args) {
        execution(PrimeNumber::isPrimeFastest);
        execution(PrimeNumber::isPrime);
    }

    public static void execution(Function<Integer, Boolean> primeFunction) {
        long startTime = System.currentTimeMillis();
        long counter = 0;
        for (int i = Integer.MAX_VALUE; i > Integer.MAX_VALUE  - 1_000_000; i -= 2) {
            if (primeFunction.apply(i)) {
                counter++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time " + (endTime - startTime) + " milliseconds, Found " + counter + " prime numbers");
    }



    public static boolean isPrimeFastest(int number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        if (number == 2 || number == 3 || number == 5) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
            return false;
        }

        for (int i = 6; i <= Math.sqrt(number); i += 6) {
            if (number % (i + 1) == 0 || number % (i + 5) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be greater than 2");
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void testEquals() {
        List<Integer> first = executionWithList(PrimeNumber::isPrime);
        List<Integer> second = executionWithList(PrimeNumber::isPrimeFastest);

        while (!first.isEmpty()) {
            Integer nn = first.getFirst();
            first.removeFirst();
            if (Objects.equals(nn, second.getFirst())) {
                second.removeFirst();
            } else {
                System.out.println(nn);
                System.out.println(second.getFirst());
                System.out.println("Not equal");
                break;
            }
        }
        if (second.isEmpty()) {
            System.out.println("Equal");
        }
    }

    public static List<Integer> executionWithList(Function<Integer, Boolean> primeFunction) {
        long startTime = System.currentTimeMillis();
        List<Integer> primes = new ArrayList<>();
        for (int i = Integer.MAX_VALUE; i > Integer.MAX_VALUE  - 1_000_000; i-=2) {
            if (primeFunction.apply(i)) {
                primes.add(i);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time" + (endTime - startTime) + " seconds");
        return primes;
    }

}

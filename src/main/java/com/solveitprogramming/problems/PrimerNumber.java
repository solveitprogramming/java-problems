package com.solveitprogramming.problems;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class PrimerNumber {

    public static void main(String[] args) {
        execution(PrimerNumber::isPrimeEvenFaster);
        execution(PrimerNumber::isPrimeFaster);
//        execution(PrimerNumber::isPrime);
    }

    public static Set<Integer> getPrimerNumbers() {
        Set<Integer> lst = new LinkedHashSet<>();
        for (int i = 1000001; i >= 2; i -= 2) {
            boolean primeNumber = isPrimeFaster(i);
            if (primeNumber) {
                lst.add(i);
            }
        }
        return lst;
    }

    public static void checkPrimeNumebrs(Set<Integer> primeNumbers) {
        for (int i = 1000001; i >= 2; i -= 2) {
            boolean primeNumber = isPrimeEvenFaster(i);
            if (primeNumber) {
                if (!primeNumbers.contains(i)) {
                    System.out.println(i);
                }
                primeNumbers.remove(i);
            }
        }
    }

    public static void execution(Function<Long, Boolean> isPrime) {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        long startLong = (Long.MAX_VALUE / 4);
        if (startLong % 2 == 0) {
            startLong = startTime - 1;
        }
        for (long i = startLong; i >= 2; i -= 2) {
            boolean primeNumber = isPrime.apply(i);
            if (primeNumber) {
                System.out.println(i);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Prime number count %d executed in %d ms%n", counter, endTime - startTime);
    }

    public static boolean isPrime(long number) {
        return isPrime(number, number);
    }

    public static boolean isPrimeFaster(long number) {
        return isPrime(number, number / 2);
    }

    public static boolean isPrimeEvenFaster(long number) {
        if (number < 20) {
            return isPrimeFaster(number);
        }
        return isPrime(number, (long) Math.sqrt(number) + 1);
    }


    public static boolean isPrime(long number, long untilNumber) {
        if (number < 2) {
            throw new RuntimeException("Primer number is bigger then 1.");
        }
        if (number == 2) {
            return true;
        }
        for (int i = 3; i < untilNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



}

package com.solveitprogramming.problems;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class PrimerNumber {

    public static void main(String[] args) {
//        execution(PrimerNumber::isPrimerFastest);
//        execution(PrimerNumber::isPrimeEvenFaster);
//        execution(PrimerNumber::isPrimeFaster);
        findBiggest(PrimerNumber::isPrimerFastest);
        findBiggest(PrimerNumber::isPrimeEvenFaster);
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

    public static void findBiggest(Function<Long, Boolean> isPrime) {
        long startTime = System.currentTimeMillis();
        long biggest = 0;
        long startLong = (Long.MAX_VALUE / 2);
        if (startLong % 2 == 0) {
            startLong = startLong - 1;
        }
        for (long i = startLong; i >= 2; i -= 2) {
            boolean primeNumber = isPrime.apply(i);
            if (primeNumber) {
                biggest = i;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Biggest %d executed in %d ms%n", biggest, endTime - startTime);
    }
    public static void execution(Function<Long, Boolean> isPrime) {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        long startLong = 2000001;
        for (long i = startLong; i >= 2; i -= 2) {
            boolean primeNumber = isPrime.apply(i);
            if (primeNumber) {
                counter++;
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

    public static boolean isPrimerFastest(long number) {
        if (number == 2 || number == 3) {
            return true;
        }

        // Check whether n is divisible by 2 or 3
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }


        for (long i = 5; i <= Math.sqrt(number); i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;

    }


    public static boolean isPrime(long number, long untilNumber) {
        if (number < 2) {
            throw new RuntimeException("Primer number is bigger then 1.");
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < untilNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



}

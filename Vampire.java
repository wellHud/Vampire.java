package org.example;
import java.util.HashSet;
import java.util.Set;



public class Vampire {
    /*
     * Exercise 10: (5) A vampire number has an even number of digits and is
     * formed by multiplying a pair of numbers containing half the number of
     * digits of the result. The digits are taken from the original number in
     * any order. Pairs of trailing zeroes are not allowed. Examples include:
     * 1260 = 21 * 60 1827 = 21 * 87 2187 = 27 * 81 Write a program that finds
     * all the 4-digit vampire numbers. (Suggested by Dan Forhan.)
     */

    public static void rearrange(String prefix, String strOfNumbers, String numberChecked, Set<String> setOfVampireNumbers) {
        if (prefix.length() > 3) {
            Integer a = Integer.valueOf(prefix.substring(0, prefix.length()/2));
            Integer b = Integer.valueOf(prefix.substring(prefix.length()/2));
            String resultOfPairs = "" + (a * b);
            if (resultOfPairs.equals(numberChecked)) {
                setOfVampireNumbers.add(numberChecked);
            }
        }
        for (char ch : strOfNumbers.toCharArray())
            rearrange(prefix + ch, strOfNumbers.replaceFirst(ch + "", ""), numberChecked, setOfVampireNumbers);
    }

    public static void main(String[] args) {
        Set<String> setOfVampireNumbers = new HashSet<>();
        for (int i = 1000; i < 9999; i++) {
            String s = "" + i;
            rearrange("", s, s, setOfVampireNumbers);
        }
        for (String z:setOfVampireNumbers) {
            System.out.println(z);
        }
    }
}
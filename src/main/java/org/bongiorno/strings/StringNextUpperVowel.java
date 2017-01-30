package org.bongiorno.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.toUpperCase;

public class StringNextUpperVowel {


    public static String nextUpperVowels(String str) {

        char[] result = new char[str.length()];
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for(int i = 0; i < str.length(); i++) {
            if(isAlphabetic(str.charAt(i)))
                result[i] = (char) ((str.charAt(i) + 1));
            else
                result[i] = str.charAt(i);

            if(vowels.contains(result[i]))
                result[i] = toUpperCase(result[i]);
        }

        return new String(result);
    }

    public static String nextUpperStreamVowel(String in) {
        return IntStream.range(0,in.length()).mapToObj(in::charAt).map(c -> isAlphabetic(c) ? c + 1: c)
                .map(l -> Stream.of('a','e','i','o','u').anyMatch(l::equals) ? toUpperCase(l) : l).map(String::valueOf).reduce(String::concat).orElse(null);
    }



    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(nextUpperStreamVowel(s.nextLine()));
//        System.out.print(reverseStreams(s.nextLine()));
    }
}

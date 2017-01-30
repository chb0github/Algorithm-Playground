package org.bongiorno.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by cbongiorno on 1/27/17.
 */
public class StringReverse {


    public static String reverseStreams(String in) {
        return IntStream.iterate(in.length() -1, i -> i -1 ).limit(in.length()).mapToObj(in::charAt).map(String::valueOf).reduce(String::concat).orElse(null);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(reverseStreams(s.nextLine()));
    }
}

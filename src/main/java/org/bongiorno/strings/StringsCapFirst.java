package org.bongiorno.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Character.isWhitespace;

/**
 * Created by cbongiorno on 1/27/17.
 */
public class StringsCapFirst {



    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(capFirstLetter(s.nextLine()));
    }
    public static String capFirstLetter(String in) {
        return IntStream.range(0,in.length()).mapToObj(in::charAt).map(String::valueOf).reduce((a, b) -> {
            if (isWhitespace(a.charAt(a.length() - 1)))
                return a + b.toUpperCase();

            if(a.length() == 1)
                return a.toUpperCase() + b;

            return a + b;
        }).orElse(null);
    }

    public static String capFirstLetter7(String str) {
        char[] result = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0)
                result[i] = Character.toUpperCase(c);
            else {
                if (Character.isWhitespace(str.charAt(i - 1)))
                    result[i] = Character.toUpperCase(c);
                else
                    result[i] = c;
            }
        }
        return new String(result);
    }
}

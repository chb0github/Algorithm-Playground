package org.bongiorno.coderbyte.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cbongiorno on 1/27/17.
 */
public class CharsInPosition {

    public static String SimpleSymbols(String str) {
        boolean found = true;
        List<Integer> chars = new LinkedList<>();
        for(int i = 1; i < str.length() && str.length() > 2; i++){
            char c = str.charAt(i);
            if(Character.isAlphabetic(c)) {
                chars.add(i);
            }
        }

        for(Integer i : chars) {
            found = found && str.charAt(i - 1) == '+' && (i + 1) < str.length() && str.charAt(i + 1) == '+';
        }

        return found +"";

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleSymbols(s.nextLine()));
    }

}

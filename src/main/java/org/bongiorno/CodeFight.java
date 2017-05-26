
package org.bongiorno;

import java.util.stream.IntStream;

/**
 * Created by cbongiorno on 4/3/17.
 */
public class CodeFight {

    int centuryFromYear(int year) {
        return (int) (Math.floor(year / 100) + (year % 100 != 0 ? 1 : 0));
    }

    static boolean checkPalindrome(String inputString) {


        return IntStream.rangeClosed(0, inputString.length() / 2).allMatch(i -> inputString.charAt(i) == inputString.charAt(inputString.length() - 1 - i));

    }



    static int adjacentElementsProduct(int[] arr) {

        return IntStream.range(1,arr.length -1).map(i -> Math.max(arr[i - 1] * arr[i], arr[i] * arr[i + 1])).reduce(Math::max).orElse(-1);
    }


}

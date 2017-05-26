package org.bongiorno.codility.ing.test2;


/**
 * Created by cbongiorno on 2/13/17.
 */
public class Solution {

    public int solution(int lowerBound, int upperBound) {
        int count = 0;
        // write your code in Java SE 8
        if(lowerBound == 0 && upperBound == 0)
            return 1;


        int startSq = (int) Math.floor(Math.sqrt(upperBound));
        while(startSq >= lowerBound && startSq <= upperBound) {
            count++;
            startSq = startSq -1;

        }
        return 0;
    }

    public static boolean checkPerfect(int n)
    {
        if (n < 0)
            return false;

        int x = (int)(Math.sqrt(n) + 0.5);
        return x*x == n;
    }
}

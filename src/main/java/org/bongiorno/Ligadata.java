package org.bongiorno;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by cbongiorno on 3/17/17.
 */
public class Ligadata {

    public static void main(String[] args) {

        int[] testData = randomNums(4);
        System.out.println(Arrays.toString(testData));

    }

    public static int[] shuffle(int[] input) {
        Random r = new Random();
        for(int i = input.length -1 ; i > 0; i--) {
            int swapIndex = r.nextInt(i);
            int temp = input[swapIndex];
            input[swapIndex] = input[i];
            input[i] = temp;
        }
        return input;
    }

    public static int[] randomNums(int count) {
        return shuffle(IntStream.range(0, count).sorted().toArray());
    }
}

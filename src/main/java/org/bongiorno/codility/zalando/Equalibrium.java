package org.bongiorno.codility.zalando;

import java.util.stream.IntStream;

public class Equalibrium {

    public static void main(String[] args) {
        int[] test = {-1, 3, -4, 5, 1, -6, 2, 1};
        System.out.println(Equalibrium.solution(test));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length == 0)
            return -1;


        int[] memory = new int[A.length];

        memory[0] = A[0];

        IntStream.range(1, A.length).forEachOrdered(i -> memory[i] = A[i] + memory[i - 1]);


        return IntStream.range(1, A.length).filter(i -> memory[A.length - 1] - memory[i] == memory[i - 1]).findAny().orElse(-1);
    }


}


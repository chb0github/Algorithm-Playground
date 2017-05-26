package org.bongiorno.codility.ing.test3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class SolutionTest {


    @Test
    public void testCase1() throws Exception {
        Solution solution = new Solution();
        Object actual = solution.solution(1, "", "");
        assertEquals("", actual);
    }

    @Test
    public void testCase2() throws Exception {
        Solution solution = new Solution();
        Object actual = solution.solution(1, "", "");
        assertEquals("", actual);

    }

    @Test
    public void testName() throws Exception {
        //get string as char array
        char[] chars = "12346789".toCharArray();
// build array list to store integer value of each char
        List<Integer> multipliedChars = new ArrayList<>();
//get char values on even positions of the array, multiply them by two and add them to array list
        for (int i = 1; i < chars.length; i += 2) {
            multipliedChars.add((chars[i] * 2) / 10);
        }

    }
}
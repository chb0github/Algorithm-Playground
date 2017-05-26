package org.bongiorno.codility.zalando.test5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 2/2/17.
 */
public class SolutionTest {

    @Test
    public void testCase1() throws Exception {

        int[] input = {1,2,6,5,5,8,9};
        int actual = new Solution().solution(input);
        assertEquals(3,actual);
    }

    @Test
    public void testCase2() throws Exception {

        int[] input = {1,2,3,4,5,6,7,8,9};
        int actual = new Solution().solution(input);
        assertEquals(0,actual);
    }

    @Test
    public void testCase3() throws Exception {

        int[] input = {9,8,7,6,5,4,3,2,1};

        int actual = new Solution().solution(input);
        assertEquals(9,actual);
    }
}
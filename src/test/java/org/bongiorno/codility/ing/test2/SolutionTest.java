package org.bongiorno.codility.ing.test2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    @Test
    public void testCase1() throws Exception {
        Solution solution = new Solution();
        int actual = solution.solution(4,17);
        assertEquals(3,actual);
    }

}
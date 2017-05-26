package org.bongiorno.codility.ing.test1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testCase1() throws Exception {
        Solution solution = new Solution();
        Integer actual = solution.solution(new int[]{5,4,0,3,1,6,2});
        assertEquals(new Integer(4),actual);
    }



}
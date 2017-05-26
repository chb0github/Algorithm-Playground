package org.bongiorno.codility.zalando.test3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 2/2/17.
 */
public class SolutionTest {

    @Test
    public void testCase1() throws Exception {
        int actual = new Solution().solution("10:00", "13:21");
        assertEquals(17,actual);

    }

    @Test
    public void testCase2() throws Exception {
        int actual = new Solution().solution("9:42", "11:42");
        assertEquals(9,actual);

    }
}
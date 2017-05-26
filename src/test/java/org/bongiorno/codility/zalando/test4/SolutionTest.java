package org.bongiorno.codility.zalando.test4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 2/2/17.
 */
public class SolutionTest {


    @Test
    public void testCase1() throws Exception {
        int actual = new Solution().solution("13 DUP 4 POP 5 DUP + DUP + -");
        assertEquals(7,actual);

    }

    @Test
    public void testCase2() throws Exception {
        int actual = new Solution().solution("5 6 + -");
        assertEquals(-1,actual);

    }
    @Test
    public void testCase3() throws Exception {
        int actual = new Solution().solution("3 DUP 5 - -");
        assertEquals(-1,actual);

    }
}
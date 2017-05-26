package org.bongiorno.codility.zalando.test5;



public class Solution {
    public int solution(int[] heights) {
        int count = 0;
        for (int i = 1; i < heights.length; i++) {
            if(heights[i -1] > heights[i]) {
                heights[i] = heights[i -1];
                count ++;
            }
        }
        return count == 0 ? 0 : count + 1;
    }
}

package org.bongiorno.orgcodility.zalando.test1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 1/29/17.
 */
public class ElevatorTest {

    @Test
    public void testCase1() throws Exception {
        int[] peopleWeights = {60,80,40};
        int[] peopleFloors = {2,3,5};
        int maxCapacity = 2;
        int numFloors = 5;
        int weightLimit = 200;

        Zalando1 zalando = new Zalando1();

        int actual = zalando.solution(peopleWeights,peopleFloors,numFloors,maxCapacity,weightLimit);

        assertEquals(5,actual);
    }

    @Test
    public void testCase2() throws Exception {
        int[] peopleWeights = {40,40,100,80,20};
        int[] peopleFloors = {3,3,2,2,3};
        int maxCapacity = 5;
        int numFloors = 3;
        int weightLimit = 200;
        Zalando1 zalando = new Zalando1();

        int actual = zalando.solution(peopleWeights,peopleFloors,numFloors,maxCapacity,weightLimit);

        assertEquals(6,actual);

    }
}
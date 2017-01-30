package org.bongiorno.orgcodility.zalando.test2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 1/29/17.
 */
public class BattleShipTest {

    @Test
    public void testCase1() throws Exception {

        int mapSize = 4;
        String shipPositions = "1B 2C,2D 4D";
        String hitPositions = "2B 2D 3D 4D 4A";

        BattleShip battleShip = new BattleShip();
        String actual = battleShip.solution(mapSize,shipPositions,hitPositions);

        assertEquals("1,1",actual);
    }

    @Test
    public void testCase2() throws Exception {

        int mapSize = 3;
        String shipPositions = "1A 1B,2C 2C";
        String hitPositions = "1B";

        BattleShip battleShip = new BattleShip();
        String actual = battleShip.solution(mapSize,shipPositions,hitPositions);

        assertEquals("0,1",actual);
    }
}
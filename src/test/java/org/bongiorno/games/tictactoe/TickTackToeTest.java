package org.bongiorno.games.tictactoe;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class TickTackToeTest {

    @Test
    public void testGame() throws Exception {
        Game game = new Game(3);
        game.addMark('X', 0, 0);//
        game.addMark('O', 0, 2);
        game.addMark('X', 2, 2);
        game.addMark('O', 1, 1);
        game.addMark('X', 2, 0);
        game.addMark('O', 1, 0);
        Character winner = game.score(); // null if no win
        assertNull(winner);

        game.addMark('X',2,1);

        winner = game.score(); // null if no win
        assertEquals(new Character('X'),winner);
    }

    @Test
    public void testSquareSort() throws Exception {
        List<Square> result = Arrays.asList(new Square('X', 0, 1), new Square('Y', 0, 1), new Square('X', 1, 1), new Square('Y', 1, 1), new Square('X', 2, 1), new Square('Y', 2, 1), new Square('X', 0, 2));
        result.sort(null);
        List<Square> expected = Arrays.asList(new Square('X', 0, 1), new Square('X', 0, 2), new Square('X', 1, 1), new Square('X', 2, 1),
                new Square('Y', 0, 1),new Square('Y', 1, 1),  new Square('Y', 2, 1));
        assertEquals(expected,result);


    }

    @Test
    public void testSimpleWinRow() throws Exception {

        Game game = new Game(3);
        game.addMark('X', 0, 0);
        game.addMark('X', 1, 0);
        game.addMark('X', 2, 0);
        Character winner = game.score(); // null if no win
        assertEquals(new Character('X'),winner);
    }

    @Test
    public void testSimpleWinColumn() throws Exception {

        Game game = new Game(3);
        game.addMark('X', 0, 0);
        game.addMark('X', 0, 1);
        game.addMark('X', 0, 2);
        Character winner = game.score(); // null if no win
        assertEquals(new Character('X'),winner);
    }

    @Test
    public void testSimpleWinDiagonal() throws Exception {

        Game game = new Game(3);
        game.addMark('X', 0, 0);
        game.addMark('X', 1, 1);
        game.addMark('X', 2, 2);
        Character winner = game.score(); // null if no win
        assertEquals(new Character('X'),winner);
    }
}
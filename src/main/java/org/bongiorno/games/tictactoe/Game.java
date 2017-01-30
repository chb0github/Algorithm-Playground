package org.bongiorno.games.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

public class Game {
    private Set<Square> marks = new HashSet<>();

    private Integer size = null;

    public Game(int size) {
        this.size = size;
    }

    public void addMark(Character mark, Integer x, Integer y) {
        if (x > size - 1 || y > size - 1 || y < 0 || x < 0)
            throw new IllegalArgumentException("Squares out of bounds");

        Square square = new Square(mark, x, y);
        if (marks.contains(square))
            throw new IllegalArgumentException("Square in use");

        marks.add(square);
    }

    public Character score() {
        Map<Character, List<Square>> groups = marks.stream().collect(groupingBy(Square::getMark));
        Character winner = null;

        for (Map.Entry<Character, List<Square>> e : groups.entrySet()) {
            List<Square> squares = e.getValue();
            squares.sort(null);
            boolean win = traverse(squares, Square::sameRow) || traverse(squares, Square::sameColumn);
            win = win || traverse(squares, Square::isDiagonalTo);
            if (win) {
                winner = e.getKey();
                break;
            }
        }
        return winner;
    }

    private boolean traverse(List<Square> squares, BiFunction<Square, Square, Boolean> p) {
        int start = 0;

        while (start + 1 < squares.size()) {
            Square current = squares.get(start);
            Square next = squares.get(start + 1);
            if(p.apply(current, next))
                break;
            start++;
        }
        // if there are enough squares left to make a win then walk
        return start <= squares.size() - size && walk(squares.subList(start,squares.size()),p);
    }

    private boolean walk(List<Square> squares, BiFunction<Square, Square, Boolean> p){
        boolean result = true;
        if(squares.size() > 1) {
            Square current = squares.get(0);
            Square next = squares.get(1);
            result = p.apply(current, next) && walk(squares.subList(1, squares.size()), p);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("([0-9]+)[ ]+([0-9]+)");

        Game game = new Game(args.length > 1 ? Integer.parseInt(args[0]) : 3);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Character[] marks = {'X', 'O'};
        int turn = 0;
        Character winner = null;
        do {
            Character mark = marks[turn % marks.length];
            System.out.print(mark + " -> ");
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                Integer x = new Integer(matcher.group(1));
                Integer y = new Integer(matcher.group(2));
                try {
                    game.addMark(mark, x, y);
                    turn++;
                    winner = game.score();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
            else {
                System.err.println("Invalid input. Enter a mark position of '1 0' for example");
            }
        }
        while (winner == null);

        System.out.println("Winner is " + winner);
    }
}


package org.bongiorno.Taser;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.*;
import static java.util.stream.IntStream.iterate;

/**
 * Created by cbongiorno on 3/29/17.
 */
public class Sudoku {

    public static void main(String[] args) {
        /*
        Given a completed sudoku board, determine whether the contained solution is
        correct.

                +-------+-------+-------+
                | x x x | x x x | x x x |
        | x x x | x x x | x x x |
        | x x x | x x x | x x x |
                +-------+-------+-------+
                | x x x | x x x | x x x |
        | x x x | x x x | x x x |
        | x x x | x x x | x x x |
                +-------+-------+-------+
                | x x x | x x x | x x x |
        | x x x | x x x | x x x |
        | x x x | x x x | x x x |
                +-------+-------+-------+

                        All columns must contain all numbers in range [1, 9]:

        +-------+-------+-------+
                | 1     |       |       |
        | 2     |       |       |
        | 3     |       |       |
        +-------+-------+-------+
                | 4     |       |       |
        | 5     |       |       |
        | 6     |       |       |
        +-------+-------+-------+
                | 7     |       |       |
        | 8     |       |       |
        | 9     |       |       |
        +-------+-------+-------+

                All rows must contain all numbers in range [1, 9]:

        +-------+-------+-------+
                | 1 2 3 | 4 5 6 | 7 8 9 |
        |       |       |       |
        |       |       |       |
        +-------+-------+-------+
                |       |       |       |
        |       |       |       |
        |       |       |       |
        +-------+-------+-------+
                |       |       |       |
        |       |       |       |
        |       |       |       |
        +-------+-------+-------+

                All boxes must contain all numbers in range [1, 9]:

        +-------+-------+-------+
                | 1 2 3 |       |       |
        | 4 5 6 |       |       |
        | 7 8 9 |       |       |
        +-------+-------+-------+
                |       |       |       |
        |       |       |       |
        |       |       |       |
        +-------+-------+-------+
                |       |       |       |
        |       |       |       |
        |       |       |       |
        +-------+-------+-------+

*/

        int[] box = new int[81];
        boolean correct = range(0, 9).flatMap(i -> of(iterate(i * 9, r -> r + 1).map(row -> box[row]).sum(),
                iterate(i, c -> c * 9).map(column -> box[column]).sum())).allMatch(v -> v == 45);

    }
    public boolean smallBoxValid(int[] box) {
        Boolean found[] = new Boolean[9];

        for (int aBox : box)
            found[aBox] = true;
        return  stream(found).reduce(Boolean::logicalAnd).orElse(Boolean.FALSE);
    }
    public boolean validateColumn(int[] bigBox, int columnId) {
        Boolean found[] = new Boolean[9];
        for(int i = 0; i < 9; i++) {
            found[bigBox[i * 9] + columnId] = true;
        }
        return stream(found).reduce(Boolean::logicalAnd).orElse(false);
    }

    public boolean validRow(int[] box,int rowId) {
        Boolean found[] = new Boolean[9];
        for(int i = 0; i < 9; i++) {
            found[box[(rowId * 9) + i]] = true;
        }
        return stream(found).reduce(Boolean::logicalAnd).orElse(false);

    }

    public boolean validateBigBox(int[] box) {
        return range(0,9).mapToObj(i -> validRow(box,i) && validateColumn(box,i)).allMatch(Boolean.TRUE::equals);
    }




}

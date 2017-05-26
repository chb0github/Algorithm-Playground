package org.bongiorno;

/**
 * Created by cbongiorno on 2/6/17.
 */
public class PascalsTriangle {

    public int get(int column, int row) {
        return column == 0 || column == row ? 1 : get(column,row - 1) + get(column -1, row -1);
    }
}

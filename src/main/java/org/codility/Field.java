package org.codility;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<List<Cell>> cells;

    private Field(int N, int M, boolean[][] blockedCells) {
        this.cells = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                row.add(new Cell(j, i, blockedCells[i][j]));
            }
            this.cells.add(row);
        }
    }

    public static Field constructField(String[] r) {

        int N = r.length;
        int M = r[0].length();
        boolean[][] blockedCells = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                blockedCells[i][j] = r[i].charAt(j) == 'X';
            }
        }
        return new Field(N, M, blockedCells);
    }

    public Cell getNextCell(Cell currentCell, Direction direction) {
        int nextX = currentCell.x;
        int nextY = currentCell.y;

        switch (direction) {
            case UP:
                nextY--;
                break;
            case RIGHT:
                nextX++;
                break;
            case DOWN:
                nextY++;
                break;
            case LEFT:
                nextX--;
                break;
        }

        if (nextX < 0 || nextX >= cells.get(0).size() || nextY < 0 || nextY >= cells.size()) {
            return null;
        }

        Cell nextCell = cells.get(nextY).get(nextX);
        if (nextCell.isBlocked) {
            return null;
        }

        return nextCell;
    }

    public Cell getStartCell() {
        return cells.get(0).get(0);
    }
}

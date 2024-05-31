package org.codility;

import java.util.HashSet;
import java.util.Objects;

public class Robot {
    private final Field field;
    private Cell currentCell;
    private Direction direction;
    private HashSet<VisitedCell> visitedCells;


    public Robot(Cell startCell, Field field) {
        this.currentCell = startCell;
        this.direction = Direction.RIGHT;
        this.field = field;
        this.visitedCells = new HashSet<>();
    }

    public int clean() {
        int cleanedCells = 0;
        while (true) {
            if (!currentCell.isClean) {
                currentCell.clean();
                visitedCells.add(new VisitedCell(currentCell, direction));
                cleanedCells++;
            }
            move();
            if (currentCell.isClean && visitedCells.contains(new VisitedCell(currentCell, direction))) {
                System.out.println("Cleaning finished");
                System.out.println();
                break;
            }
        }
        return cleanedCells;
    }

    public void move() {
        System.out.println("Moving from [" + currentCell.x + ", " + currentCell.y + "] to " + direction);
        Cell nextPossibleCell = field.getNextCell(currentCell, direction);
        if (nextPossibleCell != null) {
            currentCell = nextPossibleCell;
            System.out.println("Moved to [" + currentCell.x + ", " + currentCell.y + "]");
        } else {
            rotate();
        }
    }

    public void rotate() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                System.out.println("Rotating right");
                break;
            case RIGHT:
                direction = Direction.DOWN;
                System.out.println("Rotating down");
                break;
            case DOWN:
                direction = Direction.LEFT;
                System.out.println("Rotating left");
                break;
            case LEFT:
                direction = Direction.UP;
                System.out.println("Rotating up");
                break;
        }
    }

    private class VisitedCell {
        Cell cell;
        Direction direction;

        public VisitedCell(Cell cell, Direction direction) {
            this.cell = cell;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitedCell that = (VisitedCell) o;
            return Objects.equals(cell, that.cell) && direction == that.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cell, direction);
        }
    }
}

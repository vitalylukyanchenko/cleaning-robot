package org.codility;

public class Cell {
    int x;
    int y;
    boolean isClean;
    boolean isBlocked;

    public Cell(int x, int y, boolean isBlocked) {
        this.x = x;
        this.y = y;
        this.isClean = false;
        this.isBlocked = isBlocked;
    }

    public void clean() {
        System.out.println("Cleaning cell [" + x + ", " + y + "]");
        this.isClean = true;
    }
}

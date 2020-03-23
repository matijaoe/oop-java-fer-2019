
package count_log;

import gameOfLife_load_save.BoardListener;

import java.awt.*;
import java.util.LinkedList;

public class Board {

    private int[][] counterAlive;
    private int[][] counterDead;
    private int width;
    private int height;
    private boolean[][] cells;
    private List<BoardListener> listeners = new LinkedList<>();
    private List<Point> dTa = new LinkedList<>();
    private List<Point> aTd = new LinkedList<>();

    public Board(int width, int height) {
        if(width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero!");
        }
        if(height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero!");
        }

        this.width = width;
        this.height = height;
        cells = new boolean[width][height];
        counterAlive = new int[width][height];
        counterDead = new int[width][height];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                cells[i][j] = false;
                counterAlive[i][j] = 0;
                counterDead[i][j] = 0;
            }
        }

    }

    public boolean isCellAlive(int x, int y) {

        if(!checkIndex(x, y)) {
            throw new IndexOutOfBoundsException();
        }
        return cells[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void countAlive(int x, int y) {
        counterAlive[x][y]++;
    }

    public int[][] getCounterAlive() {
        return counterAlive;
    }

    public int getCounterAlive(int x, int y) {
        return counterAlive[x][y];
    }

    public void countDead(int x, int y) {
        counterDead[x][y]++;
    }

    public int[][] getCounterDead() {
        return counterDead;
    }

    public int getCounterDead(int x, int y) {
        return counterDead[x][y];
    }

    public void setCell(int x, int y, boolean alive) {

        if(!checkIndex(x, y)) {
            throw new IndexOutOfBoundsException();
        }
        cells[x][y] = alive;
    }

    public int countAliveNeighbors(int x, int y) {

        if(!checkIndex(x, y)) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;

        for(int i = Math.max(0, x-1); i <= Math.min(x+1, width-1); i++) {
            for(int j = Math.max(0, y-1); j <= Math.min(y+1, height-1); j++) {
                if(x != i || y != j) {
                    if(cells[i][j] == true) { counter++; }
                }
            }
        }
        return counter;
    }

    public boolean isGonnaDie(int x, int y) {

        int alive = countAliveNeighbors(x, y);
        if(cells[x][y] == true) {
            if(alive < 2 || alive > 3) {
                return true;
            }
        }

        return false;
    }

    public boolean isGonnaLive(int x, int y) {

        int alive = countAliveNeighbors(x, y);
        if(cells[x][y] == false) {
            if(alive == 3) {
                return true;
            }
        }
        return false;
    }

    private List<Point> changesToDead(boolean[][] temp) {



        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(temp[i][j] == false) {
                    if(cells[i][j] == true) {
                        aTd.add(new Point(i, j));
                    }
                }
            }
        }
        return aTd;
    }
    private List<Point> changesToAlive(boolean[][] temp) {


        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(temp[i][j] == true) {
                    if(cells[i][j] == false) {
                        dTa.add(new Point(i, j));
                    }
                }
            }
        }
        return dTa;
    }

    public List<Point> deadToAlive() {
        return dTa;
    }

    public List<Point> aliveToDead() {
        return aTd;
    }


    public void playOneIteration() {

        boolean temp[][] = new boolean[width][height];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                temp[i][j] = cells[i][j];
            }
        }

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int alive = countAliveNeighbors(i, j);
                if(cells[i][j]) {
                    if(alive < 2 || alive > 3) {
                        temp[i][j] = false;
                        counterDead[i][j]++;
//                        cells[i][j] = false;
                    }
                } else {
                    if(alive == 3) {
                        counterAlive[i][j]++;
//                        cells[i][j] = true;
                        temp[i][j] = true;
                    }
                }
            }
        }

        changesToAlive(temp);
        changesToDead(temp);

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                cells[i][j] = temp[i][j];
            }
        }
        listeners.forEach(listener -> listener.boardChanged(this));


    }

    public void addListener(BoardListener listener) {
        listeners.add(listener);
    }

    public void removeListener(BoardListener listener) {

        listeners.remove(listener);
    }

    private boolean checkIndex(int x, int y) {

        if(x < 0 || x >= width) { return false; }
        if(y < 0 || y >= height) { return false; }

        return true;
    }


}

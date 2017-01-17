package com.yang.snake.entities;

import com.yang.snake.util.Global;

import java.awt.*;
import java.util.Random;

/**
 * Created by Yang on 1/16/2017.
 */
public class Ground {
    private int[][] rocks = new int[Global.WIDTH][Global.HEIGHT];

    public Ground() {
        for (int x = 0; x < Global.WIDTH; x++) {
            rocks[x][0] = 1;
            rocks[x][Global.HEIGHT - 1] = 1;
        }
        for (int y = 0; y < Global.HEIGHT; y++) {
            rocks[0][y] = 1;
            rocks[Global.WIDTH - 1][y] = 1;
        }
    }

    // check whether snake eat the rock
    public boolean isSnakeEatRock(Snake snake) {
        System.out.println("Ground's isSnakeEatRock.");

        for (int x = 0; x < Global.WIDTH; x++) {
            for (int y = 0; y < Global.HEIGHT; y++) {
                if (rocks[x][y] == 1 && x == snake.getHead().x && y == snake.getHead().y) {
                    return true;
                }
            }
        }

        return false;
    }

    // display ground panel
    public void drawMe(Graphics g) {
        System.out.println("Ground's drawMe.");

        g.setColor(Color.DARK_GRAY);

        for (int x = 0; x < Global.WIDTH; x++) {
            for (int y = 0; y < Global.HEIGHT; y++) {
                if (rocks[x][y] == 1) {
                    g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
                            Global.CELL_SIZE, Global.CELL_SIZE, true);
                }
            }
        }
    }

    public Point getPoint() {
        Random rand = new Random();
        int x = 0, y = 0;
        do {
            x = rand.nextInt(Global.WIDTH - 2) + 1;
            y = rand.nextInt(Global.HEIGHT - 2) + 1;
        } while (rocks[x][y] == 1);
        return new Point(x, y);
    }
}

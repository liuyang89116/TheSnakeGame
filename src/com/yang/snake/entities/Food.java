package com.yang.snake.entities;

import com.yang.snake.util.Global;

import java.awt.*;

/**
 * Created by Yang on 1/16/2017.
 */
public class Food extends Point {
    public void newFood(Point p) {
        this.setLocation(p);
    }

    // check whether snake eat the food
    public boolean isSnakeEatFood(Snake snake) {
        System.out.println("Food's isSnakeEatFood");

        return this.equals(snake.getHead());
    }

    // display food
    public void drawMe(Graphics g) {
        System.out.println("Food's drawMe");

        g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
                Global.CELL_SIZE, Global.CELL_SIZE, true);

    }

}

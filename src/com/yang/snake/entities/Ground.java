package com.yang.snake.entities;

/**
 * Created by Yang on 1/16/2017.
 */
public class Ground {
    // check whether snake eat the rock
    public boolean isSnakeEatRock(Snake snake) {
        System.out.println("Ground's isSnakeEatRock.");
        return false;
    }

    // display ground panel
    public void drawMe() {
        System.out.println("Ground's drawMe.");
    }
}

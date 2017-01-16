package com.yang.snake.entities;

/**
 * Created by Yang on 1/16/2017.
 */
public class Snake {
    public void move() {
        System.out.println("Snake's move.");
    }

    public void changeDirection() {
        System.out.println("Snake's changeDirection.");
    }

    public void eatFood() {
        System.out.println("Snake's eatFood.");
    }

    public boolean isEatBody() {
        System.out.println("Snake's isEatBody.");
        return false;
    }

    public void drawMe() {
        System.out.println("Snake's drawMe.");
    }

    private class SnakeDriver implements Runnable {

        @Override
        public void run() {
            while (true) {
                move();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

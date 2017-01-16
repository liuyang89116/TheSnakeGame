package com.yang.snake.entities;

import com.yang.snake.listener.SnakeListener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yang on 1/16/2017.
 */
public class Snake {
    private Set<SnakeListener> listenerSet = new HashSet<SnakeListener>();

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

                for (SnakeListener l : listenerSet) {
                    l.snakeMoved(Snake.this);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        new Thread(new SnakeDriver()).start();
    }

    public void addSnakeListener(SnakeListener l) {
        if (l != null) {
            this.listenerSet.add(l);
        }
    }


}

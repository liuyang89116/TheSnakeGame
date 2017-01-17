package com.yang.snake.entities;

import com.yang.snake.listener.SnakeListener;
import com.yang.snake.util.Global;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Yang on 1/16/2017.
 */
public class Snake {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int direction;

    private LinkedList<Point> body = new LinkedList<>();

    private Set<SnakeListener> listenerSet = new HashSet<SnakeListener>();

    public Snake() {
        init();
    }

    public void init() {
        int x = Global.WIDTH / 2;
        int y = Global.HEIGHT / 2;
        for (int i = 0; i < 3; i++) {
            body.addFirst(new Point(x--, y));
        }
        direction = RIGHT;
    }



    public void move() {
        System.out.println("Snake's move.");

        // 1. cut tail
        body.removeLast();

        int x = body.getFirst().x;  // original head of (x, y)
        int y = body.getFirst().y;
        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        Point newHead = new Point(x, y);

        // 2. add head
        body.addFirst(newHead);
    }

    public void changeDirection(int direction) {
        System.out.println("Snake's changeDirection.");
        this.direction = direction;

    }

    public void eatFood() {
        System.out.println("Snake's eatFood.");
    }

    public boolean isEatBody() {
        System.out.println("Snake's isEatBody.");
        return false;
    }

    public void drawMe(Graphics g) {
        System.out.println("Snake's drawMe.");

        for (Point p : body) {
            g.fill3DRect(p.x * Global.CELL_SIZE, p.y * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
        }

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

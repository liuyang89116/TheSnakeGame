package com.yang.snake.controller;

import com.yang.snake.entities.Food;
import com.yang.snake.entities.Ground;
import com.yang.snake.entities.Snake;
import com.yang.snake.listener.SnakeListener;
import com.yang.snake.view.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Yang on 1/16/2017.
 */
public class Controller extends KeyAdapter implements SnakeListener {
    private Snake snake;
    private Food food;
    private Ground ground;
    private GamePanel gamePanel;

    public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.changeDirection();
                break;
            case KeyEvent.VK_DOWN:
                snake.changeDirection();
                break;
            case KeyEvent.VK_LEFT:
                snake.changeDirection();
                break;
            case KeyEvent.VK_RIGHT:
                snake.changeDirection();
                break;
        }
    }

    @Override
    public void snakeMoved(Snake snake) {
        gamePanel.display(snake, food, ground);
    }

    public void newGame() {
        snake.start();
    }
}

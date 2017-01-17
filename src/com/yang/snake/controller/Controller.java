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
    // for internal use of external class
    private Snake snake;
    private Food food;
    private Ground ground;
    private GamePanel gamePanel;

    // constructor
    public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        this.gamePanel = gamePanel;
    }

    // control snake's move by pressing keys
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:  // up arrow
                snake.changeDirection(Snake.UP);
                break;
            case KeyEvent.VK_DOWN: // down arrow
                snake.changeDirection(Snake.DOWN);
                break;
            case KeyEvent.VK_LEFT:  // left arrow
                snake.changeDirection(Snake.LEFT);
                break;
            case KeyEvent.VK_RIGHT: // right arrow
                snake.changeDirection(Snake.RIGHT);
                break;
        }
    }

    // display all elements when snake moves
    @Override
    public void snakeMoved(Snake snake) {
        gamePanel.display(snake, food, ground);

        if (food.isSnakeEatFood(snake)) {
            snake.eatFood();
            food.newFood(ground.getPoint());
        }

        if (ground.isSnakeEatRock(snake)) {
            snake.die();
        }
        if (snake.isEatBody()) {
            snake.die();
        }

    }


    // start the game
    public void newGame() {
        snake.start();
        food.newFood(ground.getPoint());
    }
}

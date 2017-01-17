package com.yang.snake.game;

import com.yang.snake.controller.Controller;
import com.yang.snake.entities.Food;
import com.yang.snake.entities.Ground;
import com.yang.snake.entities.Snake;
import com.yang.snake.util.Global;
import com.yang.snake.view.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yang on 1/16/2017.
 */
public class Game {
    public static void main(String[] args) {
        Snake snake = new Snake();
        Food food = new Food();
        Ground ground = new Ground();
        GamePanel gamePanel = new GamePanel();
        Controller controller = new Controller(snake, food, ground, gamePanel);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.setSize(Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);
        frame.setSize(Global.WIDTH * Global.CELL_SIZE + 10,
                Global.HEIGHT * Global.CELL_SIZE + 35);
        frame.add(gamePanel, BorderLayout.CENTER);

        gamePanel.addKeyListener(controller);
        snake.addSnakeListener(controller);
        frame.addKeyListener(controller);

        frame.setVisible(true);
        controller.newGame();
    }
}

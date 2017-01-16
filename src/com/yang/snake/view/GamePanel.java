package com.yang.snake.view;

import javax.swing.*;
import java.awt.*;

import com.yang.snake.entities.Food;
import com.yang.snake.entities.Snake;
import com.yang.snake.entities.Ground;

/**
 * Created by Yang on 1/16/2017.
 */
public class GamePanel extends JPanel {
    private Snake snake;
    private Food food;
    private Ground ground;

    public void display(Snake snake, Food food, Ground ground) {
        System.out.println("GamePanel's display.");
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // display again
        this.ground.drawMe();
        this.snake.drawMe();
        this.food.drawMe();
    }
}

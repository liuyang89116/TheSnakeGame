package com.yang.snake.view;

import javax.swing.*;
import java.awt.*;

import com.yang.snake.entities.Food;
import com.yang.snake.entities.Snake;
import com.yang.snake.entities.Ground;
import com.yang.snake.util.Global;

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
        // display again
        g.setColor(new Color(0xcfcfcf));
        g.fillRect(0, 0,
                Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);
        if (ground != null && snake != null && food != null) {
            this.ground.drawMe(g);
            this.snake.drawMe(g);
            this.food.drawMe(g);
        }
    }
}

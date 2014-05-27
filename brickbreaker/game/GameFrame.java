/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import brickbreaker.game.items.Ball;
import brickbreaker.game.items.Paddle;

import static brickbreaker.BrickBreaker.*;
import static brickbreaker.game.GameLevel.brickList;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cole
 */
public class GameFrame extends JFrame {
    
    /**
     * The ball that is used in the game
     */
    public static Ball ball = new Ball(320, 240, 20, 1);
    
    /**
     * The paddle that is used in the game
     */
    public static Paddle paddle = new Paddle(100, 10);
    
    /**
     * The amount of lives the player has
     */
    public static int lives = 3;
    
    /**
     * The minimum an X value can be
     */
    public static final int xMin = 0;
    
    /**
     * The maximum an X value can be
     */
    public static final int xMax = 880;
    
    /**
     * The minimum a Y value can be
     */
    public static final int yMin = 40;
    
    /**
     * The maximum a Y value can be
     */
    public static final int yMax = 660;
    
    
    public GameFrame(String name) {
    
        setTitle(name);
        setSize(xMax, yMax);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    
    public void run() {
        
        // Set up Game panel
        final GamePanel game = new GamePanel();
        gameFrame.add(game);
        
        // Set paddle location
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        // Animation Thread
        Thread paintThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    // Move the ball
                    ball.setX(ball.getX() + ball.getXSpeed());
                    ball.setY(ball.getY() + ball.getYSpeed());
                    
                    Sleep(5);
                    
                    checkLines(ball, game);
                    checkPaddle(ball);
                    
                    // Redraw the screen
                    game.repaint();
                    
                }
                
            }
            
        });
        
        // Powerup Thread
        Thread powerupThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    // TODO: Powerup code here
                    // This thread will count down the duration of the powerup in seconds, seperate from the drawing thread
                    Sleep(100);
                    
                }
                
            }
            
        });
        
        paintThread.start();
        
    }
    
    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked
     * @param game 
     */
    public static void checkLines(Ball ball, GamePanel game) {
        
        // Left and Right
        if (ball.getLeft() <= game.getXmin())
        {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        } else if (ball.getRight() >= game.getXmax() + 15) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        
        // Top and Bottom
        if (ball.getTop() <= game.getYmin())
        {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        } else if (ball.getTop() >= game.getYmax()) {
            
            //ball.setYSpeed(-(ball.getYSpeed()));
            
            lives -= 1;
            
            if (lives == 0)
            {
                
                JOptionPane.showMessageDialog(game, "Game over!", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
            
                // Ends the program
                System.exit(0);
                
            } else {
                
                JOptionPane.showMessageDialog(game, "Try Again", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
                
                resetBall(ball);
                
            }
            
        }
        
    }
    
    /**
     * Check if the ball has hit the paddle
     * @param ball 
     */
    public static void checkPaddle(Ball ball) {
        
        // Check if the ball has hit the paddle
        if (ball.getBottom() == 618)
        {
            
            if (ball.getRight() >= paddle.getLeft() && ball.getLeft() <= paddle.getRight())
            {
                
                // Now, we check where the ball hit the paddle
                // Left Side then Right Side
                // TODO: Change how much the speed changes based on where the ball hits
                if (ball.getX() < paddle.getX())
                {
                    
                    if (ball.getXSpeed() == 1)
                    {
                        
                        ball.setXSpeed(-ball.getXSpeed());
                        
                    }
                    
                } else if (ball.getX() > paddle.getX()) {
                    
                    if (ball.getXSpeed() == -1)
                    {
                        
                        ball.setXSpeed(-ball.getXSpeed());
                        
                    }
                    
                }
                
                ball.setYSpeed(-(ball.getYSpeed()));
                
            }
            
        }
        
    }
    
    /**
     * Resets the ball back to it's origin
     * @param ball 
     */
    public static void resetBall(Ball ball) {
        
        ball.setX(580 / 2);
        ball.setY(660 / 2);
        
        ball.setXSpeed(ball.speed);
        ball.setYSpeed(ball.speed);
        
    }
    
}

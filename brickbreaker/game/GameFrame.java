/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import brickbreaker.game.items.*;

import static brickbreaker.BrickBreaker.*;

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
    public static Ball[] ballArray = new Ball[1];
    public static Ball ball = new Ball(320, 240, 20, 0);
    
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
        
        // Create the first ball
        ballArray[0] = new Ball(0, 0, 20, 0);
        
        // Set paddle location
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        GameLevel.changeLevel(1);
        
        // Animation Thread
        Thread paintThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    // Run through the amount of balls spawned
                    //for (Ball ball : ballArray)
                    //{
                    
                        // Move the ball
                        ball.setX(ball.getX() + ball.getXSpeed());
                        ball.setY(ball.getY() + ball.getYSpeed());
                        
                        checkLines(ball, game);
                        checkPaddle(ball);
                        
                        // Check for Brick Collisions
                        for (Brick curBrick : GameLevel.brickList)
                        {
                            
                            curBrick.checkCollision(ball);
                            
                        }
                        
                    //}
                    
                    Sleep(5);
                    
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
        if (ball.getLeft() <= xMin)
        {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        } else if (ball.getRight() >= xMax + 15) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        
        // Top and Bottom
        if (ball.getTop() <= yMin)
        {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        } else if (ball.getTop() >= yMax) {
            
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
        
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        ball.setX(paddle.getX());
        ball.setY(yMax - 65);
        
        ball.setXSpeed(0);
        ball.setYSpeed(0);
        
        ball.setLaunched(false);
        
    }
    
}

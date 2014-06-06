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
    public static Paddle paddle = new Paddle(125, 10);
    
    /**
     * The amount of lives the player has
     */
    public static int lives = 3;
    
    public static int level = 1;
    
    /**
     * The minimum an X value can be
     */
    public static final int xMin = 0;
    
    /**
     * The maximum an X value can be
     */
    public static final int xMax = 894;
    
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
        this.add(game);
        
        // Create the first ball
        ballArray[0] = new Ball(0, 0, 20, 0);
        
        // Set paddle location
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        GameLevel.changeLevel(level);
        
        // Game Thread
        Thread gameThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                while(true)
                {
                    
                    // Run through the amount of balls spawned
                    //for (Ball ball : ballArray)
                    //{
                    
                        // Move the ball
                        ball.setX(ball.getX() + ball.getXSpeed());
                        ball.setY(ball.getY() + ball.getYSpeed());
                        
                        checkLines(ball);
                        checkPaddle(ball);
                        checkBricks(ball);
                        
                        // Check for Brick Collisions
                        
                        
                    //}
                    
                    Sleep(2);
                    
                }
                
            }
            
        });
        
        // Animation Thread
        Thread drawThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    Sleep(2);
                    
                    // Redraw the screen
                    game.repaint();
                    
                }
                
            }
            
        });
        
        // Powerup Thread
        Thread powerupThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                int i = 0;
                
                while (true)
                {
                    
                    // TODO: Powerup code here
                    // This thread will count down the duration of the powerup in seconds, seperate from the drawing thread
                    Sleep(1000);
                    i++;
                    System.out.println(i + " seconds");
                    
                }
                
            }
            
        });
        
        gameThread.start();
        drawThread.start();
        powerupThread.start();
        
    }
    
    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked 
     */
    public void checkLines(Ball ball) {
        
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
                
                JOptionPane.showMessageDialog(this, "Game over!", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
            
                // Ends the program
                System.exit(0);
                
            } else {
                
                JOptionPane.showMessageDialog(this, "Try Again", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
                
                resetBall(ball);
                
            }
            
        }
        
    }
    
    /**
     * Check if the ball has hit the paddle
     * @param ball 
     */
    public void checkPaddle(Ball ball) {
        
        // Check if the ball has hit the paddle
        if (ball.getBottom() == 618)
        {
            
            if (ball.getRight() >= paddle.getLeft() && ball.getLeft() <= paddle.getRight())
            {
                
                // Now, we check where the ball hit the paddle
                // Left Side then Right Side
                // TODO: Change how much the speed changes based on where the ball hits
                if (ball.getX() < paddle.getX() + 8 - 7)
                {
                    
                    // Far Left Side
                    if (ball.getX() < paddle.getX() + 8 - 35)
                    {
                        
                        ball.setXSpeed(-2);
                        
                    } else {
                        
                        ball.setXSpeed(-1);
                        
                    }
                    
                } else if (ball.getX() > paddle.getX() + 8 + 7) {
                    
                    // Far Right Side
                    if (ball.getX() > paddle.getX() + 8 + 35)
                    {
                        
                        ball.setXSpeed(2);
                        
                    } else {
                        
                        ball.setXSpeed(1);
                        
                    }
                    
                } else {    // Middle of the Paddle
                    
                    ball.setXSpeed(0);
                    
                }
                
                ball.setYSpeed(-(ball.getYSpeed()));
                
            }
            
        }
        
    }
    
    public void checkBricks(Ball ball) {
        
        int count = 0;
        
        // Check for brick collisions
        for (Brick curBrick : GameLevel.brickList)
        {
            if (curBrick.Collide(ball))
            {
                
                spawnPowerup(curBrick);
                
            }
            
            if (curBrick.isDestroyed())
            {
                count++;
            }
        }
        
        if (count == GameLevel.brickList.length)
        {
            JOptionPane.showMessageDialog(this, "Level Complete!");
            level++;
            resetBall(ball);
            
            try {
                
                GameLevel.changeLevel(level);
                
            } catch (NullPointerException e) {
                
                JOptionPane.showMessageDialog(this, "Game Over!");
                System.exit(0);
                
            }
            
        }
    }
    
    public void spawnPowerup(Brick brick) {
        
        double rand =  1 + (Math.random() * ((10 - 1) + 1));
                
        // 10% Chance of Spawning
        if (rand == 0.5)
        {
            
            // Spawn a Powerup
            rand =  1 + (int)(Math.random() * ((100 - 1) + 1));
            
            if (rand >= 1 && rand <= 20)
            {
                
                // MultiBall
                
            } else if (rand >= 21 && rand <= 40) {
                
                // Sticky Ball
                
            } else if (rand >= 41 && rand <= 60) {
                
                // Double Points
                
            } else if (rand >= 61 && rand <= 80) {
                
                // Faster Ball
                
            } else if (rand >= 81 && rand <= 100) {
                
                // Bigger Paddle?
                
            }
            
        }
        
    }
    
    /**
     * Resets the ball back to it's origin
     * @param ball 
     */
    public void resetBall(Ball ball) {
        
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        ball.setX(paddle.getX() + 10);
        ball.setY(yMax - 65);
        
        ball.setXSpeed(0);
        ball.setYSpeed(0);
        
        ball.setLaunched(false);
        
    }
    
}

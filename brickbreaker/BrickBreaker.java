/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import brickbreaker.menu.*;
import brickbreaker.game.*;
import brickbreaker.game.items.*;

import javax.swing.*;

/**
 *
 * @author Cole
 */
public class BrickBreaker {
    
    /** The Frame for the game */
    public static GameFrame gameFrame;
    
    /** The Panel for the game */
    public static final GamePanel game = new GamePanel();
    
    /** The players name */
    public static String player = null;
    
    /** The ball that is used in the game */
    public static Ball[] ballArray = new Ball[1];
    public static Ball ball = new Ball(320, 240, 20, 0);
            
    /** The paddle that is used in the game*/
    public static Paddle paddle = new Paddle(125, 10);
    
    /** Sets the speed of the game */
    public static int difficulty = 2;
    
    /** The amount of lives the player has */
    public static int lives = 3;
    
    /** Current level of the game */
    public static int level = 1;
    
    /** Current Score */
    public static int score = 0;
    
    /** Total Score */
    public static int totalScore = 0;
    
    /** Time that the level is played */
    public static int time = 0;
    
    /** @param args the command line arguments */
    public static void main(String[] args) {
        
        // Start Menu
        new menuMain();
        
    }
    
    /** Runs the game */
    public static void runGame() {
        
        // Ask for the player name
        player = JOptionPane.showInputDialog("Enter your name");
        if (player == null || player.equals("")) { player = "Player"; }
        
        System.out.print(player);
        
        // Start the game frame
        gameFrame = new GameFrame(game);
        
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
                        
                    //}
                    
                   Sleep(difficulty);
                    
                }
                
            }
            
        });
        
        // Animation Thread
        Thread drawThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                // Redraw the screen
                while (true) { game.repaint(); }
                
            }
            
        });
        
        // Time Thread
        Thread timeThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    // TODO: Powerup code here
                    // This thread will count down the duration of the powerup in seconds, seperate from the drawing thread
                    Sleep(1000);
                    time++;
                    System.out.println(time + " seconds");
                    
                }
                
            }
            
        });
        
        gameThread.start();
        drawThread.start();
        timeThread.start();
        
    }
    
    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked 
     */
    public static void checkLines(Ball ball) {
        
        // Left
        if (ball.getLeft() <= GameFrame.xMin) { ball.setXSpeed(-(ball.getXSpeed())); }
        
        // Right
        if (ball.getRight() >= GameFrame.xMax + 15) { ball.setXSpeed(-(ball.getXSpeed())); }
        
        // Top
        if (ball.getTop() <= GameFrame.yMin) { ball.setYSpeed(-(ball.getYSpeed())); }
        
        // Bottom
        if (ball.getTop() >= GameFrame.yMax) {
            
            lives -= 1;
            
            if (lives == 0)
            {
                
                JOptionPane.showMessageDialog(gameFrame, "Game over!", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
            
                // Ends the program
                System.exit(0);
                
            } else {
                
                JOptionPane.showMessageDialog(gameFrame, "Try Again", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
                
                resetBall(ball);
                
            }
            
        }
        
    }
    
    /**
     * Check if the ball has hit the paddle
     * @param ball the ball in question
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
                if (ball.getX() < paddle.getX() + 8 - 7)
                {
                    
                    // Far Left Side
                    if (ball.getX() < paddle.getX() + 8 - 35)
                        ball.setXSpeed(-2);
                    else
                        ball.setXSpeed(-1);
                    
                } else if (ball.getX() > paddle.getX() + 8 + 7) {
                    
                    // Far Right Side
                    if (ball.getX() > paddle.getX() + 8 + 35)
                        ball.setXSpeed(2);
                    else
                        ball.setXSpeed(1);
                    
                } else {    // Middle of the Paddle
                    
                    ball.setXSpeed(0);
                    
                }
                
                ball.setYSpeed(-(ball.getYSpeed()));
                
            }
            
        }
        
    }
    
    /**
     * Checks if a brick has been hit
     * @param ball the ball in question
     */
    public static void checkBricks(Ball ball) {
        
        int count = 0;
        
        // Check for brick collisions
        for (Brick curBrick : GameLevel.brickList)
        {
            if (curBrick.Collide(ball))
            {
                
                score += 50 * (curBrick.getHealth() + 1);
                
                spawnPowerup(curBrick);
                
            }
            
            if (curBrick.isDestroyed())
            {
                count++;
            }
        }
        
        if (count == GameLevel.brickList.length)
        {
            boolean noLevels = false;
            
            JOptionPane.showMessageDialog(gameFrame, "Level Complete!");
            
            level++;
            resetBall(ball);
            
            try {
                
                GameLevel.changeLevel(level);
                
            } catch (NullPointerException e) {
                
                noLevels = true;
                
            }
            
            gameFrame.setEnabled(false);
            new menuSummary(gameFrame, level, score, totalScore, GameLevel.brickList.length, time, noLevels);
            
        }
    }
    
    /**
     * Checks if a powerup should spawn or not
     * @param brick the brick that was hit
     */
    public static void spawnPowerup(Brick brick) {
        
        int rand =  1 + (int)(Math.random() * ((10 - 1) + 1));
                
        // 10% Chance of Spawning
        if (rand == 1)
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
    public static void resetBall(Ball ball) {
        
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        
        ball.setX(paddle.getX() + 10);
        ball.setY(GameFrame.yMax - 65);
        
        ball.setXSpeed(0);
        ball.setYSpeed(0);
        
        ball.setLaunched(false);
        
    }
    
    /**
     * Sleeps the thread for the defined amount of ms
     * @param ms 
     */
    public static void Sleep(int ms) {
        
        // Because there's no other way to make smooth animation
        try {
            
            Thread.sleep(ms);
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
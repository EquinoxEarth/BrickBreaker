/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import javax.swing.*;

/**
 *
 * @author Cole
 */
public class BrickBreaker {
    
    /**
     * The ball that is used in the game
     */
    public static Ball ball = new Ball(320, 240, 50, 5);
    
    /**
     * The paddle that is used in the game
     */
    public static Paddle paddle = new Paddle(75);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final GameFrame game = new GameFrame();
        
        // Animation Thread
        Thread paintThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    // Move the ball
                    ball.setX(ball.getX() + ball.getXSpeed());
                    ball.setY(ball.getY() + ball.getYSpeed());
                    
                    Sleep(25);
                    
                    checkLines(ball, game);
                    
                    // Redraw the screen
                    game.repaint();
                    
                }
                
            }
            
        });
        
        // Input Thread
        Thread inputThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                while (true)
                {
                    
                    //TODO: Code the input listener
                    
                    Sleep(1000);
                    
                }
                
            }
        });
        
        paintThread.start();
        inputThread.start();
        
    }
    
    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked
     * @param game is the frame the ball is on
     */
    public static void checkLines(Ball ball, GameFrame game) {
        
        if ((ball.getX() - ball.getRadius()) <= (game.getXmin() - 50) || (ball.getX() + ball.getRadius()) >= game.getXmax())
            {
                
                ball.setXSpeed(-(ball.getXSpeed()));
                
            }
            
            if ((ball.getY() - ball.getRadius()) <= (game.getYmin() - 50) || (ball.getY() + ball.getRadius()) >= game.getYmax())
            {
                
                ball.setYSpeed(-(ball.getYSpeed()));
                
            }
        
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
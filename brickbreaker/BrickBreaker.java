/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cole
 */
public class BrickBreaker extends JFrame {
    
    /**
     * The ball that is used in the game
     */
    public static Ball ball = new Ball(320, 240, 20, 4);
    
    /**
     * The paddle that is used in the game
     */
    public static Paddle paddle = new Paddle(75, 20);
    
    /**
     * The game panel
     */
    static final GamePanel game = new GamePanel();
    
    public BrickBreaker(String name) {
        
        setTitle(name);
        setSize(450, 660);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BrickBreaker gameFrame = new BrickBreaker("Brick Breaker");
        
        gameFrame.add(game);
        
        paddle.x = (game.getWidth() / 2) - (paddle.width / 2);
        
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
        
        paintThread.start();
        
    }
    
    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked
     * @param game 
     */
    public static void checkLines(Ball ball, GamePanel game) {
        
        if ((ball.getX() - ball.getRadius()) <= (game.getXmin() - ball.getRadius()))
        {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        } else if ((ball.getX() + ball.getRadius() >= game.getXmax() - 6)) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        
        if ((ball.getY() - ball.getRadius()) <= game.getYmin() - ball.getRadius())
        {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        } else if ((ball.getY() + ball.getRadius()) >= game.getYmax()) {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        }
        
    }
    
    public static void checkPaddle(Ball ball) {
        
        if ((ball.getY() + ball.getRadius()) <= (15 + paddle.height / 2))
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
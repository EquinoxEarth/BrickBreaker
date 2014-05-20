/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import static brickbreaker.BrickBreaker.*;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cole
 */
public class GameFrame extends JFrame {
    
    public GameFrame(String name) {
    
        setTitle(name);
        setSize(580, 660);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    
    public void run() {
        
        final GamePanel game = new GamePanel();
        gameFrame.add(game);
        
        // Set paddle location
        paddle.x = (gameFrame.getWidth() / 2) - (paddle.width / 2);
        
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
                    checkPaddle(ball);
                    
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
        
        // Left and Right
        if ((ball.getX() - ball.getRadius()) <= (game.getXmin() - ball.getRadius()))
        {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        } else if ((ball.getX() + ball.getRadius() >= game.getXmax() - 6)) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        
        // Top and Bottom
        if ((ball.getY() - ball.getRadius()) <= game.getYmin() - 35)
        {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        } else if ((ball.getY() + ball.getRadius()) >= game.getYmax()) {
            
            //ball.setYSpeed(-(ball.getYSpeed()));
            
            lives -= 1;
            
            if (lives == 0)
            {
                
                JOptionPane.showMessageDialog(game, "Game over!");
            
                // Ends the program
                System.exit(0);
                
            } else {
                
                JOptionPane.showMessageDialog(game, "Try Again");
                
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
        // NEEDS TO BE FIXED
        if ((ball.getY() + ball.getRadius()) <= (paddle.height + 60))
        {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
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

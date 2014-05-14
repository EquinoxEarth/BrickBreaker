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
    
    public static Ball ball = new Ball(320, 240, 50, 5);
    
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
                    
                    ball.x += ball.xSpeed;
                    ball.y += ball.ySpeed;
                    
                    try {
                        
                        Thread.sleep(50);
                        
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                        
                    }
                    
                    checkLines(ball, game);
                    
                    game.repaint();
                    
                }
                
            }
            
        });
        
        paintThread.start();
        
    }
    
    public static void checkLines(Ball ball, GameFrame game) {
        
        if ((ball.x - ball.radius) <= (game.getXmin() - 50) || (ball.x + ball.radius) >= game.getXmax())
            {
                
                ball.xSpeed = -(ball.xSpeed);
                
            }
            
            if ((ball.y - ball.radius) <= (game.getYmin() - 50) || (ball.y + ball.radius) >= game.getYmax())
            {
                
                ball.ySpeed = -(ball.ySpeed);
                
            }
        
    }
    
}

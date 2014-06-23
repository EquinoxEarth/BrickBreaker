/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import static brickbreaker.game.Game.*;
import brickbreaker.game.items.Brick;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GamePanel extends JPanel {
    
    private final GameListener poll = new GameListener();
    
    public GamePanel() {
		
        setBackground(Color.black); //sets the background to black
        addKeyListener(poll);
        addMouseMotionListener(poll); //adds a motion listener
        addMouseListener(poll); //adds a mouse listener
        setFocusable(true); //sets the foucs to the panel
        setCursor(this.getToolkit().createCustomCursor( //sets the mouse location
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Clear the Screen
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Draw the Bricks
        for (Brick brickList : GameLevel.brickList) {
            
            // Check if brick is destroyed
            if (!brickList.isDestroyed())
            {
                
                g.setColor(brickList.getColor());
                g.fillRect(brickList.getLeft(), brickList.getTop(), Brick.width, Brick.height);
                
            }
            
        }
        
        // Set the color to white
        g.setColor(Color.white);
        
        // Horizontal Line
        g.drawLine(GameFrame.xMin, GameFrame.yMin, GameFrame.xMax, GameFrame.yMin);
        
        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ball.getLeft(), ball.getTop(), ball.getRadius() * 2, ball.getRadius() * 2);
        g.drawOval(ball.getLeft(), ball.getTop(), ball.getRadius() * 2, ball.getRadius() * 2);
        
        // Outline the ball in white
        g.setColor(Color.white);
        
        // Draw the paddle
        g.fillRect(paddle.getLeft(), GameFrame.yMax - 60, paddle.getWidth(), paddle.getHeight());
        
        // Draw Score
        g.drawString("Score: " + score + " (" + totalScore + ")", 10, 25);
        
        // Draw Lives
        g.drawString("Lives: " + lives, this.getWidth() - 50, 25);
        
        // Draw Time
        g.drawString("" + time, this.getWidth() / 2 - ((int)(Math.log10(time)+1) * 4), 25);
        
        // Draw Pause Text if Paused
        if (Game.paused)
            g.drawString("PAUSED", this.getWidth() / 2 - 25, this.getHeight() / 2);
              
    }
    
}
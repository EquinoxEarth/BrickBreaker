/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import static brickbreaker.game.Game.*;
import brickbreaker.game.items.Brick;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Cole
 */
public class GameListener implements MouseInputListener, KeyListener {
    
    public GameListener() {}

    @Override
    public void mouseClicked(MouseEvent e) { //when the mouse is clicked the ball is launched
        
        // TODO: Launch ball
        if (!ball.isLaunched())
        {
            
            ball.setYSpeed(1);
            ball.setLaunched(true);
            
        }
        
        if (e.getButton() == MouseEvent.BUTTON2) //destroys all the bricks if right clicked (for debugging)
            for (Brick brickList : GameLevel.brickList) { brickList.Destroy(); }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        if (!paused)
        {
            
            if (!ball.isLaunched()) //moving the mouses moves the paddle
            {
                
                ball.setX(paddle.getX() + 10);
                ball.setY(GameFrame.yMax - 75 - paddle.getHeight() / 2);
                
            }
            
            paddle.setX(e.getX());
        
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            
            // TODO: Launch ball
            if (!ball.isLaunched())
            {
                
                ball.setYSpeed(1);
                ball.setLaunched(true);
                
            }
            
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            paused = !paused;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import static brickbreaker.BrickBreaker.ball;
import static brickbreaker.BrickBreaker.paddle;
import brickbreaker.game.items.Brick;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Cole
 */
public class GameListener implements MouseInputListener {
    
    public GameListener() {}

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // TODO: Launch ball
        if (!ball.isLaunched())
        {
            
            ball.setYSpeed(1);
            ball.setLaunched(true);
            
        }
        
        if (e.getButton() == e.BUTTON2)
            for (Brick brickList : GameLevel.brickList) { brickList.Destroy(); }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        if (!ball.isLaunched())
        {
            
            ball.setX(paddle.getX() + 10);
            ball.setY(GameFrame.yMax - 65);
            
        }
        
        paddle.setX(e.getX());
        
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
    
    
}

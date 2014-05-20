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
public class BrickBreaker {
    
    public static GameFrame gameFrame;
    
    /**
     * The ball that is used in the game
     */
    public static Ball ball = new Ball(320, 240, 20, 4);
    
    /**
     * The paddle that is used in the game
     */
    public static Paddle paddle = new Paddle(100, 10);
    
    /**
     * The amount of lives they have left
     */
    public static int lives = 3;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Start Menu
        mainFrame menu = new mainFrame();
        
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
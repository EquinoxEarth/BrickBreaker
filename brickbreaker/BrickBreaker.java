/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import brickbreaker.menu.mainFrame;
import brickbreaker.game.GameFrame;

/**
 *
 * @author Cole
 */
public class BrickBreaker {
    
    public static GameFrame gameFrame;
    
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
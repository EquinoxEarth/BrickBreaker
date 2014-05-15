/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

/**
 * The paddle used to hit the ball
 * @author Cole
 */
public class Paddle {
    
    /**
     * The size of the paddle
     */
    public int size;
    
    /**
     * Holds whether or not the paddle is sticky
     */
    public boolean sticky = false;
    
    /**
     * Creates a Paddle with the supplied size
     * @param size 
     */
    public Paddle(int size) {
        
        this.size = size;
        
    }
    
}

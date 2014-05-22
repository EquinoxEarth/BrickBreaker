/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.powerups;

/**
 * Base class for powerups to be encountered ingame
 * @author Cole
 */
public class Powerup {
    
    /**
     * Name of the powerup
     */
    protected String name;
    
    /**
     * X coordinate of the powerup as it falls
     */
    protected int x;
    
    /**
     * Y coordinate of the powerup as it falls
     */
    protected int y;
    
    /**
     * Duration of the powerup
     */
    protected double duration;
    
    /**
     * Set to true if the powerup is active
     */
    protected boolean active;
    
    public String getName() {
        
        return this.name;
        
    }
    
    public int getX() {
        
        return this.x;
        
    }
    
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    public int getY() {
        
        return this.y;
        
    }
    
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    public double getDuration() {
        
        return this.duration;
        
    }
    
    public void decDuration() {
        
        
        
    }
    
}

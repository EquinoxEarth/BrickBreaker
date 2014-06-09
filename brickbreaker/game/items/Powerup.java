/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game.items;

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
     * Set to true if the powerup is active
     */
    protected boolean active;
    
    /**
     * Set to true if the powerup is currently falling
     */
    protected boolean spawned;
    
    /**
     * Returns the name of the active powerup
     * @return 
     */
    public String getName() {
        
        return this.name;
        
    }
    
    /**
     * Returns the X value of the falling powerup
     * @return 
     */
    public int getX() {
        
        return this.x;
        
    }
    
    /**
     * Sets the X value of the falling powerup
     * @param x 
     */
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    /**
     * Returns the Y value of the falling powerup
     * @return 
     */
    public int getY() {
        
        return this.y;
        
    }
    
    /**
     * Sets the Y value of the falling powerup
     * @param y 
     */
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    /**
     * Checks if the powerup is still active
     * @return 
     */
    public boolean isActive() {
        
        return this.active;
        
    }
    
    public void setActive(boolean active) {
        
        this.active = active;
        
    }
    
    public boolean isSpawned() {
        
        return this.spawned;
        
    }
    
    public void setSpawned(boolean spawned) {
        
        this.spawned = spawned;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game.powerups;

/**
 * Makes the ball stick to the paddle
 * @author Cole
 */
public class PowerupMagnet extends Powerup {
    
    public PowerupMagnet(int x, int y, double duration) {
        
        this.name = "Magnet";
        this.x = x;
        this.y = y;
        
    }
    
}
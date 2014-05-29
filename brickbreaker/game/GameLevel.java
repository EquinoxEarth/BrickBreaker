/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import java.util.Random;

import brickbreaker.game.items.Brick;

/**
 *
 * @author Cole
 */
public class GameLevel {
    
    public static Brick [] brickList;
    
    public static int [] xPos;
    public static int [] yPos;
    
    public GameLevel() {
        
        // Set allowable X Positions
        // I wouldn't use a loop here, just a giant ass section of declaration and assignment.
        
        // Set allowable Y Positions
        
    }
    
    public static void changeLevel(int level) {
        
        // Which level are we at?
        if (level == 1)
        {
            
            // TODO: Code Levels
            Brick[] bricks = new Brick[1];
            bricks[0] = new Brick(300,100);
            
            double rand = 1 + (int)(Math.random() * ((3 - 1) + 1));
            
            bricks[0].setHealth((int)rand);
            brickList = bricks;
            
        }
        
    }
    
    public static void setupBricks(Brick [] brickArray) {
        
        int x = 200;
        int y = 200;
        
        for (int i = 1; i < brickArray.length; i++)
        {
            
            brickArray[i].setX(x);
            brickArray[i].setY(y);
            x++;
            y++;
            
        }
        
    }
    
}

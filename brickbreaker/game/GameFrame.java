/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

/**
 *
 * @author Cole
 */
public class GameFrame extends javax.swing.JFrame {
    
    /**
     * The minimum an X value can be
     */
    public static final int xMin = 0;
    
    /**
     * The maximum an X value can be
     */
    public static final int xMax = 894;
    
    /**
     * The minimum a Y value can be
     */
    public static final int yMin = 40;
    
    /**
     * The maximum a Y value can be
     */
    public static final int yMax = 660;
    
    public GameFrame(javax.swing.JPanel panel) {
    
        //generates the frame
        
        setTitle("Brick Breaker"); //adds the title
        setSize(xMax, yMax); //sets the size
        setResizable(false); //sets it so you cant resize
        setDefaultCloseOperation(EXIT_ON_CLOSE); //ends the program when the window is closed
        setLocationRelativeTo(null); //puts it in the middle of the screen
        setVisible(true); //makes it visible
        add(panel); //adds the panel to the frame
    
    }
    
}

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
    
        setTitle("Brick Breaker");
        setSize(xMax, yMax);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);
    
    }
    
}

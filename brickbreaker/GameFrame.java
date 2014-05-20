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
public class GameFrame extends JFrame {
    
    public GameFrame(String name) {
    
        setTitle(name);
        setSize(580, 660);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    
}

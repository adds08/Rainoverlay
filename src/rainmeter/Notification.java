/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainmeter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Family
 */
public class Notification extends JLabel{
    
    
    Notification(){
        setOpaque(true);
        setBackground(new Color(48,48,48,100));
        setForeground(new Color(220,220,220,200));
        setFont(new Font("Calibri",1,42));
        setText("  .It is Raining.  ");
        setVisible(true);
    }
    
}

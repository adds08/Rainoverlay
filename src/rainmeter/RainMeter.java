/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainmeter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Family
 */
public class RainMeter{
      
    public static void main(String[] args) throws IOException, AWTException {
        if(!SystemTray.isSupported()) return;
        SystemTray tray = SystemTray.getSystemTray();
        Image imgicon = ImageIO.read(new File("res/rainIcon.png"));
        TrayIcon trayicon = new TrayIcon(imgicon);
        tray.add(trayicon);
            Dimension actual_screen_resolution = Toolkit.getDefaultToolkit().getScreenSize();
            int actual_screen_height=actual_screen_resolution.height;
            int actual_screen_width=actual_screen_resolution.width;
            JFrame frame= new JFrame();
            Notification notification = new Notification();
            Rain rds = new Rain(actual_screen_width,actual_screen_height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);
            frame.getContentPane().add(notification);
            frame.getContentPane().add(rds);
           
            frame.setAlwaysOnTop(true);
            frame.setBackground(new Color(0,0,0,0));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }
    
}

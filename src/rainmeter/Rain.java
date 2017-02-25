/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainmeter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Family
 */
public class Rain extends JPanel implements ActionListener{
    private int screenH;
    private int screenW;
    RainDrop[] rd;

    Timer timer = new Timer(40,this);
    boolean check_notify_collision=true;
    Rain(int wth,int hth){
        try{
            this.screenH=hth;
            this.screenW=wth;
            rd = new RainDrop[1000];
            
            setOpaque(false);
            setPreferredSize(new Dimension(wth,hth));
            setRainConstraints();  
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }
    public void setRainConstraints(){
        System.out.println(screenH);
        for(int i =0;i<rd.length;i++){
            rd[i]=new RainDrop(screenW,screenH);
        }
        timer.start();
        
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(3, 74, 236));
        for(int i =0;i<rd.length;i++){
            g2d.fillRect(rd[i].x, rd[i].y, rd[i].width, rd[i].height);
        }
        
        if(!check_notify_collision){
            g2d.setColor(new Color(40,40,40,150));
            g2d.fillRect(50,50,300, 75);
            g2d.setColor(new Color(250,250,250,150));
            g2d.setFont(new Font("Calibri", 1, 52));
            g2d.drawString("It is Raining", 75, 100);    
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        perf_drop();
        repaint();
    }
    
    
    public void perf_drop(){
        for(int i =0;i<rd.length;i++){
                rd[i].Drop();
                if(rd[i].y>screenH+50){
                    rd[i].setInit(screenW, screenH);
                }
            }
    }
}

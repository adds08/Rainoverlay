/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainmeter;

import java.util.Random;

public class RainDrop {
    int width;
    int height;
    int x;
    int y;
    int y_speed;
    int screen_width,screen_height;
    Random ran = new Random();
    
    RainDrop(int sw,int sh){
        setInit(sw,sh);
    }
    public void Drop(){
        y=y+y_speed;
    }
    public void setInit(int sw,int sh){
        this.screen_width=sw;
        this.screen_height=sh;
        this.x=ran.nextInt(screen_width)+1;
        this.width=ran.nextInt(2)+1;
        if(width>1){
            this.height=ran.nextInt(6)+15;
            this.y=-(ran.nextInt(501)+100);
            this.y_speed=ran.nextInt(10)+15;
        }
        else {
            this.height=ran.nextInt(6)+10;
            this.y=-(ran.nextInt(501)+100);
            this.y_speed=ran.nextInt(10)+10;
        }        
    }
}

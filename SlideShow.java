package app;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;


public class SlideShow{
  public static void main(String args[]){
     JFrame frame=new JFrame("SlideShow");
     frame.setSize(600,600);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JCanvas canvas=new JCanvas();
     frame.add(canvas);
     frame.setVisible(true);

     String[] files={"/home/jonathan/workspace/SADEC/bin/graficos/bg-buscador.png","/home/jonathan/workspace/SADEC/bin/graficos/bg-visor.png","/home/jonathan/workspace/SADEC/bin/graficos/bg-talleres.png"};
     int i=0;
     while(true){       
       BufferedImage im=canvas.loadImage(files[i]);
       int h=canvas.getHeight(); //window height
       int w=canvas.getWidth(); // window width
       double h1=im.getHeight(); //image height
       double w1=im.getWidth(); //image width
       double f=Math.min(h/h1,w/w1); // Scale factor
       if(f<0.2)f=0.2;
       int h2=(int) (h1*f), w2=(int) (w1*f);
       canvas.startBuffer();
       canvas.clear();
       canvas.drawScaledImage(im,(w-w2)/2,(h-h2)/2,w2,h2);
       canvas.endBuffer();
       i=(i+1)%files.length;
       canvas.sleep(2000);
     }
  }
}
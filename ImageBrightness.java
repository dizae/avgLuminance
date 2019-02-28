/*Calculates image brightness by luminance per pixel.
*
*
*@Diza
*/

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ImageBrightness{

    public static void lum(File ff) {
    BufferedImage img=null;
    Scanner in = new Scanner(System.in);
    
    double highest=0;
        try{
        
        highest=0;
        
        
        img = ImageIO.read(ff);
        int width=0;
        int height=0;
        int xx=0;
        int yy=0;
        int count=0;
        double avg=0;
        if(img!=null){
        width = img.getWidth();
        height = img.getHeight();
        }
        
        int x=100;
        int y=100;
        
        double lum = 0;
        double pixelTotal = 0;
        
       
        System.out.println("File: " + ff.getName());
        for (var i = 0; i < width; i++){ //collects lum data per pixel, for every pixel by height x every pixel by width
            for (var j = 0; j < height; j++) {
                pixelTotal++;
                int pixelCol = img.getRGB(x, y);
                int a = (pixelCol >>> 24) & 0xff;
                int r = (pixelCol >>> 16) & 0xff;
                int g = (pixelCol >>> 8) & 0xff;
                int b = pixelCol & 0xff;
                lum += (0.2126*r) + (0.7152*g) + (0.0722*b); //sums lum for each pixel, adding one at a time

            }
        }
        System.out.println("Average luminance is " + lum/pixelTotal + "."); //prints Average Luminance (per pixel)
        
        }catch(Exception e){
        
        System.out.println("THERE WAS A PROBLEM. Please try again.");
    }

}}
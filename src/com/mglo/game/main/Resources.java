package com.mglo.game.main;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Resources {

    public static BufferedImage welcome, iconimage, line;
    public static AudioClip hit, bounce;
    public static Color darkBlue, darkRed;

    public static void load(){
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
        line = loadImage("line.png");
        hit = loadSound("bounce.wav");
        bounce = loadSound("hit.wav");
        darkBlue = new Color(25, 83, 105);
        darkRed = new Color(185, 13, 13);
    }

    public static AudioClip loadSound(String fileName){
        URL fileURL = Resources.class.getResource("/resources/" + fileName);
        return Applet.newAudioClip(fileURL);
    }

    public static BufferedImage loadImage(String fileName){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Resource.class.getResourceAsStream("/resources/" + fileName));
        } catch (IOException e) {
            System.out.println("Error while reading: /resources/" + fileName);
            e.printStackTrace();
        }
        return img;
    }
}

package com.mglo.game.main;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Resources {

    public static BufferedImage welcome, iconimage;

    public static void load(){
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
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

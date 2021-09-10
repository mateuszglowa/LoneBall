package com.mglo.game.state;

import com.mglo.game.main.Resources;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MenuState extends State {
    @Override
    public void init() {
        System.out.println("Entered MenuState");
    }

    @Override
    public void update() {
        //Do nothing
    }

    @Override
    public void render(Graphics g) {
        //Draws Resources.welcome to the screen at x = 0, y = 0
        g.drawImage(Resources.welcome, 0, 0, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("OnClick");
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        //Intentionally ignored
        System.out.println("OnKeyPress");
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        //Intentionally ignored
        System.out.println("OnKeyRelease");
    }
}

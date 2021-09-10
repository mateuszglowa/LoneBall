package com.mglo.game.state;

import com.mglo.game.main.Resources;

import javax.annotation.Resource;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class LoadState extends State {
    @Override
    public void init() {
        Resources.load();
        System.out.println("Resources Loaded Successfully");
    }

    @Override
    public void update() {
        setCurrentState(new MenuState()); //This is the new line!
    }

    @Override
    public void render(Graphics G) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}

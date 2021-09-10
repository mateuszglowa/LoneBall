package com.mglo.game.state;

import com.mglo.game.main.GameMain;
import com.mglo.game.main.Resources;
import com.mglo.game.model.Paddle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayState extends State {

    private Paddle paddleLeft, paddleRight;
    private static final int PADDLE_WIDTH = 15;
    private static final int PADDLE_HEIGHT = 60;

    private int playerScore = 0;
    private Font scoreFont;

    @Override
    public void init() {
        paddleLeft = new Paddle(0, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddleRight = new Paddle(785, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
        scoreFont = new Font("SansSerif", Font.BOLD, 25);
    }

    @Override
    public void update() {
        paddleLeft.update();
        paddleRight.update();
    }

    @Override
    public void render(Graphics g) {
        //Draw Background
        g.setColor(Resources.darkBlue);
        g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
        g.setColor(Resources.darkRed);
        g.fillRect(GameMain.GAME_WIDTH / 2, 0,GameMain.GAME_WIDTH / 2, GameMain.GAME_HEIGHT);

        //Draw Separator
        g.drawImage(Resources.line, (GameMain.GAME_WIDTH / 2) -2, 0,null);

        //Draw Paddles
        g.setColor(Color.WHITE);
        g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
        g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());

        //Draw UI
        g.setFont(scoreFont);
        g.drawString(""+ playerScore, 350, 40);
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            paddleLeft.accelUp();
            paddleRight.accelDown();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleLeft.accelDown();
            paddleRight.accelUp();
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
            paddleLeft.stop();
            paddleRight.stop();
        }
    }
}

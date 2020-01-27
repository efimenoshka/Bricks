//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* Игровая лопатка */

class Puddle extends MovableSprite implements MouseListener {
    static final int LEFT = 37;
    static final int RIGHT = 39;
    static final int BACK_SPACE = 32;
    static final int alpha = 10;
    static final int LBUTTON = 1;
    static final int RBUTTON = 3;
    Puck p;
    int i=0;


    public Puddle(PlayField p, Image pic) {
        super(p, pic, new Rectangle(p.getWidth() / 2, p.getHeight() - 20, pic.getWidth(p),	pic.getHeight(p)), 0, 10);

        _pf.addMouseListener(this);
        //_pf.addKeyListener(this);
    }

    public void move() {
        if (_isMoving) {
            Rectangle b = _pf.getBoundary();
            _pos.x += _v.getSpeedX();

            if (_pos.x < b.x)
                _pos.x = b.x;
            else if (_pos.x + _pos.width > b.x + b.width)
                _pos.x = b.x + b.width - _pos.width;
        }
    }

    public void hitBy(Puck p) {
        this.p = p;
        if(i==1){
            p.stopMoving();
        }
        if ( p.getDirection() == 90 ) {
            p.setDirection(270 + alpha);
        } else {
            int px = p.getBounds().x + p.getBounds().width/2;
            int l  = (int) (_pos.x +_pos.width*(1.0/3));  //Левая треть
            int r  = (int) (_pos.x +_pos.width*(2.0/3));  //Правая треть

            /*if ( px < l || px > r ) {
                p.getVelocity().reverse();
            } else {
                p.getVelocity().reverseY();
            }*/
            if (px<l){ //отскок мяча
                p.getVelocity().reverse();
            } else if (px > r){
                int a = p.getDirection();
                p.setDirection(a - alpha);
                p.getVelocity().reverseY();
            } else{
                int a = p.getDirection();
                p.setDirection(a + alpha);
                p.getVelocity().reverseY();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == LBUTTON){
            startMoving();
            _v.setDirection(180);
        }
        if (e.getButton() == RBUTTON) {
            startMoving();
            _v.setDirection(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        stopMoving();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
;
    }

    @Override
    public void mouseExited(MouseEvent e) {
;
    }


    /*Обработка нажатия клавиши
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == LEFT) {
            startMoving();
            _v.setDirection(180);
        } else if (e.getKeyCode() == RIGHT) {
            startMoving();
            _v.setDirection(0);
        } else if (e.getKeyCode() == BACK_SPACE) {
            i=1;
        }
    }*/

    /* Обработка отжатия клавиши
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == LEFT) {
            stopMoving();
        } else if (e.getKeyCode() == RIGHT) {
            stopMoving();
        } else if (e.getKeyCode() == BACK_SPACE) {
            p.startMoving();
            i=0;
        }
        stopMoving();
    }*/

    public void keyTyped(KeyEvent e) {
        ;
    }
}
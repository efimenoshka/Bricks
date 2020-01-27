//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class BrickPile {
    private PlayField _pf;
    private ArrayList _bricks;
    private final int _rows = 4;
    private final int _cols = 10;
    private int countWall = 0;
    private int countSticky = 0;

    public BrickPile(PlayField pf, Image img, Image img0, Image img1, Image img2, Image img3, Image img4, Image img5) {
        _pf = pf;
        _bricks = new ArrayList();
        int startx = 80;
        int x = startx, y = 10;

        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _cols; c++) {
                Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));

                switch ((r+c)%4)
                {
                    case 0:
                        Brick b = new Brick(_pf, this, img, pos);
                        pf.addSprite(b);
                        _bricks.add(b);
                        break;

                    case 1:
                        Brick b1 = new HardBrick(_pf, this, pos, img0, img);
                        pf.addSprite(b1);
                        _bricks.add(b1);
                        break;

                    case 2:
                        Brick b2 = new PowerBrick(_pf, this, pos, img1);
                        pf.addSprite(b2);
                        _bricks.add(b2);
                        break;

                    case 3:
                        Brick b3 = new StickyBrick(_pf, this, pos, img3);
                        pf.addSprite(b3);
                        _bricks.add(b3);
                        countSticky ++;
                        break;

                    /*case 3:
                        Brick b3 = new WallBrick(_pf, this, pos, img2);
                        pf.addSprite(b3);
                        _bricks.add(b3);
                        countWall ++;
                        break;
                    case 3:
                        Brick b4 = new ArmorBrick(_pf, this, pos, img3);
                        pf.addSprite(b4);
                        _bricks.add(b4);
                        break;
                    case 3:
                        Brick b5 = new TrapBrick(_pf, this, pos, img4);
                        pf.addSprite(b5);
                        _bricks.add(b5);
                        break;*/
                }
                x += img.getWidth(null);
            }
            y += img.getHeight(null) + 2;
            x = startx;
        }
    }

    public int unbrokenCount() {
        int result = 0;

        for (int i = 0; i < _bricks.size(); i++) {
            if ( !((Brick) _bricks.get(i)).isDead() )
                result++;
        }
        return result - countWall;
    }
    public int brokenCount() {
        return _bricks.size() - unbrokenCount();
    }
}
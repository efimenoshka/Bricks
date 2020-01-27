import java.awt.*;

public class StickyBrick extends  Brick {
    public StickyBrick(PlayField pf, BrickPile bp, Rectangle p, Image img) {
        super(pf, bp, img, p);
    }

    /* Oбработка соударения с шайбой. Как только
     * значение _hitCount становится равным нулю
     * и будет удален с игрового поля
     */

    public void hitBy(Puck p)  {
        _pf.stop();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _pf.start();
        p.setDirection(90);
    }

}

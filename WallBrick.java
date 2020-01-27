import java.awt.*;

public class WallBrick extends Brick
{
    public WallBrick(PlayField pf, BrickPile bp, Rectangle p, Image img) {
        super(pf, bp, img, p);
    }

    /* Oбработка соударения с шайбой. Как только
     * значение _hitCount становится равным нулю
     * и будет удален с игрового поля
     */

    public void hitBy(Puck p) {
        p.getVelocity().reverseY(); //неубиаемые камни
    }
}


import java.awt.*;

public class ArmorBrick extends Brick {
    private int _armorCount = 0;

    public ArmorBrick(PlayField pf, BrickPile bp, Rectangle p, Image img) {
        super(pf, bp, img, p);
    }

    public void hitBy(Puck p) {
        if (_pos.y > p._pos.y) { //удар сверху
            if (_armorCount > 0) {
                _armorCount--;
            } else {
                _isDead = true;
                if (_bp.unbrokenCount() == 0) {
                    _pf.getMatch().win();
                }
            }
        }
        p.getVelocity().reverseY();
    }
}

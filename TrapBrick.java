import java.awt.*;

public class TrapBrick extends Brick {
    private int _countTrap = 0;

    public TrapBrick(PlayField pf, BrickPile bp, Rectangle p, Image img) {
        super(pf, bp, img, p);
    }

    public void hitBy(Puck p) {
        if (_pos.y < p._pos.y) {
            p.trap();
        } else {
            _isDead = true;
            if (_bp.unbrokenCount() == 0) {
                _pf.getMatch().win();
            }
        }

        p.getVelocity().reverseY();
    }

}

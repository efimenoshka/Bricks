import java.awt.*;

public class PowerBrick extends Brick {
    public PowerBrick(PlayField pf, BrickPile bp, Rectangle p, Image img) {
        super(pf, bp, img, p);
    }

    public void hitBy(Puck p) {
            _isDead = true;
            p.getVelocity().setSpeed(2); //увеличение скорости
            p.getVelocity().reverseY();


            if (_bp.unbrokenCount() == 0) {
                _pf.getMatch().win();
            }
        }
    }


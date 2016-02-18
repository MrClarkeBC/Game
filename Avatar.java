import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class Avatar extends Sprite implements IAvatar
{
    Avatar(Canvas p)
    {
        super(p);
    }

    protected void paint(Graphics2D g2d)
    {

        Point p = getLocation();
        if (p != null) {
            g2d.setColor(getColor());
            g2d.draw(getBounds());
        }
    }

    public void keyPressed(KeyEvent event) 
    {
        int keyCode = event.getKeyCode();
        if (keyCode == event.VK_LEFT)
        {
            m_location.x--;
        }
        if (keyCode == event.VK_RIGHT)
        {
            m_location.x++;
        }
        if (keyCode == event.VK_UP)
        {
            m_location.y--;
        }
        if (keyCode == event.VK_DOWN)
        {
            m_location.y++;
        }
    }

}

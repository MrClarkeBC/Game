import java.awt.event.KeyEvent;

public class TextAvatar extends TextSprite implements IAvatar
{
    TextAvatar(Canvas p, String s)
    {
        super(p, s);
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

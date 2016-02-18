import java.awt.*;

public class TextSprite extends Sprite
{
    private String m_text;
    private int textHeight;

    TextSprite(Canvas p, String s)
    {
        super(p);
        m_text = s;
        String[] outputs = m_text.split("\n");
        textHeight = p.getFontMetrics(new Font("monospaced", Font.PLAIN, 12)).getHeight();
        m_size.height = outputs.length * textHeight;
        m_size.width = p.getFontMetrics(new Font("monospaced", Font.PLAIN, 12)).stringWidth(outputs[0]);

    }

    protected void paint(Graphics2D g2d)
    {
        Point p = getLocation();
        if (p != null) {
            g2d.setColor(getColor());
            String[] outputs = m_text.split("\n");
            for(int i=0; i<outputs.length; i++)
            {
                g2d.drawString(outputs[i], p.x, p.y + i*textHeight);
            }
        }
    }

    public Rectangle getBounds()
    {
        return new Rectangle(m_location.x,m_location.y - textHeight,
            m_size.width, 
            m_size.height);
    }

}

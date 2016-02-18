import java.awt.*;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.FontMetrics;
import java.awt.font.FontRenderContext;

public class Sprite
{
    private Canvas m_parent;
    private Color m_color;
    protected Point m_location;
    protected Dimension m_size;
    private Point m_vector;
    private         Image m_img;
    public Sprite(Canvas p)
    {
        m_parent = p;
        m_location = new Point(0,0);
        m_vector = new Point(0, 0);
        m_size = new Dimension(30, 30);
        //m_img = new ImageIcon("Profile.jpg").getImage();
    }

    public void animate()
    {
        m_location.x += m_vector.x;
        m_location.y += m_vector.y;
    }

    public void collision(ArrayList<Sprite> sprites)
    {
        System.out.println("collision");
    }

    public Canvas getParent() { return m_parent;}

    public Dimension getSize() {
        return m_size;
    }

    public void setColor(Color m_color) {
        this.m_color = m_color;
    }

    public void setLocation(Point m_location) {
        this.m_location = m_location;
    }

    public Color getColor() {
        return m_color;
    }

    public Point getLocation() {
        return m_location;
    }

    public Point getVector() {
        return m_vector;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(m_location.x,m_location.y,
            m_size.width, 
            m_size.height);
    }

    public void setSpeed(Point m_vector) {
        this.m_vector = m_vector;
    }

    protected void paint(Graphics2D g2d) {

        Point p = getLocation();

        g2d.setColor(getColor());
        g2d.fillOval(p.x, p.y, m_size.width, m_size.height);
        //g2d.drawImage(m_img,p.x,p.y,null);
    }

}

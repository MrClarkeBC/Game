import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Canvas extends JPanel {
    private List<Sprite> spriteList;
    public void addSprite(Sprite s) { spriteList.add(s);}
    public void removeSprite(Sprite s) { spriteList.remove(s);}

    public Canvas() 
    {
        spriteList = new ArrayList<Sprite>(25);
        addKeyListener(new AL());
        setFont(new Font("monospaced", Font.PLAIN, 12));

    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Sprite s : spriteList)
        {
            s.paint(g2d);
        }
        g2d.dispose();
    }

    public List<Sprite> getSprites() {
        return spriteList;
    }

    public class AL extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent event) 
        {
            for(int i = 0; i< spriteList.size(); i++)//For every Sprite
            {
                if (spriteList.get(i) instanceof IAvatar)
                    ((IAvatar) spriteList.get(i)).keyPressed(event);
            }
        }

    }

}

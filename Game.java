import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Game
{

    public static void main(String[] args)
    {
        new Game();
    }

    public Game() {
        EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException ex) {
                    } catch (InstantiationException ex) {
                    } catch (IllegalAccessException ex) {
                    } catch (UnsupportedLookAndFeelException ex) {
                    }

                    JFrame frame = new JFrame("Game");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    Canvas c = new Canvas();
                    c.setFocusable(true);

                    // Set up the game
                    Sprite s = new Sprite(c);
                    s.setLocation(new Point(10,60));
                    TextSprite t = new TextAvatar(c,"XXXXX\nYYYYY\nZZZZZ");
                    t.setLocation(new Point(40,20));
                    Avatar a = new Avatar(c);
                    a.setLocation(new Point(65,45));
                    

                    c.addSprite(s);
                    c.addSprite(t);
                    //c.addSprite(a);
                    frame.add(c);
                    frame.setSize(400, 400);
                    frame.setVisible(true);

                    // Start game engine
                    new Thread(new GameEngine(c)).start();

                }
            });
    }

    public class GameEngine implements Runnable {
        private Canvas parent;

        public GameEngine(Canvas parent) {
            this.parent = parent;
        }

        @Override
        public void run() {

            while (getParent().isVisible())
            {
                // Repaint the sprites pen...
                SwingUtilities.invokeLater(new Runnable() { @Override
                        public void run() { getParent().repaint();     }
                    });

                // This is a little dangrous, as it's possible
                // for a repaint to occur while we're updating...
                for (Sprite s : getParent().getSprites())
                {
                    // Animate
                    s.animate();
                }
                // Notify of collisions
                for (Sprite s1 : getParent().getSprites())
                {
                    ArrayList<Sprite> sprites = new ArrayList<Sprite>();
                    for (Sprite s2 : getParent().getSprites())
                    {
                        Rectangle r1 = s1.getBounds();
                        Rectangle r2 = s2.getBounds();
                        if (s1 != s2 && s1.getBounds().intersects(s2.getBounds()))
                            sprites.add(s2);
                    }
                    if (sprites.size() > 0)
                        s1.collision(sprites);
                }

                // Some small delay...
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }

            }

        }

        public Canvas getParent() {
            return parent;
        }
    }
}

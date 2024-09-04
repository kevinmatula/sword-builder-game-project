import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    //manager of all sprites, backgrounds, and gameplay
    //Scenes can be determined here or we can make a scenemanager if that is
    //helpful

    Timer time;
    JPanel p1, p2, p3, p4, credits, p5, p6;
    JFrame frame;

    TitleScreen ts;
    MetalsScreen ms;
    PouringScreen ps;
    CreditsScreen cs;
    HandleScreen hs;
    BattleScreen bs;
    DeathScreen ds;

    int progress, desiredLocation, durability;
    int score;

    public GamePanel(JFrame frame)
    {
        //frame
        this.frame = frame;
        frame.setFocusable(true);

       //initializing stuff
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        ts = new TitleScreen(frame, p1, this);
        ms = new MetalsScreen(frame, p2, this);
        ps = new PouringScreen(frame, p3, this, 1);
        cs = new CreditsScreen(frame, credits, this);
        hs = new HandleScreen(frame, p4, this, 1);
        bs = new BattleScreen(frame, p5, this, 1);
        ds = new DeathScreen(frame, p6, this);
        //
        //
        //timer
        time = new Timer(16, this);

        frame.addKeyListener(this);


        time.start();
        frame.setVisible(true);
        frame.revalidate();
    }

    //we are going to add a way for the images to change the images depending on the direction
    //Maybe we can add it to the keyPressed when we decide what keys will move the sprite

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //every output onto the screen will come from here
    }

    public void actionPerformed(ActionEvent e)
    {
        ps.repaint();
        frame.revalidate();
    }

    public void keyPressed(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public TitleScreen getTitleScreen()
    {
        return ts;
    }

    public MetalsScreen getMetalsScreen()
    {
        return ms;
    }

    public PouringScreen getPouringScreen()
    {
        return ps;
    }

    public CreditsScreen getCreditsScreen()
    {
        return cs;
    }

    public HandleScreen getHandleScreen()
    {
        return hs;
    }

    public BattleScreen getBattleScreen()
    {
        return bs;
    }

    public DeathScreen getDeathScreen()
    {
        return ds;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int newScore)
    {
        score = newScore;
    }

    public int getDurability()
    {
        return durability;
    }

    public void addDurability(int given)
    {
        durability += given;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
public class TitleScreen extends JPanel implements ActionListener, KeyListener
{
    JPanel p1;
    JLabel header, subheader;
    JFrame frame;
    GamePanel gp;
    JButton credits;
    ImageIcon startScreen, pressStart;
    Clip planesBackgroundMusic;

    public TitleScreen(JFrame frame, JPanel p1, GamePanel gp)
    {
		Music.loadMusic();
		Music.playBuildMusic();






        this.p1 = p1;
        this.gp = gp;
        this.frame = frame;
        setLayout(null);
        //setBackground(Color.BLACK);
        //header code
        startScreen = new ImageIcon("startscreen done.png");
        header = new JLabel(startScreen);
        pressStart = new ImageIcon("PressSpaceToContinue.png");
        subheader = new JLabel(pressStart);
        //header.setForeground(Color.BLACK);
        //header.setFont(new Font("Serif", Font.BOLD, 40));
        header.setBounds(0, 0, 1920, 1080);
        subheader.setBounds(580, 740, 808, 200);
        System.out.println("test");
        credits = new JButton("Credits");
        credits.setBounds(1750, 900, 100, 20);
        credits.setFont(new Font("Showcard Gothic", Font.BOLD, 15));
        add(subheader);
        add(credits);
        add(header);
        
        credits.addActionListener(this);
        frame.addKeyListener(this);
        //add(p1);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(frame.getContentPane() == gp.getTitleScreen())
        {
            if(e.getSource() == credits)
            {
                frame.setContentPane(gp.getCreditsScreen());
                frame.revalidate();
                frame.repaint();
            }
        }
    }
    public void keyPressed(KeyEvent e)
    {
        if(frame.getContentPane() == gp.getTitleScreen())
        {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
            frame.setContentPane(gp.getMetalsScreen());
            frame.revalidate();
            frame.repaint();
            System.out.println("test");
            }
        }

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

    /*public void paintComponents(Graphics g)
    {
        //super.paintComponents(g);
    }*/
}
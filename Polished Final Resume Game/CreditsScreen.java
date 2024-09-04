import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CreditsScreen extends JPanel implements ActionListener
{
    JFrame frame;
    JPanel creditsPanel;
    GamePanel gp;
    ImageIcon background;
    JLabel creditsBackground, creditsScreen;
    JButton back;

    public CreditsScreen(JFrame frame, JPanel creditsPanel, GamePanel gp)
    {
        this.frame = frame;
        this.creditsPanel = new JPanel();
        this.gp = gp;
        setLayout(null);

        background = new ImageIcon("baseBackgroundDone.png");
        creditsBackground = new JLabel(background);
        creditsScreen = new JLabel("<html>Manager: Zachary Daudelin <br/> Coders: Ava Maher, Kaleb Mencher, Kevin Matula, Joey Sisto <br/>Animators: Adam Mencher, Amanda Figueroa Crespo, Amaya Reid, Erika Tuncel <br/> Musics: DJ Alden Song(+others idk who they are yet)<html/>", SwingConstants.CENTER);
        back = new JButton("Back");
        creditsScreen.setBounds(0, 0, 1920, 1080);
        creditsBackground.setBounds(0,0,1920,1080);
        creditsScreen.setForeground(Color.WHITE);
        creditsScreen.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
        back.setFont(new Font("Showcard Gothic", Font.BOLD, 15));
        back.setBounds(1750, 900, 100, 20);
        add(back);
        add(creditsScreen);
        add(creditsBackground);
        
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == back)
        {
            frame.setContentPane(gp.getTitleScreen());
        }
    }
}
//12:36 PM 6/13/24
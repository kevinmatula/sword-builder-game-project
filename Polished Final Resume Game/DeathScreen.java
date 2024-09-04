import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DeathScreen extends JPanel
{
    JFrame frame;
    JPanel deathPanel;
    GamePanel gp;
    ImageIcon background;
    JLabel deathBackground, deathScreen, infoLabel;

    public DeathScreen(JFrame frame, JPanel deathPanel, GamePanel gp)
    {
        this.frame = frame;
        this.deathPanel = new JPanel();
        this.gp = gp;
        setLayout(null);

        background = new ImageIcon("deathScreen.png");
        deathBackground = new JLabel(background);
        deathScreen = new JLabel("Total Score: " + gp.getScore());
        deathScreen.setBounds(780, 620, 600, 400);
        deathBackground.setBounds(0,0,1920,1080);
        deathScreen.setForeground(Color.WHITE);
        deathScreen.setFont(new Font("Monospaced", Font.BOLD, 60));
        infoLabel = new JLabel("Restart to Play Again...");
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Monospaced", Font.BOLD, 60));
        infoLabel.setBounds(600,30,1000,300);
        add(infoLabel);
        add(deathScreen);
        add(deathBackground);
        Music.stopDeathMusic();
		Music.playBuildMusic();
    }         

}
//12:36 PM 6/13/24
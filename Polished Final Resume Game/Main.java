import javax.swing.*;
public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Blacksmith Sim");
        frame.setUndecorated(true);
        frame.setVisible(true);
        GamePanel gp = new GamePanel(frame);
        frame.setContentPane(gp.getTitleScreen());
        frame.revalidate();
        frame.setSize(1920, 1080);
    }
}
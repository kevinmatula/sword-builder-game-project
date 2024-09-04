import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MetalsScreen extends JPanel implements ActionListener
{
    JPanel p2;
    ImageIcon copper, steel, gold, copperButtonImage, steelButtonImage, goldButtonImage, backgroundImage, hoverImage, elementImage;
    JLabel copperImage, steelImage, goldImage, background, hoverLabel;
    JButton copperButton, steelButton, goldButton;
    GamePanel gp;
    JFrame frame;
    int num;

    public MetalsScreen(JFrame frame, JPanel p2, GamePanel gp)
    {
        this.p2 = p2;
        this.gp = gp;
        this.frame = frame;
        backgroundImage  = new ImageIcon("chooseyourmetal.png");
        setBackground(new Color(83,153,85));
        background = new JLabel(backgroundImage);
        p2.setBounds(0, 0, 1920, 1080);
        background.setBounds(0,0, 1920, 1000);
        setLayout(null);
        //copper declaration and placement
        num = 3;
        hoverImage = new ImageIcon("hoverLabel.png");
        hoverLabel = new JLabel(hoverImage);
        hoverLabel.setBounds(385, -35, 1281, 205);
        copper = new ImageIcon("copper.jpg");
        copperImage = new JLabel(copper);
        copperImage.setBounds(0, 0, 640, 640);
        copperImage.setToolTipText("<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white;'>Choosing copper means that you are choosing sensibility and precaution <br> over being overly bold. With copper, your chances of maximizing your potential <br> durability are high, but that maximum durability is less than that of iron and <br> diamond. However, the agility of your sword will be higher than any other option. This <br> allows you to have an advantage in your testing. People who choose copper can be <br> described as introverted and self-effacing, but nonetheless sharp-witted and stealthy.</div></html>");
        copperButtonImage = new ImageIcon("copper.png");
        copperButton = new JButton(copperButtonImage);
        copperButton.setBounds(375, 750, 325, 90);
        add(copperImage);
        add(copperButton);
        add(hoverLabel);
        //steel decleration and placement
        steel = new ImageIcon("steel.png");
        steelImage = new JLabel(steel);
        steelImage.setBounds(640, 0, 640, 640);
        steelImage.setToolTipText("<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white;'>Iron is the middle ground between acting daringly and playing it too safe.<br> You will have better durability than copper, but worse than diamond; meanwhile, <br> it is easier and more difficult to maximize your durability than diamond and copper respectively. <br> It also falls right in the middle of the agility ranking, falling below copper <br> and above diamond. People who choose iron tend to be the 'ambiverts' of the <br> gaming world; they don't really seem to fit in with either end of the spectrum, so they are <br> able to find a happy medium in their lives.</div></html>");
        add(steelImage);
        steelButtonImage = new ImageIcon("iron.png");
        steelButton = new JButton(steelButtonImage);
        steelButton.setBounds(860, 750, 200, 100);
        add(steelButton);
        //gold decleration and placement
        gold = new ImageIcon("gold.png");
        goldImage = new JLabel(gold);
        goldImage.setBounds(1280, 0, 640, 640);
        goldImage.setToolTipText("<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white;'>It's brilliant! Diamond is the absolute highest standard of sword, and is meant only <br> for those who are worthy of wielding it. However, there are some caveats; for <br> starters, it is very difficult to create a good sword when using diamond. <br> You have to be very quick in order to shape your sword properly. Additionally, the diamond sword can <br> prove to be unwieldy for some. It has the lowest agility of any sword. Those <br> who choose diamond, therefore, are the experts, and they may be viewed as the extroverted leaders, <br> whose primary internal goal is to be the 'hero' over all else</div></html>");

        //goldImage.setToolTipText("<html>It's brillient! Diamond is the absolute highest standard of sword, and is meant only <br> for those who are worthy of wielding it. However, there are some caveats; for <br> starters, it is very difficult to create a good sword when using diamond. You have to be very quick in order to shape your sword properly. Additionally, the diamond sword can <br> prove to be unwieldy for some. It has the lowest agility of any sword. Those <br> who choose diamond, therefore, are the experts, and they may be viewed as the extroverted leaders, <br> whose primary internal goal is to be the 'hero' over all else.</html>");
        add(goldImage);
        goldButtonImage = new ImageIcon("diamond.png");
        goldButton = new JButton(goldButtonImage);
        goldButton.setBounds(1150, 750, 425, 100);
        add(goldButton);
        add(background);

        copperButton.addActionListener(this);
        steelButton.addActionListener(this);
        goldButton.addActionListener(this);
        //add(p2);
        //frame.revalidate();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(frame.getContentPane() == gp.getMetalsScreen())
        {
            if(e.getSource() == copperButton)
            {
                //set handle variable to a number 1-3
                //and move to pouring screen

                gp.getPouringScreen().setType(1);
                frame.setContentPane(gp.getPouringScreen());
                num = 1;
            }
            if(e.getSource() == steelButton)
            {
				gp.getPouringScreen().setType(2);
                frame.setContentPane(gp.getPouringScreen());
                System.out.println("steel");
                num = 2;
            }
            if(e.getSource() == goldButton)
            {
				gp.getPouringScreen().setType(3);
                frame.setContentPane(gp.getPouringScreen());
                System.out.println("gold");
                num = 3;
            }
        }
    }

    public int getNum()
    {
        return num;
    }
}
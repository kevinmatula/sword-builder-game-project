import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//max score that can be obtained:
//Copper: 20
//Iron: 30
//Diamond: 40
public class HandleScreen extends JPanel implements MouseMotionListener, MouseListener, ActionListener, KeyListener
{
    JFrame frame;
    JPanel p4;
    GamePanel gp;
    Toolkit tk;
    ImageIcon handle, copperSword, ironSword, diamondSword, handleOutline, spaceTip, handleTip, nextTip;
    Image i;
    //Weapon sword;
    String type;
    int damage, durability, perfX, perfY;
    Rectangle r;
    JLabel swordLabel, battleLabel, sword, outline, tip, finalTip, space;
    JButton battleButton;
    int mouseX, mouseY, num, handleW, handleH, swordW, swordH;
    int swordDurability;
    boolean readyToGo;

    public HandleScreen(JFrame frame, JPanel p4, GamePanel gp, int num)
    {
        this.frame = frame;
        this.p4 = p4;
        this.gp = gp;
        this.num = num;
        setLayout(null);
        tk = Toolkit.getDefaultToolkit();
        handleOutline = new ImageIcon("handleShadow.png");
        outline = new JLabel(handleOutline);
        outline.setBounds(820, 580, 458, 465);
        handleW = 300;
        handleH = 400;
        swordW = 200;
        swordH = 600;
        readyToGo = false;
        perfX = 909;
        perfY = 583;

        handle = new ImageIcon(tk.getImage("Handle-Head.png").
        getScaledInstance(handleW, handleH, Image.SCALE_DEFAULT));
        handleTip = new ImageIcon(tk.getImage("handleTip.png").
        getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        nextTip = new ImageIcon(tk.getImage("handleFinalTip.png").getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        finalTip = new JLabel(nextTip);
        finalTip.setVisible(false);
        spaceTip = new ImageIcon(tk.getImage("spaceToContinue.png").getScaledInstance(677, 100, Image.SCALE_DEFAULT));
        finalTip.setBounds(-100, 0, 1045, 600);
        space = new JLabel(spaceTip);
        space.setVisible(false);
        space.setBounds(10, 600, 677, 100);
        swordLabel = new JLabel(handle);
        swordLabel.setBounds(1600, 20, handleW, handleH);
        tip = new JLabel(handleTip);
        tip.setBounds(-100, 0, 1045, 600);

        copperSword = new ImageIcon(tk.getImage("Worst-Sword-Head.png").getScaledInstance(swordW, swordH, Image.SCALE_DEFAULT));
        
        sword = new JLabel(copperSword);
        sword.setBounds(960, 0, swordW, swordH);


        perfX = 0;//we will change depending on where the sword is placed
        perfY = 0;//we will change depending on where the sword is placed
        //sword = new Weapon(type, damage, durability, i, r);
        battleLabel = new JLabel("Are You Ready To Battle?");
        battleButton = new JButton("To Battle");
        battleLabel.setBounds(100, 10, 50, 25);
        battleButton.setBounds(150, 10, 50, 25);
        add(space);
        add(finalTip);
        add(tip);
        add(sword);
        add(outline);
        add(swordLabel);
        swordLabel.addMouseMotionListener(this);
        swordLabel.addMouseListener(this);
        frame.addKeyListener(this);
    }
    public void mouseClicked(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    //boolean isDraggable = false;
    @Override
    public void mousePressed(MouseEvent e)
    {
            mouseX = e.getX();
            mouseY = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        int swordX = swordLabel.getX();
        int swordY = swordLabel.getY();
        double newScore = 0;
        System.out.println("X " + swordX);
        System.out.println("Y " + swordY);

        //If the Copper Sword is Picked
        if(frame.getContentPane() == gp.getHandleScreen() && gp.getHandleScreen().getNum() == 1)
        {
            if(swordX - perfX == 0 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(20);
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(15);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 30 || perfY - swordY == 30)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 30 || perfY - swordY >= 30)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 10 || perfX - swordX == 10)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(15);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(50);
                    
                }
                if(swordY - perfY >= 20 || perfY - swordY >= 20)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 20 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(5);
                   
                }
                if(swordY - perfY >= 10 || perfY - swordY >= 10)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 30 || perfX - swordX == 30)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 0 || perfY - swordY >= 0)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX >= 30 || perfX - swordX >= 30)
            {
                System.out.println("lol");
            }
        }


        //If Iron Is Picked
        if(frame.getContentPane() == gp.getHandleScreen() && gp.getHandleScreen().getNum() == 2)
        {
            if(swordX - perfX == 0 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(30);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(20);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 30 || perfY - swordY == 30)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 30 || perfY - swordY >= 30)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 10 || perfX - swordX == 10)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(20);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 20 || perfY - swordY >= 20)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 20 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 10 || perfY - swordY >= 10)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 30 || perfX - swordX == 30)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(5);
                    
                }
                if(swordY - perfY >= 0 || perfY - swordY >= 0)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX >= 30 || perfX - swordX >= 30)
            {
                System.out.println("lol");
            }
        }

        //If Diamond is Picked
        if(frame.getContentPane() == gp.getHandleScreen() && gp.getHandleScreen().getNum() == 3)
        {
            if(swordX - perfX == 0 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(40);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(30);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(20);
                    
                }
                if(swordY - perfY == 30 || perfY - swordY == 30)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY >= 30 || perfY - swordY >= 30)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 10 || perfX - swordX == 10)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(30);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(20);
                    
                }
                if(swordY - perfY == 20 || perfY - swordY == 20)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY >= 20 || perfY - swordY >= 20)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 20 || perfX - swordX == 0)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(20);
                    
                }
                if(swordY - perfY == 10 || perfY - swordY == 10)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY >= 10 || perfY - swordY >= 10)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX == 30 || perfX - swordX == 30)
            {
                if(swordY - perfY == 0 || perfY - swordY == 0)
                {
                    gp.addDurability(10);
                    
                }
                if(swordY - perfY >= 0 || perfY - swordY >= 0)
                {
                    System.out.println("lol");
                }
            }
            if(swordX - perfX >= 30 || perfX - swordX >= 30)
            {
                System.out.println("lol");
            }
        }
        tip.setVisible(false);
        finalTip.setVisible(true);
        space.setVisible(true);
        readyToGo = true;
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        int newX = e.getXOnScreen() - mouseX;
        int newY = e.getYOnScreen() - mouseY;
        swordLabel.setLocation(newX, newY);
    }

    public void mouseMoved(MouseEvent e)
    {

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == battleButton && gp.getHandleScreen().getNum() == 1)
        {
			
            gp.getBattleScreen().setType(1);
            frame.setContentPane(gp.getBattleScreen());
        }
        if(e.getSource() == battleButton && gp.getHandleScreen().getNum() == 2)
        {
			Music.stopBuildMusic();
			Music.playFightMusic();
            gp.getBattleScreen().setType(2);
            frame.setContentPane(gp.getBattleScreen());
        }
        if(e.getSource() == battleButton && gp.getHandleScreen().getNum() ==3)
        {
			Music.stopBuildMusic();
			Music.playFightMusic();
            gp.getBattleScreen().setType(3);
            frame.setContentPane(gp.getBattleScreen());
        }
    }

    public int getNum()
    {
        return num;
    }
    public void setNum(int newNum)
    {
        this.num = newNum;
    }
    public void keyTyped(KeyEvent e) 
    {

    }
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && readyToGo == true)
        {
            Music.stopBuildMusic();
			Music.playFightMusic();
            System.out.println("durability: " + gp.getDurability());
            frame.setContentPane(gp.getBattleScreen());
        }
    }
    public void keyReleased(KeyEvent e) 
    {

    }
}
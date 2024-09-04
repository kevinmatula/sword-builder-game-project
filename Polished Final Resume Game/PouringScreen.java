import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//Max Socre That Can Be Obtained
//Copper: 30
//Iron: 45
//Diamond: 60
public class PouringScreen extends JPanel implements ActionListener, KeyListener, MouseListener
{
    JFrame frame;
    JPanel p3;
    GamePanel gp;
    int type;
    Timer time;
    ImageIcon movingImageIcon, moldImage, progressBarImage, bucketImage, movingBallImageIcon, copper1, copper2, copper3, iron1, iron2, iron3, diam1, diam2, diam3, pourBuck, imageTip, finishTip;
    JLabel movingImage, mold, bucket, progressBar, movingBall, tip, finalTip, durability;
    movingBar mb;
    int currentCreationStage;
    int movingBarState, swordDurability;
    JButton moveOn;
    Rectangle leftPink, leftOrange, leftBaige, green, rightBaige, rightOrange, rightPink, circle;
    Toolkit tk;
    
    public PouringScreen(JFrame frame, JPanel p3, GamePanel gp, int type)
    {
        this.frame = frame;
        this.p3 = p3;
        this.gp = gp;
        this.type = type;
        //this.type = type;
        tk = Toolkit.getDefaultToolkit();
        p3.setBounds(0, 0, 1920, 1080);
        //
        movingBarState = 0;
        //
        imageTip = new ImageIcon(tk.getImage("spaceTip.png").
        getScaledInstance(1430, 197, Image.SCALE_DEFAULT));
        finishTip = new ImageIcon(tk.getImage("finishTip.png").
        getScaledInstance(1430, 197, Image.SCALE_DEFAULT));
        //
        time = new Timer(16, this);
        //
        swordDurability = 0;
        //
        copper1 = new ImageIcon(tk.getImage("copper1.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        copper2 = new ImageIcon(tk.getImage("copper2.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        copper3 = new ImageIcon(tk.getImage("copper3.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));

        iron1 = new ImageIcon(tk.getImage("steel1.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        iron2 = new ImageIcon(tk.getImage("steel2.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        iron3 = new ImageIcon(tk.getImage("steel3.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));

        diam1 = new ImageIcon(tk.getImage("diam1.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        diam2 = new ImageIcon(tk.getImage("diam2.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        diam3 = new ImageIcon(tk.getImage("diam3.png").getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));

        bucketImage = new ImageIcon(tk.getImage("bucket.png").getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        pourBuck = new ImageIcon(tk.getImage("Pouring.gif").getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        //
        
        setLayout(null);
        movingImageIcon = new ImageIcon("moveBar.png");
        movingImage = new JLabel(movingImageIcon);
        tip = new JLabel(imageTip);
        finalTip = new JLabel(finishTip);
        finalTip.setBounds(530, 880, 1430, 197);
        tip.setBounds(830, 10, 1430, 197);
        finalTip.setVisible(false);
        movingBallImageIcon = new ImageIcon("Ball.png");
        movingBall = new JLabel(movingBallImageIcon);
        //ACTUAL PLACEMENT: movingImage.setBounds(1200, 880, 400, 225);
        //TEMP PLACEMENT:
        movingImage.setBounds(198, 850, 400, 225);
        mb = new movingBar();
        
        //RECTANGLE DECLERATION
        leftPink = new Rectangle(198, 850, 49, 223);
        leftOrange = new Rectangle(248, 850, 49, 223);
        leftBaige = new Rectangle(298, 850, 52, 223);
        green = new Rectangle(351, 850, 89, 223);
        rightBaige = new Rectangle(441, 850, 58, 223);
        rightOrange = new Rectangle(500, 850, 51, 223);
        rightPink = new Rectangle(552, 850, 49, 223);
        circle = new Rectangle(mb.getX(), mb.getY(), 50, 50);
        
        
        
        moldImage = new ImageIcon("blankMold.png");
        //progressBarImage = new ImageIcon();
        //bucketImage = new ImageIcon();

        mold = new JLabel(moldImage);
        mold.setBounds(0,0, 1920, 1080);//change later

        bucket = new JLabel(bucketImage);
        bucket.setBounds(1000, 200, 300, 300);

        progressBar = new JLabel(progressBarImage );
        //progressBar.setBounds(100,100);//change later

        //add(mold);
        add(finalTip);
        add(tip);
        add(bucket);
        add(progressBar);
        add(movingBall);
        add(movingImage);
        add(mold);
        
        addMouseListener(this);
        frame.addKeyListener(this);

        //add(p3, BorderLayout.CENTER)
        time.start();
    }
    
    public void keyPressed(KeyEvent e)
    {
       if(e.getKeyCode() == KeyEvent.VK_SPACE)
       {
            int x = mb.getX();
            System.out.println("help");
            
           if(frame.getContentPane() == gp.getPouringScreen())
           {
               //conpare the x of the mb to the x of the parts of the bar
               //we will repeat this process for every section of the bar
               //score will depend on where it is
               System.out.println("help");
               
              if(frame.getContentPane() == gp.getPouringScreen())
              {
                  //conpare the x of the mb to the x of the parts of the bar
                  //we will repeat this process for every section of the bar
                  //score will depend on where it is
                   if(frame.getContentPane() == gp.getPouringScreen() && gp.getPouringScreen().getType() == 1)
                   {
                       //rectangle intersect code
                       if(mold.getIcon() == moldImage)
                       {
                           bucket.setIcon(pourBuck);
                           mold.setIcon(copper1); 
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 24;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 24;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(9);
                           System.out.println("1");
                       }
                       else if(mold.getIcon() == copper1)
                       {
                           mold.setIcon(copper2);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 24;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 30;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 24;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 5;
                               System.out.println("yo");
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(12);
                           System.out.println("2");
                       }
                       else if(mold.getIcon() == copper2)
                       {
                           mold.setIcon(copper3);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 16;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 24;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 40;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 24;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 16;
                           }
                           else
                           {
                               swordDurability += 8;
                           }
                           System.out.println(swordDurability);
                           System.out.println("poop");
                           movingImage.setVisible(false);
                           movingBall.setVisible(false);
                           bucket.setIcon(bucketImage);
                           bucket.setBounds(180, 800, 300, 300);
                           tip.setVisible(false);
                           finalTip.setVisible(true);
                       }
                       else if(mold.getIcon() == copper3)
                       {
                            gp.getHandleScreen().setNum(1);
                            gp.addDurability(swordDurability);
                            frame.setContentPane(gp.getHandleScreen());
                            
                       }
                       }
                   
                   //copy the code youre writing into the main
                   //thats where i was coding
                   //you can copy over my code for the moving bar
                   
                   else if(frame.getContentPane() == gp.getPouringScreen() && gp.getPouringScreen().getType() == 2)
                   {
                       if(mold.getIcon() == moldImage)
                       {
                           bucket.setIcon(pourBuck);
                           mold.setIcon(iron1); 
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 36;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(12);
                           System.out.println("1");
                       }
                       else if(mold.getIcon() == iron1)
                       {
                           mold.setIcon(iron2);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 30;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 36;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 30;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                               System.out.println("yo");
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(15);
                           System.out.println("2");
                       }
                       else if(mold.getIcon() == iron2)
                       {
                           mold.setIcon(iron3);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 36;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 30;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                           }
                           else
                           {
                               swordDurability += 8;
                           }
                           System.out.println(swordDurability);
                           System.out.println("3");
                           movingImage.setVisible(false);
                           movingBall.setVisible(false);
                           bucket.setIcon(bucketImage);
                           bucket.setBounds(180, 800, 300, 300);
                           tip.setVisible(false);
                           finalTip.setVisible(true);
                       }
                       else if(mold.getIcon() == iron3)
                       {
                            gp.getHandleScreen().setNum(2);
                            gp.addDurability(swordDurability);
                            frame.setContentPane(gp.getHandleScreen());
                       }
                       }
                       else if(frame.getContentPane() == gp.getPouringScreen() && gp.getPouringScreen().getType() == 3)
                       {
                           if(mold.getIcon() == moldImage)
                       {
                           bucket.setIcon(pourBuck);
                           mold.setIcon(diam1); 
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 34;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 40;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 34;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(14);
                           System.out.println("1");
                       }
                       else if(mold.getIcon() == diam1)
                       {
                           mold.setIcon(diam2);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 34;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 40;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 34;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                               System.out.println("yo");
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                               System.out.println("yo");
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           mb.setVelocity(17);
                           System.out.println("2");
                       }
                       else if(mold.getIcon() == diam2)
                       {
                           mold.setIcon(diam3);
                           if(circle.intersects(leftPink))
                           {
                               swordDurability += 10;
                           }
                           else if(circle.intersects(leftOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(leftBaige))
                           {
                               swordDurability += 34;
                           }
                           else if(circle.intersects(green))
                           {
                               swordDurability += 40;
                           }
                           else if(circle.intersects(rightBaige))
                           {
                               swordDurability += 34;
                           }
                           else if(circle.intersects(rightOrange))
                           {
                               swordDurability += 20;
                           }
                           else if(circle.intersects(rightPink))
                           {
                               swordDurability += 10;
                           }
                           else
                           {
                               swordDurability += 5;
                           }
                           System.out.println("Sword Durability: " + swordDurability);
                           System.out.println("3");
                           System.out.println("speed: " + mb.getVelocity());
                           movingImage.setVisible(false);
                           movingBall.setVisible(false);
                           bucket.setIcon(bucketImage);
                           bucket.setBounds(180, 800, 300, 300);
                           tip.setVisible(false);
                           finalTip.setVisible(true);
                       }
                       else if(mold.getIcon() == diam3)
                       {
                            gp.getHandleScreen().setNum(3);
                            gp.addDurability(swordDurability);
                            frame.setContentPane(gp.getHandleScreen());
                       }
                    }
                    }
                }
            }
        }
                
       






    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void actionPerformed(ActionEvent e)
    {
        if(mb.getX() >= 554 || mb.getX() <= 198)
        {
            mb.flipX();
        }
        if(mb.getX() > 572 || mb.getX() < 180)
        {
            mb.setX((int) (Math.random() * 356) + 198);
        }
        movingBall.setBounds(mb.getX(), mb.getY(), 50, 50);
        circle.setLocation(mb.getX(), mb.getY());
        

    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println("X: " + e.getX());
        System.out.println("Y: " + e.getY());
    }
    public void mouseReleased(MouseEvent e)
    {

    }
    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        mb.move();
    }

    public int getType()
    {
        return type;
    }
    public void setType(int newType)
    {
        type = newType;
    }

}
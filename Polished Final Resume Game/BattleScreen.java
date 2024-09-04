import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//Max score/durability
//copper: 50
//iron: 75
//diamond: 100
public class BattleScreen extends JPanel implements ActionListener, KeyListener, MouseListener
{
    JFrame frame;
    JPanel battle;
    GamePanel gp;
    Image image, walkRight, baseAttackImage, background, walkLeft, baseImage;
    Sprite hero;
    Toolkit tk;
    JLabel totalScore, strength;
    SpriteManager sm;
    JLabel backgroundLabel, durability, health, starterMessage, wasd, starterMessage2;
    Weapon sword;
    Rectangle heroRec, enemyRec, rec;
    ArrayList<Weapon> weapons;
    ArrayList<Sprite> sprites;
    ArrayList<Enemies> enemies;
    int score, starterMessageScore;
    int type, swordDurability, healthAmount, enemyAmount;
    private int[] cells;
    Timer time;

    public BattleScreen(JFrame frame, JPanel battle, GamePanel gp, int type)
    {
        this.frame = frame;
        this.battle = battle;
        this.gp = gp;
        this.type = type;
        healthAmount = 500;
        heroRec = new Rectangle(0, 0, 10, 10);
        enemyRec = new Rectangle(0, 0, 10, 10);
        strength = new JLabel("Durability Left: " + gp.getDurability());
        health = new JLabel("Health Left: " + healthAmount);
        totalScore = new JLabel("SCORE: " + score);
        starterMessage = new JLabel("Click your mouse to eliminate enemies!");
        starterMessage2 = new JLabel("Your attack range is larger than your enemies' range!");
        wasd = new JLabel("Use W-A-S-D to Control your Knight!");
        wasd.setBounds(50, 25, 700, 50);
        starterMessage.setBounds(50, 75, 700, 50);
        starterMessage2.setBounds(50, 125, 1000, 50);
        health.setBounds(600, 1000, 315, 100);
        strength.setBounds(915, 1000, 400, 100);
        totalScore.setBounds(815, -40, 400, 200);
        time = new Timer(16, this);
        enemyAmount = 5;
        tk = Toolkit.getDefaultToolkit();
        //sword = new Weapon();
        sprites = new ArrayList<Sprite>();
        weapons = new ArrayList<Weapon>();
        enemies = new ArrayList<Enemies>();
        sm = new SpriteManager(sprites, weapons, enemies);
        image = tk.getImage("KnightRight.png");
        background = tk.getImage("battleBackground.png");
        //can you finish gif so there is no blank space
        walkRight = tk.getImage("KnightRight.gif");
        walkLeft = tk.getImage("KnightLeft.gif");
        baseImage = tk.getImage("KnightRight.png");
        baseAttackImage = tk.getImage("SwordRightSwing.gif");
        swordDurability = gp.getDurability();
        strength.setFont(new Font("Monospaced", Font.PLAIN, 32));
        strength.setForeground(Color.BLUE);
        health.setFont(new Font("Monospaced", Font.PLAIN, 32));
        health.setForeground(Color.RED);
        totalScore.setFont(new Font("Monospaced", Font.PLAIN, 56));
        totalScore.setForeground(Color.GREEN);
        starterMessage.setFont(new Font("Monospaced", Font.PLAIN, 25));
        starterMessage.setForeground(Color.BLACK);
        wasd.setFont(new Font("Monospaced", Font.PLAIN, 25));
        wasd.setForeground(Color.BLACK);
        starterMessage2.setFont(new Font("Monospaced", Font.PLAIN, 25));
        totalScore.setForeground(Color.BLACK);


        setLayout(null);
        //backgroundLabel = new JLabel(background);
        //backgroundLabel.setBounds(0, 0, 1920, 1080);
        
        hero = new Sprite((int) (Math.random() * 1000) + 10, (int) (Math.random() * 800) + 10, image, rec, 20, 100);
        
        
        sm.generate(enemies, enemyAmount);
        sm.addSprite(hero);
        rec = new Rectangle(hero.getX(), hero.getY(), 90, 112);
        

        //add(background);
        add(starterMessage2);
        add(wasd);
        add(starterMessage);
        add(strength);
        add(health);
        add(totalScore);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        time.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        strength.setText("Durability Left: " + gp.getDurability());
        heroRec.setBounds(hero.getX(), hero.getY(), 90, 112);
        for(int i = 0; i < enemies.size(); i++)
        {
            enemyRec.setBounds(enemies.get(i).getX(), enemies.get(i).getY(), 90, 112);
            if(enemyRec.intersects(heroRec))
            {
                healthAmount--;
            }
        
        }
        health.setText("Health Left: " + healthAmount);
        if(healthAmount <= 0)
        {
            Music.stopFightMusic();
			Music.playDeathMusic();
            gp.setScore(score);
            frame.setContentPane(gp.getDeathScreen());
        }
        repaint();
    }

    public void keyPressed(KeyEvent e)
    {
        //when I hold down it doesnt go
        //if(frame.getContentPane() == gp.getBattleScreen())
        //{
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                hero.setImage(walkRight);
                hero.moveUp();
                baseImage = tk.getImage("KnightRight.png");
                baseAttackImage = tk.getImage("SwordRightSwing.gif");
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                hero.setImage(walkLeft);
                hero.moveDown();
                baseImage = tk.getImage("KnightLeft.png");
                baseAttackImage = tk.getImage("SwordLeftSwing.gif");
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                hero.setImage(walkRight);
                hero.moveRight();
                baseImage = tk.getImage("KnightRight.png");
                baseAttackImage = tk.getImage("SwordRightSwing.gif");
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                hero.setImage(walkLeft);
                hero.moveLeft();
                baseImage = tk.getImage("KnightLeft.png");
                baseAttackImage = tk.getImage("SwordLeftSwing.gif");
            }

    }

    public void keyReleased(KeyEvent e)
    {
        hero.setImage(baseImage); 
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        
		if(frame.getContentPane() == gp.getBattleScreen() && gp.getDurability() > 0)
		{
            gp.addDurability(-1);
		    hero.setImage(baseAttackImage);
        
            heroRec.setBounds(hero.getX() - 8, hero.getY() - 8, 110, 132);
            for(int i = 0; i < enemies.size(); i++)
            {
                enemyRec.setBounds(enemies.get(i).getX(), enemies.get(i).getY(), 90, 112);
                if(heroRec.intersects(enemyRec))
                {
                    enemies.remove(i);
                    score++;
                    starterMessageScore++;
                }
            }
        }
        if(enemies.size() == 0)
        {
            enemyAmount *= 2;
            sm.generate(enemies, enemyAmount);
        }
        if(starterMessageScore > 3)
        {
            starterMessage.setVisible(false);
            starterMessage2.setVisible(false);
            wasd.setVisible(false);
        }
        totalScore.setText("SCORE: " + score);
    
	}

	public void mouseReleased(MouseEvent e)
	{
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


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        sm.draw(g);
    }

    public void setType(int newType)
    {
        type = newType;
    }
    public int getType()
    {
        return type;
    }

}
//3 AM
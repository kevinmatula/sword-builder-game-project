import java.awt.*;
import java.util.ArrayList;
import java.awt.Toolkit;
//rename this SpriteManager
//rename class name and file name to match
//rectangle is already a class we will import
public class SpriteManager
{
   ArrayList<Sprite> sprites = new ArrayList<Sprite>();
   ArrayList<Weapon> weapons = new ArrayList<Weapon>();
   ArrayList<Enemies> enemies = new ArrayList<Enemies>();
   int locationX, locationY, velocity, damage;
   int hP = 20;
   Image enemyImage, enemyBaseImage;
   int max = 15;
   int min = 5;
   int range = (max - min) + 1;
   Rectangle enemyRec;
   Toolkit tk;

    //this class should manage all the different Sprites: weapons, enemies, hero
    public SpriteManager(ArrayList<Sprite> sprites, ArrayList<Weapon> weapons, ArrayList<Enemies> enemies )
    {
		tk = Toolkit.getDefaultToolkit();
		enemyImage = tk.getImage("enemyRight.png");
        enemyBaseImage = tk.getImage("enemyRight.png");
        this.sprites = sprites;
        this.weapons = weapons;
        this.enemies = enemies;

    }



    public void addSprite(Sprite sprite)
    {
        sprites.add(sprite);
    }

    public void addWeapon(Weapon weapon)
    {
        weapons.add(weapon);
    }

    public void addEnemy(Enemies enemy)
    {
        enemies.add(enemy);
    }

    public void setEnemyImage(String imageName)
    {
        enemyImage = tk.getImage(imageName);
    }

    public void setEnemyBaseImage(String imageName)
    {
        enemyBaseImage = tk.getImage(imageName);
    }


    public void generate(ArrayList<Enemies> enemies, int numToGen)
    {
        int x = 1800;
        int y = 540;
        this.enemies = enemies;
        
        for(int i = 0; i <= numToGen; i++)
        {
            Enemies newEnemy = new Enemies((int) (Math.random() * 1400) + 10, (int) (Math.random() * 800) + 10, enemyImage, enemyRec, (int) (Math.random() * 6) + 1, hP);
            enemies.add(newEnemy);
        }
    }

    public void draw(Graphics g)
    {
        //This will loop through the arraylists and call each sprites draw method
        for(int i = 0; i < sprites.size(); i++)
        {
            sprites.get(i).draw(g);
        }

        for(int i = 0; i<weapons.size(); i++)
        {
            weapons.get(i).draw(g);
        }
        for(int i = 0; i < enemies.size(); i++)
        {
            enemies.get(i).follow(sprites.get(0).getX(), sprites.get(0).getY());
            enemies.get(i).draw(g);
        }
        

    }

}
import java.awt.*;
//import java.ImageIcon.*;

//every hit the weapon gives will lower health(when 0 it breaks(game over))
public class Weapon
{
    private String type; //what weapon the player chose
    private int damage; //the damage output of the sword
    private int durability; //the durability of the weapon determined by the score, higher score=higher health etc.
    private Image image;
    Rectangle r;
    public Weapon(String type, int damage, int durability, Image image, Rectangle r)
    {
       this.type = type;
       this.damage = damage;
       this.durability = durability;
       this.image = image;
       this.r = r;
    }

    public String getType()
    {
        return type;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getDurability()
    {
        return durability;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image i)
    {
        image = i;
    }

    public Rectangle getR()
    {
        return r;
    }

    public void useWeapon()
    {
        if(durability > 0)
        {
            durability --;
        }
        else
        {
            System.out.println("Your Weapon broke");
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
        //put the x and y at zero but the weapons will have a set location
    }
}
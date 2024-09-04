import java.awt.*;
public class Sprite
{
    //this should have getters and setters
    //should be the basis of all of our different character/liquids/enemies/weapons
    //collision will use the rectangles methods
    //Should have movement methods
    //should have coordinates, image, rectangle, velocity

    //Dont do the arraylist in constructors, too complicated
    int x, y, velocity, hp;
    Image i;
    Rectangle r;

    public Sprite(int x, int y, Image i, Rectangle r, int velocity, int hp)
    {
        this.x = x;
        this.y = y;
        this.i = i;
        this.r = r;
        this.velocity = velocity;
        this.hp = hp;

    }

    //would make move methods for all directions
    //dont extend JPanel or action listener here
    public void moveDown()
    {
       y += velocity;
    }

    public void moveUp()
    {
        y -= velocity;
    }

    public void moveRight()
    {
        x += velocity;
    }

    public void moveLeft()
    {
        x -= velocity;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setImage(Image newImage)
    {
        i = newImage;
    }

    public Image getImage()
    {
        return i;
    }

        public int getHP()
	    {
	        return hp;
	    }
    public void setRect(int x, int y, int width, int height)
    {
        r.setBounds(x, y, width, height);
    }

	public Rectangle getR()
	{
	        return r;
    }
    public void draw(Graphics g)
    {
        //this method will draw each sprite
        g.drawImage(i, x, y, null);
    }
}

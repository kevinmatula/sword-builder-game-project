import java.awt.*;

public class Enemies extends Sprite
{
    int x, y, velocity, status;
    Rectangle r;
    Image i;
    Image enemyRight, enemyLeft, enemyDown, enemyUp;
    Toolkit tk;
    //should extend Sprite
    public Enemies(int x, int y, Image i, Rectangle r, int velocity, int status)
    {
        super(x, y, i, r, velocity, status);
        tk = Toolkit.getDefaultToolkit();
        this.x = x;
        this.y = y;
        this.status = status;
        enemyRight = tk.getImage("enemyRight.gif");
        enemyLeft = tk.getImage("enemyLeft.gif");
        enemyUp = tk.getImage("enemyRight.gif");
        enemyDown = tk.getImage("enemyLeft.gif");
    }

    //should have a method that will move the enemies towards the hero/player
    //Hero will not be of the enemies class
    //Should be capable by find the heros coordinates, the enemies coordinates
    //Find the difference between the coordinates and then use

    //Example code
    // x and y are enemies x and y

    public void follow(int heroX, int heroY)
    {
        int diffX = heroX - getX();
        int diffY = heroY - getY();
        int pureDiffX = Math.abs(diffX);
        int pureDiffY = Math.abs(diffY);
        if((pureDiffX >= pureDiffX || pureDiffY == 0))
        {
            if(diffX <= 700 && diffX > 0)
            {
                moveRight();
                setImage(enemyRight);
            }
            else if(diffX >= -700 && diffX < 0)
            {
                moveLeft();
                setImage(enemyLeft);
            }
        }
        if((pureDiffY >= pureDiffX || pureDiffX == 0))
        {
            if(diffY <= 700 && diffY > 0)
            {
                moveDown();
                setImage(enemyDown);
            }
            else if(diffY >= -700 && diffY < 0)
            {
                moveUp();
                setImage(enemyUp);
            }
        }
    }
}



public class movingBar
{
    private int xVar, yVar, size, velocity;

    public movingBar()
    {
        xVar = 198;
        yVar = 910;
        size = 50;
        velocity = 10;
    }

    public void move()
    {
        xVar += velocity;
    }

    public int getX()
    {
        return xVar;
    }

    public void setX(int x)
    {
        xVar = x;
    }

    public void setY(int y)
    {
        yVar = y;
    }

    public int getY()
    {
        return yVar;
    }

    public void setVelocity(int velocity)
    {
        this.velocity = velocity;
    }

    public int getVelocity()
    {
        return velocity;
    }

    public void flipX()
    {
        velocity *= -1;
    }
}
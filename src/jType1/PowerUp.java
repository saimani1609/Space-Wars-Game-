package jType1;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
/**
* PowerUp class implements the SpaceObject interface and defines
basic methods that
* each PowerUp type will have. It provides the abstract method
&lt;code&gt;givePowerUp&lt;/code&gt; that must be
* implemented by all the PowerUp classes that extend this.
*
*
*/
@SuppressWarnings("unused")
public abstract class PowerUp implements SpaceObject
{
@Override
public Rectangle getBounds()
{
return new Rectangle(x, y, width, height);
}

@Override
public void setVisible(boolean v)
{
visible = v;
}

public boolean isVisible()
{
return visible;
}

public abstract void givePowerUp(SpaceShip ship);

protected int x, y;
protected int width, height;
protected int hp;
protected Image image;
protected boolean visible;
protected boolean onScreen;
protected int score; //score for getting a power up
}
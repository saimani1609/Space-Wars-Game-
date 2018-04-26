package jType1;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
/**
* Abstract Space Alien class implements the SpaceObject interface
and defines basic methods that
* each Alien type will have. It provides the abstract method
&lt;code&gt;shoot&lt;/code&gt; that must be
* implements by all the Alien classes that extend this.
*
*
*

*/
@SuppressWarnings("unused")
public abstract class AbstractSpaceAlien implements SpaceObject {
@Override
public void setVisible(boolean v)
{
visible = v;
}

@Override
public boolean isVisible()
{
return visible;
}

@Override
public Rectangle getBounds()
{
return new Rectangle(x, y, width, height);
}

public void setOnScreen(boolean os)
{
onScreen = os;
}

public boolean isOnScreen()
{
return onScreen;
}

public void setHP(int hp)
{

this.hp = hp;
}

public int getHP()
{
return hp;
}

abstract public void shoot();

protected int x, y;
protected int width, height;
protected int hp;
protected Image image;
protected boolean visible;
protected boolean onScreen;
protected int score; //score player received for killing the alien
}
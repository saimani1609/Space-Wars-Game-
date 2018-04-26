package jType1;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
/**
* DangerousObject class implements the SpaceObject interface and
defines basic methods that
* each DangerousObject type will have. It provides the abstract
method &lt;code&gt;getDamage&lt;/code&gt; that must be
* implemented by all the DangerousObject classes that extend this.
*
*
*
*/
@SuppressWarnings("unused")
public abstract class DangerousObject implements SpaceObject
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
@Override
public boolean isVisible()
{
return visible;
}

public abstract int getDamage();
protected int x, y;
protected int width, height;
protected int hp;
protected Image image;
protected boolean visible;
protected boolean onScreen;
protected int damage;
protected int score; //score for getting a power up
}
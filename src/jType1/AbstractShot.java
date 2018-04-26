package jType1;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
* Abstract Shot class that implements the Shot interface and defines
basic methods for the shot.
* All Shots extend this class.
*
*
*
*/
public abstract class AbstractShot implements Shot
{
public AbstractShot(int x, int y)
{
this.x = x;
this.y = y;
visible = true;
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

public int getDamage()
{
return damage;
}

protected int x, y; //Initial coordinates of the shot
protected int speed; //Speed at which the shot will travel
protected int damage; //How much damage the shot does
protected boolean visible;
protected Image image;
protected ImageIcon icon;
}	
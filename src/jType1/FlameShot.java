package jType1;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
/**
* The FlameShot extends AbstractShot and creates a new Shot. The
shot moves across the screen

* from left to right and defines methods that test if the shot hit any
objects.
*
*
*
*/
public class FlameShot extends AbstractShot
{
@SuppressWarnings("unused")
public FlameShot(int x, int y)
{
super(x, y);
speed = 20;
icon = new ImageIcon(this.getClass().getResource("Fireball.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
damage = 10;
int theta = 0;
}

public void draw(Graphics2D g, JTypeSpace space)
{
if(visible)
{
g.drawImage(image, x, y, space);
x += speed;
if(x > space.getWidth())
{
visible = false;
}
}


}

@Override
public Rectangle getBounds()
{
return new Rectangle(x, y, width, height);
}

public int getX()
{
return x;
}

public int getY()
{
return y;
}

protected int width, height;
}
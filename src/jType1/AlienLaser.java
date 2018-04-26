package jType1;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
/**
* This class extends AbstractShot and draws a laser to the screen that
is shot from an alien.
*
*
*
*/
public class AlienLaser extends AbstractShot
{

public AlienLaser(int x, int y)
{
super(x, y);
speed = 20;
damage = 7;
icon = new ImageIcon(this.getClass().getResource("Laser.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
visible = true;
}

@Override
public void draw(Graphics2D g, JTypeSpace space)
{
if(visible)
{
g.drawImage(image, x, y, space);
x -= speed;
if(x < 0)
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

protected int width, height;
}
package jType1;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
* SpaceMine extends DangerousObject and the SpaceMine image to
the screen. The class contains
* methods to help check if the mine has collided with the player.
*
*
*
*/
@SuppressWarnings("unused")
public class SpaceMine extends DangerousObject
{
public SpaceMine(JTypeSpace space, int x, int y)
{
this.space = space;
this.x = x;
this.y = y;
visible = true;
onScreen = false;
score = 5;
hp = 1;
damage = 10;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("SpaceMine.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
}
@Override
public void move()
{
x -= 4;

}
@Override
public void draw(Graphics2D g)
{
if(visible)
{
g.drawImage(image, x, y, space);
move();
}
}

@Override
public void setOnScreen(boolean os) {
// TODO Auto-generated method stub
}

@Override
public boolean isOnScreen() {
// TODO Auto-generated method stub
return false;
}
@Override
public void receiveDamage(int d)
{
hp -= d;
if(hp <= 0)
{
visible = false;
space.addScore(score);
}

}

public int getDamage()
{
return damage;
}

protected JTypeSpace space;
}
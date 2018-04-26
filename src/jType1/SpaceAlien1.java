package jType1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Extends the AbstractSpaceAlien to create a space alien. The alien
will move up and down the screen

* while slowly moving forward. How often it shoots is defined in the
constructor by the <code&gt;shootVar</code&gt;.
*
*
*
*/
@SuppressWarnings("unused")
public class SpaceAlien1 extends AbstractSpaceAlien
{
public SpaceAlien1(JTypeSpace space, int x, int y)
{
this.x = initialX = x;
this.y = initialY = y;
this.space = space;
visible = true;
onScreen = false;
score = 5;
hp = 1;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneA.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
shootVar = 1;

Dimension d = space.getSize();
if(initialY < (d.height / 2)) //top half of screen
{
direction = 5;
}
else //in lower half of screen
{
direction = -5;
}

}

@Override
public void move()
{
Dimension d = space.getSize();
if(direction > 0) //moving down
{
y += direction;
x -= 3;
if(y >= (d.height - 20))
{
direction *= -1;
}
}
else //moving up
{
y += direction;
x += 1;
if(y < (20))
{
direction *= -1;
}
}
}

@Override
public void shoot()
{
space.addAlienShot(new AlienShot(x, y + (height / 2)));
}

@Override

public void draw(Graphics2D g)
{
if(visible)
{
g.drawImage(image, x, y, space);
move();
shootVar++;
if(shootVar == 40)
{
shoot();
shootVar = 1;
}
}
}

public void receiveDamage(int d)
{
hp -= d;
if(hp <= 0)
{
visible = false;
space.addScore(score);
}
}

protected int initialY, initialX;
protected int direction;
protected JTypeSpace space;
protected int shootVar; //controls how often the alien will shoot it's gun
}
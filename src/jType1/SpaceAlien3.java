package jType1;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
/**
* Extends the AbstractSpaceAlien to create a space alien. The alien
will only move so far to the left
* but will move up or down to be in line with the space ship. The
alien shoots less often than the
* other aliens but will blink as it shoots.
*
*
*
*/
public class SpaceAlien3 extends AbstractSpaceAlien
{
public SpaceAlien3(JTypeSpace space, int x, int y)
{

this.x = x;
this.y = y;
this.space = space;
visible = true;
onScreen = false;
score = 20;
hp = 5;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneC.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
shootInc = 100;
shootVar = 0;
}

@Override
public void move()
{
Dimension d = space.getSize();
int sy = space.getShip().getY();
if(x > (d.width * (.75)))
{
x -= 2;
}
if(sy > y)
{
y += 6;
}
else
{
y -= 6;
}

}

@Override
public void shoot()
{
space.addAlienShot(new AlienLaser(x, y + (height / 2)));
}
@Override
public void draw(Graphics2D g)
{
if(visible)
{
g.drawImage(image, x, y, space);
move();
if(shootVar == 0)
{
shoot();
shootVar++;
}
else if(shootVar > 0 && shootVar < 10)
{
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneC1.png"));
image = icon.getImage();
shootVar++;
}
}
else if(shootVar >= 10 && shootVar < 20)
{
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneC2.png"));
image = icon.getImage();
shootVar++;

}
else if(shootVar >= 20 && shootVar < 30)
{
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneC1.png"));
image = icon.getImage();
shootVar++;
}
else if(shootVar >= 30 && shootVar > 100)
{
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneC.png"));
image = icon.getImage();
shootVar = 0;
}

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

protected JTypeSpace space;
protected int initialY, initialX;
protected int direction;
protected int shootVar;

protected int shootInc; //controls how often the alien will shoot its gun
}
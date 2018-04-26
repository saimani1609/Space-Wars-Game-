package jType1;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
* Extends the AbstractSpaceAlien to create a space alien. The alien
will move up and down the screen
* while slowly moving forward. How often it shoots is defined in the
constructor by the &lt;code&gt;shootVar&lt;/code&gt;.
* It is basically the same as SpaceAlien1 except that is shoots more
often and has more life.
*
*
*/
public class SpaceAlien2 extends AbstractSpaceAlien
{
public SpaceAlien2(JTypeSpace space, int x, int y)
{
this.x = x;
this.y = y;
this.space = space;
visible = true;
onScreen = false;
score = 10;
hp = 2;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("LevelOneB.png"));
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
if(shootVar == 38)
{
shoot();
shootVar = 1;
}
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
protected int shootVar; //controls how often the alien will shoot its gun
}
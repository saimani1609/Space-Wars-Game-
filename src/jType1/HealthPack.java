package jType1;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
* This class extends PowerUp and provides a way for the player to
gain health points if it
* collides with the image this class draws to the screen.
*
*
*
*/
public class HealthPack extends PowerUp
{
public HealthPack(JTypeSpace space, int x, int y)
{
this.space = space;
this.x = x;
this.y = y;
visible = true;
onScreen = false;
score = 10;
hp = 1;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("HealthPack.png"));
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
public void setOnScreen(boolean os)
{
// TODO Auto-generated method stub
}
@Override
public boolean isOnScreen()
{
// TODO Auto-generated method stub
return false;
}
@Override
public void receiveDamage(int d) {} //do not need to implement for this class
/**
* This method is used to increase the ship&#39;s health. The health pack
will
* increase the ship&#39;s health by 50 with the maximum health being
100.
*

* @param SpaceShip - the ship receiving the health
*/
public void givePowerUp(SpaceShip ship)
{
int shipHP = ship.getHP();
shipHP += 50;
if(shipHP > 100)
{
shipHP = 100;
}
ship.setHP(shipHP);
}

protected JTypeSpace space;
}
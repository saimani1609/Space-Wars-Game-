package jType1;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
/**
* This class extends PowerUp and provides a way for the ship to
acquire a new weapon.

* If the ship collides with the image produced by this class it will
either gain an
* additional weapon or receive additional ammo.
*
*
*
*/
public class FlamePack extends PowerUp
{
public FlamePack(JTypeSpace space, int x, int y)
{
this.space = space;
this.x = x;
this.y = y;
visible = true;
onScreen = false;
score = 10;
hp = 1;
ImageIcon icon = new
ImageIcon(this.getClass().getResource("FireballPack.png"));
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
public void setOnScreen(boolean os) {}

@Override
public boolean isOnScreen() {return false;}
@Override
public void receiveDamage(int d) {}//don&#39;t need to implement here

@Override
public void givePowerUp(SpaceShip ship)
{
ship.addGun(new FlameGun(space, ship, "Flame"));
}
protected JTypeSpace space;
}
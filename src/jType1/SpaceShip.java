package jType1;

import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.ImageIcon;
/**
* This class represents the players space ship. The player controls
the movement
* and shooting of the space ship. The ship has an HP(Hit points)
associated with it
* which determine how much life the player has left. The ship is
represented on screen
* by an image of a ship. The size of this image is used to determine
if the player
* has collided with any items, aliens or shots.
*
*
*
*/
public class SpaceShip
{
/**
* Constructor for the space ship. The &lt;code&gt;space&lt;/code&gt;
parameter is used to
* for determining where to draw the image of the ship.
*
* @param space - where the image of the ship will be drawn
*/
public SpaceShip(JTypeSpace space)
{

this.space = space;
vx = vy = 0;
visible = true;
hp = 100;
initGunKit();

ImageIcon icon = new
ImageIcon(this.getClass().getResource("SpaceShipMed.png"));
image = icon.getImage();
width = image.getWidth(null);
height = image.getHeight(null);
}

/**
* This method draws the ship and all of it&#39;s gun shots onto the
associated
* &lt;code&gt;space&lt;/code&gt;. Only visible shots are drawn to the screen.
If a shot
* is no longer visible it will be removed from the
&lt;code&gt;shots&lt;/code&gt; List.
*
* @param g - Graphics2D object used to draw to space
*/
public void draw(Graphics2D g)
{
//paint ship to space
g.drawImage(image, x, y, space);
x += (vx * tx);
y += (vy * ty);

Shot s;
//paint shots to space
for(int i=0; i<shots.size(); i++)

{
s = (Shot) shots.get(i);
if(s.isVisible() == true)
{
s.draw(g, space);
}
else
{
shots.remove(i);
}
}
}

public Image getImage()
{
return image;
}

/**
* Moves the ship up the screen by five. If the player is already
moving in that
* direction then the speed at which they are moving will increase.
*/
public void moveUp()
{
if(vy > 0)
{
ty = 1;
}
else
{
ty++;
}

vy = -5;
}

/**
* Moves the ship down the screen by five. If the player is already
moving in that
* direction then the speed at which they are moving will increase.
*/
public void moveDown()
{
if(vy < 0)
{
ty = 1;
}
else
{
ty++;
}
vy = 5;
}

/**
* Moves the ship left by five. If the player is already moving in that
* direction then the speed at which they are moving will increase.
*/
public void moveLeft()
{
if(vx > 0)
{
tx = 1;
}
else
{

tx++;
}
vx = -5;
}

/**
* Moves the ship right by five. If the player is already moving in
that
* direction then the speed at which they are moving will increase.
*/
public void moveRight()
{
if(vx < 0)
{
tx = 1;
}
else
{
tx++;
}
vx = 5;
}

/**
* This method first determines if the current gun has ammo to shoot
or if the
* gun is a BlasterGun. If the gun has ammo then a new shot is
added to the
* &lt;code&gt;shots&lt;/code&gt; List. If there is no ammo in the gun, the gun
is switched
* to the BlasterGun and then a new shot is created.
*/
public void shoot()

{
//Check if the current gun has ammo and isn't already set to BlasterGun
if(gun.getAmmo() < 1 && !(gun instanceof BlasterGun))
{
gun = gunkit.getGun(0);
}
shots.add(gun.fireGun(x + width, y + (height/2)));
}

/**
* Returns the number of shots in the shots List.
*
* @return - the number of shots in the shots List.
*/
public int getShotsListSize()
{
return shots.size();
}

/**
* Returns the Shot located at position &lt;code&gt;i&lt;/code&gt; of the shots
List.
* If &lt;code&gt;i&lt;/code&gt; doesn&#39;t exist in the List then a
&lt;code&gt;null&lt;/code&gt;
* value is returned.
*
* @param i - the location of the shot to return
* @return the Shot at location i
*/
public Shot getShotAt(int i)
{
if(i>=0 && i<shots.size())

{
return (Shot)shots.get(i);
}
return null;
}

/**
* Removes the Shot at position &lt;code&gt;i&lt;/code&gt; from the shots List.
If
* &lt;code&gt;i&lt;/code&gt; is not in the List then no action is performed.
*
* @param i - location of the Shot to remove
*/
public void removeShotAt(int i)
{
if(i>=0 && i<shots.size())
{
shots.remove(i);
}
}

/**
* Returns a new rectangle that represents the current location and
size of the
* space ship. The Rectangle is used to determine if the space ship
has collided
* with any of the objects on the screen.
*
* @return - a Rectangle representing the size and location of the
ship.
*/
public Rectangle getBounds()
{

return new Rectangle(x, y, width, height);
}

/**
* Returns the amount of ammo the current gun has.
*
* @return - the number of shots a gun has
*/
public int getAmmo()
{
return gun.getAmmo();
}

/**
* Used to set the ship&#39;s current x location.
*
* @param x - the x location for the ship
*/
public void setX(int x)
{
this.x = x;
}

/**
* Returns the current x location of the ship.
*
* @return - the current x location of the ship.
*/
public int getX()
{
return x;
}


/**
* Used to set the ship&#39;s current y location.
*
* @param y - the y location for the ship
*/
public void setY(int y)
{
this.y = y;
}

/**
* Returns the current y location of the ship.
*
* @return - the current y location of the ship.
*/
public int getY()
{
return y;
}

public boolean isVisible()
{
return visible;
}

public void setVisible(boolean visible)
{
this.visible = visible;
}

/**
* Returns the hp for the ship. The hp represent the players health.
*

* @return - the amount of health the player has
*/
public int getHP()
{
return hp;
}

/**
* Set the players hp. The hp represent the players health.
*
* @param hp - the amount of health the player will have
*/
public void setHP(int hp)
{
this.hp = hp;
}

/**
* This method is used to give damage to the ship. The amount
specified
* in the parameter is deducted from the player&#39;s hp. If the hp goes
to
* zero or less than the player loses a lift.
* @param d
*/
public void receiveDamage(int d)
{
hp -= d;
if(hp <= 0)
{
space.RemoveLife();
}
}


/**
* Sets the current gun to the gun specified by the parameter.
*
* @param gun - the gun to be made the gun the ship will use
*/
public void setGun(String gun)
{
if(gun!=null)
{
this.gun = gunkit.setSelectedGun(gun);
}
}

/**
* Returns the number of Guns currently in the GunKit.
*
* @return - the number of Guns in the GunKit
*/
public int getGunKitCount()
{
return gunkit.getGunCount();
}

/**
* Returns the gun found at location &lt;code&gt;i&lt;/code&gt; of the GunKit.
* A &lt;code&gt;null&lt;/null&gt; value is returned if no Gun is found at that
* location.
*
* @param i - int location of the Gun
* @return Gun at that location
*/
public Gun getGunAt(int i)

{
return gunkit.getGun(i);
}

/**
* Attempts to add a new Gun to the GunKit. If the ship already has
the Gun
* then the player received 30 additional pieces of ammo for that
Gun. If it
* is a Gun the player does not already have then the Gun is added to
the GunKit
* and a new Button with the name of the Gun is added to the
player&#39;s tool bar.
*
* @param newGun - Gun to be added to the ship&#39;s GunKit
*/
public void addGun(Gun newGun)
{
if(newGun != null)
{
Gun g = gunkit.findGun(newGun.getName());
if(g == null)
{
//add the new gun to the gunkit
gunkit.addGun(newGun);
space.addGun();
}
else
{
//gun already exists in the gunkit - add ammo to it
g.addAmmo(30);
}
}

}

/**
* Initializes the ship&#39;s GunKit. By default the player is given the
* BlasterGun and the MissileGun. The ship&#39;s current gun is set to
* the BlasterGun.
*/
protected void initGunKit()
{
gunkit = new GunKit();
gunkit.addGun(new BlasterGun(space, this, "Blaster"));
gunkit.addGun(new MissileGun(space, this, "Missile"));
gun = gunkit.getGun(0);
}

protected int hp; //hit points
protected int x, y;
protected int tx, ty;
protected int vx, vy;
protected int width, height;
protected boolean visible;
protected Image image;
protected JTypeSpace space;
protected GunKit gunkit; //Object that holds all the available gun objects
protected Gun gun; //The currently selected gun
protected List shots = new ArrayList();
}
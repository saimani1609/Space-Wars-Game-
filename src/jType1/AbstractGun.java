package jType1;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
* Abstract Gun class that implements the Gun interface and defines
basic methods. All Guns extend this class.
*
*
*
*/
@SuppressWarnings("unused")
public abstract class AbstractGun implements Gun
{

public String getName()
{
return name;
}

public int getAmmo()
{
return ammo;
}

public void setAmmo(int ammo)
{
this.ammo = ammo;
}

public void addAmmo(int ammo)
{
this.ammo += ammo;
}

protected AbstractGun(JTypeSpace space, SpaceShip ship, String
name)
{
this.space = space;
this.ship = ship;
this.name = name;
}

protected JTypeSpace space;
protected SpaceShip ship;
protected String name;
protected int damage;
protected int ammo;

}
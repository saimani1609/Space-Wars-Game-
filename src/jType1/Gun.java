package jType1;
/**
* Interface that defines the methods each Gun must implement.
*
*
*
*/
public interface Gun
{
public String getName();
public Shot fireGun(int x, int y);
public int getAmmo();
public void setAmmo(int ammo);
public void addAmmo(int ammo);
}
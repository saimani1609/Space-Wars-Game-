package jType1;
import java.util.ArrayList;
import java.util.List;
/**
* The GunKit object is used to hold the various guns that are
available to the player
* throughout game.
*
*
*
*/
public class GunKit
{
public GunKit()
{ //Nothing to do here
}

/**
* Adds the Gun from the parameter to the GunKit. If the gun is not
a null value
* the location of the Gun in the List is returned. Otherwise -1 is
returned.
*
* @param gun - the &lt;code&gt;Gun&lt;/code&gt; to be added to the
&lt;code&gt;GunKit&lt;/code&gt;
* @return int - the location of gun in the &lt;code&gt;List&lt;/code&gt; or -1 if
gun is &lt;code&gt;null&lt;/code&gt;
*/

public int addGun(Gun gun)
{
if(gun != null)
{
guns.add(gun);
return (guns.size() - 1);
}
return -1;
}

/**
* Removes the &lt;code&gt;Gun&lt;/code&gt; at location &lt;code&gt;i&lt;/code&gt; of
the &lt;code&gt;GunKit&lt;/code&gt;.
*
* @param i - the location of the &lt;code&gt;Gun&lt;/code&gt; to remove
*/
public void removeGun(int i)
{
if(i>=0 && i<guns.size())
{
guns.remove(i);
}
}

/**
* Removes the &lt;code&gt;Gun&lt;/code&gt; that matches the
&lt;code&gt;name&lt;/code&gt; parameter.
*
* @param name - the name of the &lt;code&gt;Gun&lt;/code&gt; to be
removed
*/
public void removeGun(String name)
{

if(name != null)
{
for(int i=0; i<guns.size(); i++)
{
Gun g = (Gun)guns.get(i);
if(name.equals(g.getName()))
{
guns.remove(i);
}
}
}
}

/**
* This returns the number of guns that are currently in the GunKit.
*
* @return the number of guns in the GunKit
*/
public int getGunCount()
{
return guns.size();
}

/**
* This method will look through the list and return the Gun
* at location &lt;code&gt;i&lt;/code&gt; if it is within the bounds of the
* ArrayList. Otherwise &lt;code&gt;null&lt;/code&gt; is returned.
*
* @param i - int location of Gun to return
* @return the Gun at location i
*/
public Gun getGun(int i)
{

if(i>=0 && i<guns.size())
{
return (Gun) guns.get(i);
}
return null;
}

/**
* This method will search the names of the guns in the GunKit for a
gun
* that matches the name given as the parameter. If no Gun is found
then
* a null value is returned.
*
* @param name - the name of the gun to look for
* @return the Gun that matches the name given
*/
public Gun findGun(String name)
{
if(name != null)
{
for(int i=0; i<guns.size(); i++)
{
Gun g = (Gun)guns.get(i);
if(name.equals(g.getName()))
{
return g;
}
}
}

return null;
}


/**
* This will retrieved the gun in the ith location and set it to the
current Gun.
* If the gun does not exist in the GunKit then a &lt;code&gt; null &lt;/code&gt;
value is
* returned. If the gun is found then it is set to the selected gun.
*
* @param i - the location of the gun to be set to the selected gun.
*/
public void setSelectedGun(int i)
{
Gun gun = getGun(i);
if(gun != null)
{
selectedGun = gun;
}
}

/**
* This will find the gun with the give &lt;code&gt; name &lt;/code&gt; in the
GunKit.
* If the gun does not exist in the GunKit then a &lt;code&gt; null &lt;/code&gt;
value is
* returned. If the gun is found then it is set to the selected gun.
*
* @param name - the name of the gun to look for
* @return the currently selected gun
*/
public Gun setSelectedGun(String name)
{
Gun gun = findGun(name);
if(gun != null)

{
selectedGun = gun;
}
return selectedGun;
}

/**
* Set the &lt;code&gt;gun&lt;/code&gt; from the parameter to the selected
&lt;code&gt;Gun&lt;/code&gt;.
*
* @param gun - Gun to be set to the selected Gun
*/
public void setSelectedGun(Gun gun)
{
selectedGun = gun;
}

/**
* Returns the &lt;code&gt;Gun&lt;/code&gt; that is currently the selected
&lt;code&gt;Gun&lt;/code&gt;.
*
* @return the currently selected Gun
*/
public Gun getSelectedGun()
{
return selectedGun;
}
protected List guns = new ArrayList();
protected Gun selectedGun = null;
}


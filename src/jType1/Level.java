package jType1;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
/**
* This class is used to hold the contents of a level in the game. A level is
created
* by setting the maxAliens value, which determines how many aliens will be
on screen
* at once, and then adding different Space Objects to the levelObjects List.
The order
* that they are entered into the list determines the point that they appear in the
game.
*
*
*
*/
public class Level implements Cloneable
{
public Level()
{
maxAliens = 5;
numAliens = 0;
onScreenAliens = 0;
levelComplete = false;
}

public Object clone() throws CloneNotSupportedException
{
return super.clone();
}


/**
* This method is used to add a SpaceAlien to the level. The number of aliens
* the level contains is increased by one.
*
* @param alien - the space alien that is added to the current level
*/
public void addAlien(AbstractSpaceAlien alien)
{
if(alien != null)
{
levelObjects.add(alien);
numAliens++;
}
}

/**
* This method will return the alien object at a certain location.
*
* @param i - the location of the alien object to retrieve
* @return alien - the alien at location i
*/
public SpaceObject getObject(int i)
{
if(i>=0 && i<levelObjects.size())
{
return (SpaceObject)levelObjects.get(i);
}
return null;
}

/**
* This method is used to add a PowerUp to the level.
*
* @param pu - the PowerUp that is added to the level
*/
public void addPowerUp(PowerUp pu)
{

if(pu != null)
{
levelObjects.add(pu);
}
}

/**
* This method is used to add a DangerousObject to the level.
*
* @param danger - the DangerousObject to be added to the level
*/
public void addDangerousObject(DangerousObject danger)
{
if(danger != null)
{
levelObjects.add(danger);
}
}

/**
* This method will draw out all the various objects in the level
* to the screen.
*
* @param g
*/
public void draw(Graphics2D g)
{
onScreenAliens = 0;
//Draws all aliens, power ups and mines/dangerous objects
//Check for aliens left on screen, aliens left in level
if(levelComplete == false)
{
int i = 0;
while(i < levelObjects.size() && onScreenAliens < maxAliens)
{
SpaceObject so = (SpaceObject)levelObjects.get(i);
if(so.isVisible())

{
if(so instanceof AbstractSpaceAlien)
{
so.setOnScreen(true);
onScreenAliens++;
}
so.draw(g);
}
else
{
/*
* If the alien is no longer visible it must have been shot or
* hit by the ship. It should then be removed from the level.
*/
if(so instanceof AbstractSpaceAlien)
{
so.setOnScreen(false);
onScreenAliens-- ;
numAliens-- ;
}
levelObjects.remove(i);
}
i++;
}
if(numAliens == 0) //All aliens have been shot
{
levelComplete = true;
}
}
else
{
g.drawString("LEVEL COMPLETE", 550, 300);
}
}

/**
* This method sets the number of aliens that can appear on screen

* at a given time.
*
* @param max - the maximum number of aliens on screen at once
*/
public void setMaxAliensOnScreen(int max)
{
this.maxAliens = max;
}

public int getMaxAliensOnScreen()
{
return maxAliens;
}

public int getTotalSize()
{
return levelObjects.size();
}

public boolean getLevelComplete()
{
return levelComplete;
}

/**
* Returns the total number of aliens that will appear in this level.
*
* @return int - total number of aliens in the level
*/
public int getSizeOfAliens()
{
return numAliens;
}

public SpaceObject getSpaceObjectAt(int i)
{
return (SpaceObject) levelObjects.get(i);

}

protected int maxAliens; //max number of aliens on screen at once
protected int onScreenAliens; //tracks the number of aliens on the screen
protected int numAliens; //number of aliens in a level
protected boolean levelComplete; //tracks if the level is complete/all aliens are shot
protected List levelObjects = new ArrayList();
}
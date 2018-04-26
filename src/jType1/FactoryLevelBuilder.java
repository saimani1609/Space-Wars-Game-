package jType1;
/**
* This class used used as a factory for creating new levels and adding
* the various space objects in the game.

*
*
*
*/
public class FactoryLevelBuilder implements LevelBuilder
{
public FactoryLevelBuilder(JTypeSpace space)
{
this.space = space;
}

/**
* Adds a space alien to the current level. The type of alien and the initial
* y position are given as parameters. From the type specified the correct
* alien added to the level and if a non-existing type is given the default
* is SpaceALien1.
*
* @param type - String that is the name of alien that is to be added
* @param y - int that sets the initial y values of the alien
*/
public void addEnemy(String type, int y)
{
if(level == null)
{
newLevel();
}
if(type.equals("SpaceAlien3"))
{
level.addAlien(new SpaceAlien3(space, offscreen, y));
}
else if(type.equals("SpaceAlien2"))
{
level.addAlien(new SpaceAlien2(space, offscreen, y));
}
else
{
level.addAlien(new SpaceAlien1(space, offscreen, y));

}
}
/**
* Adds a power up to the current level. The type of power up and the initial
* y position are given as parameters. From the type specified the correct
* power up added to the level and if a non-existing type is given the default
* is a HealthPack.
*
* @param type - String that is the name of Power Up that is to be added
* @param y - int that sets the initial y values of the Power Up
*/
public void addPowerUp(String type, int y)
{
if(level == null)
{
newLevel();
}
if(type.equals("FlamePack"))
{
level.addPowerUp(new FlamePack(space, offscreen, y));
}
else if(type.equals("MissilePack"))
{
level.addPowerUp(new MissilePack(space, offscreen, y));
}
else
{
level.addPowerUp(new HealthPack(space, offscreen, y));
}
}
/**
* Adds a space mine to the current level.
*
* @param type - String that is the name of Dangerous Object that is to be
added

* @param y - int that sets the initial y values of the Dangerous Object
*/
public void addDangerousObject(String type, int y)
{
if(level == null)
{
newLevel();
}

level.addDangerousObject(new SpaceMine(space, offscreen, y));

}

/**
* This sets the maximum number of aliens that will be displayed on screen at
* a single time.
*
* @param max - the maximum number of aliens on screen
*/
public void setMaxAliens(int max)
{
if(level == null)
{
newLevel();
}
level.setMaxAliensOnScreen(max);
}

/**
* This method will create a new level.
*/
public void newLevel()
{
level = new Level();
}

/**

* This method is used to retrieve the level that was created by the
* Factory. If a level hasn&#39;t been created yet a new level will be
* created.
*/
public Level getLevel()
{
if(level == null)
{
level = new Level();
}
return level;
}

protected Level level;
protected int offscreen = 1200;//x values where all objects start
protected JTypeSpace space;
}
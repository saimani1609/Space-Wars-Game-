package jType1;
/**
* The interface that defines how to build a level.
*
*
*
*/
public interface LevelBuilder
{
public void newLevel(); //Creates new space/level
public Level getLevel(); //returns the space/level
public void addEnemy(String type, int y); //add an enemy to a level
public void addPowerUp(String type, int y); //add a power up to a level
public void addDangerousObject(String type, int y); //add a dangerous object to a level
public void setMaxAliens(int max); //sets the max number of aliens on screen at once
}
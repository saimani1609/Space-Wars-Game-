package jType1;
import java.util.ArrayList;
import java.util.List;
/**
* This class is used to create the actual levels in the game. Several methods are
in the class
* that are used to create the different levels in the game. This allows for levels
to be easily
* created in the game.
*
*
*
*/
public class LevelGameBuilder
{
public Level BuildLevelOne(JTypeSpace space)

{
builder = new FactoryLevelBuilder(space);
builder.setMaxAliens(2);
builder.addDangerousObject("SpaceMine", 300);
builder.addEnemy("SpaceAlien1", 100);
builder.addEnemy("SpaceAlien1", 200);
builder.addEnemy("SpaceAlien1", 600);
builder.addEnemy("SpaceAlien1", 100);
builder.addDangerousObject("SpaceMine", 100);
builder.addEnemy("SpaceAlien1", 300);
builder.addPowerUp("HealthPack", 500);
builder.addEnemy("SpaceAlien1", 450);
builder.addEnemy("SpaceAlien1", 100);
builder.addEnemy("SpaceAlien1", 200);
builder.addEnemy("SpaceAlien1", 500);
builder.addDangerousObject("SpaceMine", 600);
return builder.getLevel();
}

public Level BuildLevelTwo(JTypeSpace space)
{
builder = new FactoryLevelBuilder(space);
builder.setMaxAliens(3);
builder.addDangerousObject("SpaceMine", 300);
builder.addEnemy("SpaceAlien1", 100);
builder.addEnemy("SpaceAlien1", 300);
builder.addEnemy("SpaceAlien2", 150);
builder.addEnemy("SpaceAlien2", 500);
builder.addEnemy("SpaceAlien1", 350);
builder.addEnemy("SpaceAlien2", 250);
builder.addPowerUp("HealthPack", 500);
builder.addDangerousObject("SpaceMine", 100);
builder.addEnemy("SpaceAlien1", 170);
builder.addEnemy("SpaceAlien2", 400);
builder.addEnemy("SpaceAlien2", 280);
builder.addEnemy("SpaceAlien2", 100);
builder.addEnemy("SpaceAlien1", 200);

builder.addEnemy("SpaceAlien1", 300);
builder.addDangerousObject("SpaceMine", 400);
builder.addEnemy("SpaceAlien2", 500);
builder.addEnemy("SpaceAlien2", 475);
builder.addEnemy("SpaceAlien2", 100);
builder.addPowerUp("HealthPack", 250);
return builder.getLevel();
}

public Level BuildLevelThree(JTypeSpace space)
{
builder = new FactoryLevelBuilder(space);
builder.setMaxAliens(3);
builder.addEnemy("SpaceAlien1", 100);
builder.addEnemy("SpaceAlien1", 300);
builder.addEnemy("SpaceAlien2", 475);
builder.addEnemy("SpaceAlien3", 200);
builder.addPowerUp("MissilePack", 250);
builder.addDangerousObject("SpaceMine", 400);
builder.addDangerousObject("SpaceMine", 100);
builder.addEnemy("SpaceAlien1", 300);
builder.addEnemy("SpaceAlien1", 100);
builder.addEnemy("SpaceAlien2", 650);
builder.addPowerUp("HealthPack", 450);
builder.addEnemy("SpaceAlien2", 250);
builder.addEnemy("SpaceAlien2", 350);
builder.addEnemy("SpaceAlien2", 450);
builder.addDangerousObject("SpaceMine", 100);
builder.addEnemy("SpaceAlien2", 100);
builder.addEnemy("SpaceAlien2", 50);
builder.addEnemy("SpaceAlien2", 200);
builder.addEnemy("SpaceAlien3", 400);
return builder.getLevel();
}

public Level BuildLevelFour(JTypeSpace space)
{

builder = new FactoryLevelBuilder(space);
builder.setMaxAliens(3);
builder.addPowerUp("FlamePack", 250);
builder.addDangerousObject("SpaceMine", 250);
builder.addEnemy("SpaceAlien2", 475);
builder.addEnemy("SpaceAlien2", 275);
builder.addEnemy("SpaceAlien2", 355);
builder.addEnemy("SpaceAlien3", 575);
builder.addEnemy("SpaceAlien3", 100);
builder.addPowerUp("MissilePack", 550);
builder.addEnemy("SpaceAlien2", 355);
builder.addEnemy("SpaceAlien2", 355);
builder.addDangerousObject("SpaceMine", 250);
builder.addDangerousObject("SpaceMine", 350);
builder.addDangerousObject("SpaceMine", 450);
builder.addEnemy("SpaceAlien3", 600);
builder.addEnemy("SpaceAlien2", 355);
builder.addPowerUp("HealthPack", 550);
builder.addEnemy("SpaceAlien2", 100);
builder.addEnemy("SpaceAlien2", 600);
builder.addEnemy("SpaceAlien2", 650);
builder.addEnemy("SpaceAlien3", 300);
builder.addEnemy("SpaceAlien3", 400);
return builder.getLevel();
}

protected FactoryLevelBuilder builder;
protected JTypeSpace space;

}
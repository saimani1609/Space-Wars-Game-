package jType1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class FactoryLevelBuilderTest {
@BeforeClass
public static void setUpBeforeClass() throws Exception
{
JTypeSpace space = new JTypeSpace(new JType());
builder = new FactoryLevelBuilder(space);
}
@Test
public void testAddEnemy()
{
builder.newLevel();
int i = builder.getLevel().getTotalSize();
builder.addEnemy("SpaceAlien3", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
SpaceAlien3);
i = builder.getLevel().getTotalSize();
builder.addEnemy("SpaceAlien2", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());

assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
SpaceAlien2);
i = builder.getLevel().getTotalSize();
builder.addEnemy("SpaceAlien1", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
SpaceAlien1);
}
@Test
public void testAddPowerUp()
{
builder.newLevel();
int i = builder.getLevel().getTotalSize();
builder.addPowerUp("FlamePack", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
FlamePack);
i = builder.getLevel().getTotalSize();
builder.addPowerUp("MissilePack", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
MissilePack);
i = builder.getLevel().getTotalSize();
builder.addPowerUp("HealthPack", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
HealthPack);
}
@Test
public void testAddDangerousObject()
{

builder.newLevel();
int i = builder.getLevel().getTotalSize();
builder.addDangerousObject("SpaceMine", 400);
assertTrue((i+1) == builder.getLevel().getTotalSize());
assertTrue(builder.getLevel().getSpaceObjectAt(i) instanceof
SpaceMine);
}
@Test
public void testSetMaxAliens()
{
builder.newLevel();
//default value is 5
assertTrue(builder.getLevel().getMaxAliensOnScreen() == 5);
builder.setMaxAliens(10);
assertTrue(builder.getLevel().getMaxAliensOnScreen() == 10);
}

static FactoryLevelBuilder builder;
}
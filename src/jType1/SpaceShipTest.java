package jType1;
import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class SpaceShipTest extends SpaceShip {
public SpaceShipTest()
{

super(space);
}
@BeforeClass
public static void setUpBeforeClass() throws Exception
{
space = new JTypeSpace(new JType());
}
@Before
public void setUp() throws Exception {
}

@Test
public void testMoveUp()
{
vy = 5;
moveUp();
assertTrue(ty == 1);
assertTrue(vy == -5);
moveUp();
assertTrue(ty == 2);
assertTrue(vy == -5);
moveUp();
assertTrue(ty == 3);
assertTrue(vy == -5);
}
@Test
public void testMoveDown()
{
vy = -5;
moveDown();

assertTrue(ty == 1);
assertTrue(vy == 5);
moveDown();
assertTrue(ty == 2);
assertTrue(vy == 5);
moveDown();
assertTrue(ty == 3);
assertTrue(vy == 5);
}
@Test
public void testMoveLeft()
{
vx = 5;
moveLeft();
assertTrue(tx == 1);
assertTrue(vx == -5);
moveLeft();
assertTrue(tx == 2);
assertTrue(vx == -5);
moveLeft();
assertTrue(tx == 3);
assertTrue(vx == -5);
}

@Test
public void testMoveRight()
{
vx = -5;
moveRight();
assertTrue(tx == 1);
assertTrue(vx == 5);
moveRight();

assertTrue(tx == 2);
assertTrue(vx == 5);
moveRight();
assertTrue(tx == 3);
assertTrue(vx == 5);
}

@Test
public void testShoot()
{
assertTrue(shots.size() == 0);
this.gun = new BlasterGun(space, this, "Blaster");
shoot();
Shot s = (Shot) shots.get(0);
assertTrue(s instanceof BlasterShot);
assertTrue(shots.size() == 1);
this.gun = new MissileGun(space, this, "Missile");
shoot();
s = (Shot) shots.get(1);
assertTrue(s instanceof MissileShot);
assertTrue(shots.size() == 2);
gun.setAmmo(0);
shoot();
assertTrue(shots.size() == 3);
s = (Shot) shots.get(2);
assertTrue(s instanceof BlasterShot);
}
@Test
public void testGetShotsListSize()
{
assertTrue(getShotsListSize() == 0);
this.gun = new BlasterGun(space, this, "Blaster");

shoot();
assertTrue(getShotsListSize() == 1);
shoot();
shoot();
assertTrue(getShotsListSize() == 3);
shots.remove(0);
assertTrue(getShotsListSize() == 2);
}
@Test
public void testGetShotAt()
{
this.gun = new BlasterGun(space, this, "Blaster");
shoot();
shoot();
this.gun = new MissileGun(space, this, "Missile");
shoot();
Shot s = getShotAt(2);
assertTrue(s instanceof MissileShot);
s = getShotAt(0);
assertTrue(s instanceof BlasterShot);
s = getShotAt(4);
assertNull(s);
}

@Test
public void testRemoveShotAt()
{
this.gun = new BlasterGun(space, this, "Blaster");
shoot();
shoot();
shoot();
this.gun = new MissileGun(space, this, "Missile");

shoot();
int i = shots.size();
assertTrue(shots.get(2) instanceof BlasterShot);
removeShotAt(2);
assertTrue((i-1) == shots.size());
assertTrue(shots.get(2) instanceof MissileShot);
}
@Test
public void testReceiveDamage()
{
assertTrue(hp == 100);
receiveDamage(30);
assertTrue(hp == 70);
receiveDamage(-30);
assertTrue(hp == 100);
int lives = space.getLives();
receiveDamage(110);
assertTrue((lives-1) == space.getLives());
}
@Test
public void testSetGun()
{
assertTrue(gun instanceof BlasterGun);
assertTrue(gun.getName().equals("Blaster"));
setGun("Missile");
assertTrue(gun instanceof MissileGun);
assertTrue(gun.getName().equals("Missile"));
setGun(null); //Shouldn&#39;t change anything
assertTrue(gun instanceof MissileGun);
assertTrue(gun.getName().equals("Missile"));
}

@Test
public void testGetGunKitCount()
{
assertTrue(getGunKitCount() == 2);
gunkit.addGun(new FlameGun(space, this, "Flame"));
assertTrue(getGunKitCount() == 3);
}
@Test
public void testGetGunAt()
{
gunkit.addGun(new FlameGun(space, this, "Flame"));
Gun g = getGunAt(gunkit.getGunCount() - 1);
assertTrue(g instanceof FlameGun);
g = getGunAt(0);
assertTrue(g instanceof BlasterGun);
}

@Test
public void testAddGun()
{
Gun g = gunkit.findGun("Missile");
int ammo = g.getAmmo();
addGun(new MissileGun(space, this, "Missile"));
assertTrue((ammo + 30) == g.getAmmo());
int s = gunkit.getGunCount();
addGun(new FlameGun(space, this, "Flame"));
assertTrue((s+1) == gunkit.getGunCount());
}

@Test
public void testInitGunKit()

{
gunkit = null;
assertNull(gunkit);
initGunKit();
assertNotNull(gunkit);
assertTrue(gunkit.getGunCount() == 2);
assertTrue(gunkit.getGun(0) instanceof BlasterGun);
assertTrue(gunkit.getGun(1) instanceof MissileGun);
}
protected static JTypeSpace space;
}
package jType1;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class GunKitTest {

@BeforeClass
public static void setUpBeforeClass() throws Exception
{
space = new JTypeSpace(new JType());
ship = space.getShip();
}

@Before
public void setUp() throws Exception {
}
@Test
public void testAddGun()
{
GunKit gk = new GunKit();
assertTrue(gk.getGunCount() == 0);
int i = gk.addGun(new BlasterGun(space, ship, "Blaster1"));
assertTrue(gk.getGunCount() == 1);
assertTrue(i == 0);
i = gk.addGun(new BlasterGun(space, ship, "Blaster2"));
i = gk.addGun(new BlasterGun(space, ship, "Blaster3"));
assertTrue(gk.getGunCount() == 3);
assertTrue(i == 2);
i = gk.addGun(new MissileGun(space, ship, "Missile"));
assertTrue(gk.getGunCount() == 4);
assertTrue(i == 3);
i = gk.addGun(new FlameGun(space, ship, "Flame"));
assertTrue(gk.getGunCount() == 5);
assertTrue(i == 4);
}

@Test
public void testRemoveGunInt()

{
GunKit gk = new GunKit();
int i = gk.addGun(new BlasterGun(space, ship, "Blaster1"));
i = gk.addGun(new BlasterGun(space, ship, "Blaster2"));
assertTrue(gk.getGunCount() == 2);
assertTrue(i == 1);
gk.removeGun(i);
assertTrue(gk.getGunCount() == 1);
}
@Test
public void testRemoveGunString()
{
GunKit gk = new GunKit();
@SuppressWarnings("unused")
int i = gk.addGun(new BlasterGun(space, ship, "Blaster1"));
i = gk.addGun(new BlasterGun(space, ship, "Blaster2"));
assertTrue(gk.getGunCount() == 2);
gk.removeGun("Blaster3"); //Shouldn't change anything
assertTrue(gk.getGunCount() == 2);
gk.removeGun("Blaster2");
assertTrue(gk.getGunCount() == 1);
gk.removeGun("Blaster1");
assertTrue(gk.getGunCount() == 0);
}

@Test
public void testGetGunCount()
{
GunKit gk = new GunKit();
assertTrue(gk.getGunCount() == 0);
gk.addGun(new BlasterGun(space, ship, "Blaster1"));
assertTrue(gk.getGunCount() == 1);
gk.addGun(new BlasterGun(space, ship, "Blaster2"));

assertTrue(gk.getGunCount() == 2);
gk.removeGun(1);
assertTrue(gk.getGunCount() == 1);
}
@Test
public void testGetGun()
{
GunKit gk = new GunKit();
gk.addGun(new BlasterGun(space, ship, "Blaster1"));
gk.addGun(new MissileGun(space, ship, "Missile1"));
gk.addGun(new FlameGun(space, ship, "Flame1"));
gk.addGun(new BlasterGun(space, ship, "Blaster2"));
gk.addGun(new MissileGun(space, ship, "Missile2"));
gk.addGun(new FlameGun(space, ship, "Flame2"));
Gun g = gk.getGun(2);
assertTrue(g instanceof FlameGun);
assertTrue(g.getName().equals("Flame1"));
g = gk.getGun(4);
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile2"));
g = gk.getGun(6);
assertNull(g);
}

@Test
public void testFindGun()
{
GunKit gk = new GunKit();
gk.addGun(new BlasterGun(space, ship, "Blaster1"));
gk.addGun(new MissileGun(space, ship, "Missile1"));
gk.addGun(new FlameGun(space, ship, "Flame1"));
gk.addGun(new BlasterGun(space, ship, "Blaster2"));

gk.addGun(new MissileGun(space, ship, "Missile2"));
gk.addGun(new FlameGun(space, ship, "Flame2"));
Gun g = gk.findGun("Missile1");
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile1"));
g = gk.findGun("Flame2");
assertTrue(g instanceof FlameGun);
assertTrue(g.getName().equals("Flame2"));
}
@Test
public void testSetSelectedGunInt()
{
GunKit gk = new GunKit();
int zero = gk.addGun(new BlasterGun(space, ship, "Blaster1"));
gk.addGun(new MissileGun(space, ship, "Missile1"));
gk.addGun(new FlameGun(space, ship, "Flame1"));
gk.addGun(new BlasterGun(space, ship, "Blaster2"));
int five = gk.addGun(new MissileGun(space, ship, "Missile2"));
gk.addGun(new FlameGun(space, ship, "Flame2"));
gk.setSelectedGun(zero);
Gun g = gk.getSelectedGun();
assertTrue(g instanceof BlasterGun);
assertTrue(g.getName().equals("Blaster1"));
gk.setSelectedGun(five);
g = gk.getSelectedGun();
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile2"));
gk.setSelectedGun(7); //Shouldn&#39;t change selected Gun
g = gk.getSelectedGun();
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile2"));
}

@Test
public void testSetSelectedGunString()
{
GunKit gk = new GunKit();
gk.addGun(new BlasterGun(space, ship, "Blaster1"));
gk.addGun(new MissileGun(space, ship, "Missile1"));
gk.addGun(new FlameGun(space, ship, "Flame1"));
gk.addGun(new BlasterGun(space, ship, "Blaster2"));
gk.addGun(new MissileGun(space, ship, "Missile2"));
gk.addGun(new FlameGun(space, ship, "Flame2"));
gk.setSelectedGun("Blaster1");
Gun g = gk.getSelectedGun();
assertTrue(g instanceof BlasterGun);
assertTrue(g.getName().equals("Blaster1"));
gk.setSelectedGun("Missile2");
g = gk.getSelectedGun();
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile2"));
gk.setSelectedGun("Blaster3"); //Shouldn&#39;t change selected Gun
g = gk.getSelectedGun();
assertTrue(g instanceof MissileGun);
assertTrue(g.getName().equals("Missile2"));
}

@Test
public void testSetSelectedGunGun()
{
GunKit gk = new GunKit();
gk.addGun(new BlasterGun(space, ship, "Blaster1"));
gk.addGun(new MissileGun(space, ship, "Missile1"));
gk.addGun(new FlameGun(space, ship, "Flame1"));
gk.addGun(new BlasterGun(space, ship, "Blaster2"));

gk.addGun(new MissileGun(space, ship, "Missile2"));
gk.addGun(new FlameGun(space, ship, "Flame2"));
Gun g = gk.getGun(0);
gk.setSelectedGun(g);
Gun g2 = gk.getSelectedGun();
assertTrue(g2 instanceof BlasterGun);
assertTrue(g.getName().equals("Blaster1"));
gk.setSelectedGun(new MissileGun(space, ship, "Missile3"));
g2 = gk.getSelectedGun();
assertTrue(g2 instanceof MissileGun);
assertTrue(g2.getName().equals("Missile3"));
}

protected static JTypeSpace space;
protected static SpaceShip ship;
}
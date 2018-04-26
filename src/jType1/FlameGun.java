package jType1;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
* FlameGun extends the AbstractGun to provide a weapon to the
SpaceShip. When

* a new Shot is created from this gun a sound will play that
represents the gun being
* fired.
*
*
*
*/
@SuppressWarnings("unused")
public class FlameGun extends AbstractGun
{
public FlameGun(JTypeSpace space, SpaceShip ship, String name)
{
super(space, ship, name);
damage = 10;
ammo = 30;
}
@Override
public Shot fireGun(int x, int y)
{
Shot shot = new FlameShot(x, y);
try {
AudioInputStream audio =
AudioSystem.getAudioInputStream(this.getClass().getResource("Flame.wav"));
Clip clip = AudioSystem.getClip();
clip.open(audio);
clip.start();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
ammo-- ;

return shot;
}
}
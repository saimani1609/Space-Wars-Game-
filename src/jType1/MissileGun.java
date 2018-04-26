package jType1;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
* MissileGun extends the AbstractGun to provide the a weapon for
the SpaceShip. When
* a new Shot is created from this gun a sound will play that
represents the gun being
* fired.
*
*
*
*/
@SuppressWarnings("unused")
public class MissileGun extends AbstractGun
{
public MissileGun(JTypeSpace space, SpaceShip ship, String name)
{
super(space, ship, name);
damage = 3;
ammo = 10;
}

@Override
public Shot fireGun(int x, int y)
{
Shot shot = new MissileShot(x, y);
try {
AudioInputStream audio =
AudioSystem.getAudioInputStream(this.getClass().getResource("Missile.wav"));
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
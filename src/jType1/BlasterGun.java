package jType1;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
* BlasterGun extends the AbstractGun to provide the default weapon
of the SpaceShip. When
* a new Shot is created from this gun a sound will play that
represents the gun being
* fired.
*
*
*
*/
@SuppressWarnings("unused")
public class BlasterGun extends AbstractGun
{
public BlasterGun(JTypeSpace space, SpaceShip ship, String name)
{
super(space, ship, name);
ammo = -1; //-1 represents infinite ammo
}

@Override
public Shot fireGun(int x, int y)
{
Shot shot = new BlasterShot(x, y);
try {
AudioInputStream audio =
AudioSystem.getAudioInputStream(this.getClass().getResource("Laser.wav"));
Clip clip = AudioSystem.getClip();
clip.open(audio);
clip.start();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return shot;
}

protected int width, height;
}
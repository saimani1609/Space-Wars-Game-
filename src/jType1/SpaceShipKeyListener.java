package jType1;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
/**
* This class implements the KeyListener interface and will call
* certain ship methods depending on the button pressed. The W, A,
S, D
* keys are used to move up, left, down and right, respectively, while
the
* spacebar is used to shoot the ship&#39;s gun.
*
*
*/
public class SpaceShipKeyListener implements KeyListener
{
public SpaceShipKeyListener(SpaceShip ship)
{
this.ship = ship;
}

/**
* This method calls the appropriate method that is used to move the
ship in
* a certain direction or to shoot.
*/
public void keyPressed(KeyEvent e)
{
//Control movement of ship based on button pushed
int code = e.getKeyCode();
switch(code)
{
case KeyEvent.VK_W:
//Move Up
ship.moveUp();

break;
case KeyEvent.VK_A:
//Move Left
ship.moveLeft();
break;
case KeyEvent.VK_D:
//Move Right
ship.moveRight();
break;
case KeyEvent.VK_S:
//Move Down
ship.moveDown();
break;
case KeyEvent.VK_SPACE:
//Shoot the ships gun
ship.shoot();
break;
}
}

@Override
public void keyTyped(KeyEvent e)
{
//Do nothing
}

@Override
public void keyReleased(KeyEvent e)
{
//Do nothing
}

protected SpaceShip ship;

}
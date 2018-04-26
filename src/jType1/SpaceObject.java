package jType1;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
* Interface that defines SpaceObject which is implemented by most
of the objects in the game. It
* provides for basic method signatures that are needed by most of the
objects in the game.
*

*
*
*/
public interface SpaceObject
{
public void move(); //controls movement of object
public void draw(Graphics2D g); //draws the object
public Rectangle getBounds(); //Needed to test for collisions
public void setVisible(boolean v); //set if the object is showing
public boolean isVisible(); //is the object showing
public void setOnScreen(boolean os); //set if the object is on screen
public boolean isOnScreen(); //boolean to determine if the object is on screen
public void receiveDamage(int d); //applies damage to a Space Object's hp
}
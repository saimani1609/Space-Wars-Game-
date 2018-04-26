package jType1;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
* Interface that defines the basic methods that each Shot must have.
*
*
*
*/

public interface Shot
{
public void draw(Graphics2D g, JTypeSpace space);
public Rectangle getBounds();
public void setVisible(boolean v);
public boolean isVisible();
public int getDamage();
}
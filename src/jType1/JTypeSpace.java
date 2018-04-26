package jType1;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
* The JTypeSpace class is where the game takes place. This class extends
JPanel and implements
* Runnable in order to allow animation to occur in the game. This class calls
all the methods
* that are used to draw the various objects to the screen.
*
*
*
*/
public class JTypeSpace extends JPanel implements Runnable
{
public JTypeSpace(JType frame)
{
this.frame = frame;
curLevel = 0;
gameOver = false;
lives = 3;
score = 0;
ship = new SpaceShip(this);
buildLevels(); //Method to build the level in the game
setBackground(Color.BLACK);

setDoubleBuffered(true);
}

public void resetGame()
{
spaceThread = null;
ship = null;
sb = null;
curLevel = 0;
gameOver = false;
lives = 3;
score = 0;
ship = new SpaceShip(this);
buildLevels(); //Method to build the level in the game
startGame();
frame.addGun();
}

public void setLevel(int level)
{
this.curLevel = level;
}

public int getLevel()
{
return curLevel;
}

public void setGameOver(boolean gameOver)
{
this.gameOver = gameOver;
}

public boolean getGameOver()
{
return gameOver;
}


public void setLives(int lives)
{
this.lives = lives;
}

public int getLives()
{
return lives;
}

public void setScore(int score)
{
this.score = score;
}

public int getScore()
{
return score;
}

public SpaceShip getShip()
{
return ship;
}

/**
* Adds an alien shot to the alienShots List. This List holds all the alien
* shots that are currently on the screen.
* @param s
*/
public void addAlienShot(Shot s)
{
if(s != null)
{
alienShots.add(s);
}

}

/**
* Starts the game. Any previous key listeners are moved before creating a
new key listener
* that is associated with the current space ship. This is useful for when the
game is reset
* or when the player dies and a new space ship is created. At the end of the
method the
* thread that controls the animation is started.
*/
public void startGame()
{
KeyListener[] k = getKeyListeners();
if(k.length != 0)
{
removeKeyListener(k[0]);
}
initLevel();
ship.setX(250);
ship.setY(300);
spaceThread = new Thread(this);
keylistener = new SpaceShipKeyListener(ship);
addKeyListener((KeyListener)keylistener);

setFocusable(true);
requestFocus();
spaceThread.start();
}

protected void addLevel(Level l)
{
if(l != null)
{
Levels.add(l);
}
}


/**
* This method will set the current level. It will take the appropriate
* level from the Level List and set it to the current level. The Level
* object will contain the information needed to produce the level.
*/
protected void initLevel()
{
alienShots = new ArrayList();
if(Levels.get(curLevel) != null)
{
//loads level from List
try
{
//Make backup of level in case player dies
level = (Level)((Level)Levels.get(curLevel)).clone();
}
catch (CloneNotSupportedException e)
{
e.printStackTrace();
}
}
}

/**
* This will reset the current level if the player dies while attempting to
* complete the level. The level, ship and alienShot array are all reset.
*/
protected void resetLevel()
{
//Need to reset level, ship, AlienShots, ShipKeyListener
spaceThread = null;
ship = null;
sb = null;
ship = new SpaceShip(this);
buildLevels(); //Method to build the level in the game
startGame();

frame.addGun();
}

/**
* This method will remove a life from the player. It will
* then test to see if there are no lives left and if so, it will
* set the <code&gt;gameOver</code&gt; value to <code&gt;true</code&gt;
*/
public void RemoveLife()
{
lives-- ;
if(lives > 0)
{
resetLevel();
}
else
{
gameOver = true;
}
}

public void addScore(int s)
{
score += s;
}

/**
* This method is used to add any new guns to the JType frame.
*/
public void addGun()
{
frame.addGun();
}

/**
* This method will check all the objects on the screen for collisions.
* It is used to determine if the ship ran into any objects on the screen

* or if any of the shots have hit Aliens.
*/
public void checkCollisions()
{
checkShip();
checkShots();
checkEnemyShots();
}

/**
* Checks if the ship collided with any objects on screen.
*/
protected void checkShip()
{
Rectangle s = ship.getBounds();
for(int i=0; i<level.getTotalSize(); i++)
{
SpaceObject so = level.getObject(i);
if(so != null)
{
if(s.intersects(so.getBounds()))
{
so.setVisible(false);
if(so instanceof AbstractSpaceAlien)
{
ship.receiveDamage(50);
}
else if(so instanceof PowerUp)
{
((PowerUp)so).givePowerUp(ship);
}
else if(so instanceof DangerousObject)
{
ship.receiveDamage(((DangerousObject)so).getDamage());
}
}
}

}
}

/**
* Checks if any of the players shots have collided with objects on the screen.
*/
protected void checkShots()
{
for(int i=0; i<ship.getShotsListSize(); i++)
{
Shot shot = ship.getShotAt(i);
Rectangle shotRec = shot.getBounds();
for(int j=0; j<level.getTotalSize(); j++)
{
SpaceObject alien = level.getObject(j);
if(alien.isVisible())
{
if(shotRec.intersects(alien.getBounds()))
{
shot.setVisible(false);
alien.receiveDamage(shot.getDamage());
}
}
}
}
}

/**
* Checks if any of the aliens&#39; shots have collided with the player.
*/
protected void checkEnemyShots()
{
for(int i=0; i<alienShots.size(); i++)
{
Shot s = (Shot) alienShots.get(i);
Rectangle shotRec = s.getBounds();
Rectangle shipRec = ship.getBounds();

if(shipRec.intersects(shotRec))
{
s.setVisible(false);
ship.receiveDamage(s.getDamage());
}
}
}

/**
* The paint method draws all the objects in the game to screen. Various
methods are called inside
* of <code&gt;paint</code&gt; that draw other objects to the screen.
*/
public void paint(Graphics g)
{

super.paint(g);
Graphics2D g2 = (Graphics2D) g;
g2.setColor(Color.green);
Font font = new Font(Font.MONOSPACED, Font.BOLD, 48 );
if(gameOver == false)
{
if(level.getLevelComplete() == false)
{
//draw HP, score, ammo at top of screen
drawStats(g2);

ship.draw(g2);
drawAlienShots(g2);
level.draw(g2);
Toolkit.getDefaultToolkit().sync();
g2.dispose();
}
else
{
/*

* The method in the if statement makes it possible for a message to be on
a the screen for a period
* of time even though the screen is refreshed 30 times per second.
*/
if(holdForMessage(framesPerSecond * 3))
{
g2.setFont(font);
g2.drawString("Level "+ Integer.toString(curLevel + 1) + " Complete",
560, 300);
}
else
{
nextLevel();
}
}
}
else
{
g2.setFont(font);
g2.drawString("GAME OVER", 560, 300);
if(sb != null)
{
sb.drawBoard(g2);
}
}
}

/**
* This method controls the speed of the animation and calls the
<code&gt;repaint</code&gt;
* method that will draw the game&#39;s objects to the screen. Once the game is
over it will
* cal the method to create the object that displays the top scores.
*/
public void run()
{
while(Thread.currentThread() == spaceThread)

{
try
{
Thread.currentThread().sleep(framesPerSecond); //30 frames per second
}
catch(InterruptedException e){}
checkCollisions();
repaint();
if(sb == null && gameOver == true)
{
try {
sb = new ScoreBoard(this);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
}

/**
* This method allows for messages to be displayed on the screen for a certain
period of time
* even though the screen is refreshed very rapidly. Each time the method is
called an iterator
* is increased until it reaches the length specified in the parameter. The
method will then
* return false and the message will no longer be displayed to the screen.
*
* @param length - how long the message should be displayed on the screen
* @return a boolean defining if the iterator has reached the length
*/
protected boolean holdForMessage(int length)
{
if(messageIterator < length)
{
messageIterator++;

return true;
}
else
{
messageIterator = 0;
return false;
}
}

/**
* This method calls the builder which builds the different levels in the game.
* Each level is added to an <code&gt;ArrayList</code&gt;.
*/
protected void buildLevels()
{
Levels = null;
Levels = new ArrayList();
LevelGameBuilder builder = new LevelGameBuilder();
addLevel(builder.BuildLevelOne(this));
addLevel(builder.BuildLevelTwo(this));
addLevel(builder.BuildLevelThree(this));
addLevel(builder.BuildLevelFour(this));
}

/**
* Draws all the visible alien shots to the screen. If the shot is no longer
* visible then the shot is removed from the List.
*
* @param g - The Graphics2D object that will draw to the screen
*/
protected void drawAlienShots(Graphics2D g)
{
for(int i=0; i<alienShots.size(); i++)
{
Shot s = (Shot) alienShots.get(i);
if(s.isVisible())
{

s.draw(g, this);
}
else
{
alienShots.remove(i);
}
}
}

/**
* Draws the player&#39;s stats to the screen. This includes the player&#39;s health,
ammo,
* score, how many lives they have and what level they are on.
*
* @param g - The Graphics2D object that will draw to the screen
*/
protected void drawStats(Graphics2D g)
{
g.setColor(Color.GREEN);
g.setFont(font);
fm = g.getFontMetrics();
int y = fm.getHeight() + 20;

g.drawString("Ammo: " + Integer.toString(ship.getAmmo()), 10, y);
g.drawString("Lives: " + Integer.toString(lives), 150, y);
g.drawString("Score: " + Integer.toString(score), 250, y);
g.drawString("Health: ", 400, y);
g.drawRect(405 + fm.stringWidth("Health: "), y - fm.getAscent(), 100,
fm.getAscent());
g.fillRect(405 + fm.stringWidth("Health: "), y - fm.getAscent(), ship.getHP(),
fm.getAscent());
g.drawString("Level " + Integer.toString(curLevel + 1), 700, y);
}

/**
* Moves the game to the next level if there is another level available.
Otherwise

* the gameOver value is set to true and the game is over.
*/
protected void nextLevel()
{
curLevel++;
if(curLevel < Levels.size())
{
initLevel();
}
else
{
gameOver = true;
}
}

protected JType frame; //outer JType frame
protected int curLevel; //tracks the level the player is on
protected boolean gameOver; //tracks if the game is over or not
protected int lives; //number of lives the player has
protected int score; //players score
protected List Levels; //Array list to hold the levels in the game
protected Level level; //This holds the level that is currently being played
protected SpaceShip ship;
protected List alienShots; //Holds the shots created by aliens
protected int messageIterator; //Used in displaying messages to screen
protected int framesPerSecond = 1000/30;
protected Thread spaceThread;
protected ScoreBoard sb; //Used to print the scores at the end of the game
protected EventListener keylistener;
Color curColor = Color.green;
protected Font font;
protected FontMetrics fm;
}
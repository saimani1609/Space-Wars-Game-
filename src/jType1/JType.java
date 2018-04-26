package jType1;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
* The main class of this game. It creates the JType object which extends
JFrame.
* The JTypeSpace object is created and placed in the center of JType.
*
*
*
*/
public class JType extends JFrame
{
public JType()

{
setTitle("JType");
paused = false;
getContentPane().setLayout(new BorderLayout());
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
if (exitAction != null)
{
exitAction.actionPerformed(new ActionEvent(JType.this, 0, null));
}
}
});
gunListener = new GunListener();
space = makeSpace();
getContentPane().add(space, BorderLayout.CENTER);
getContentPane().add(createGunBar(gunListener), BorderLayout.WEST);
getContentPane().add(createMenuBar(), BorderLayout.NORTH);
initSpace();
}

/**
* This will add any new guns to the toolbar on the screen.
*/
public void addGun()
{
JButton c = null;
int n = space.getShip().getGunKitCount();
Component[] compArray = toolbar.getComponents();
int caLength = compArray.length;
while(n < caLength)
{
toolbar.remove(n);
caLength-- ;
}


for (int i = 0; i < n; i++)
{
Gun gun = space.getShip().getGunAt(i);
if(i < compArray.length)
{
c = (JButton)compArray[i];
}

if (gun != null && gun.getName() != c.getText())
{
JButton button = new JButton(gun.getName());
button.addActionListener(gunListener);
button.setFocusable(false);
toolbar.add(button);
}
}
toolbar.validate();
}

/**
* Creates the JTypeSpace object that displays the game.
*
* @return the JTypeSpace where the game will be played.
*/
protected JTypeSpace makeSpace()
{
return new JTypeSpace(this);
}

/**
* Creates the toolbar on the left side of the screen that provides buttons to
select
* which Gun is currently in use.
*
* @param toolListener - ActionListener to is used to tell when a button is
pressed
* @return the toolbar with buttons representing the Gun the ship has

*/
protected JComponent createGunBar(ActionListener toolListener)
{
toolbar = new JPanel(new GridLayout(0, 1));
int n = space.getShip().getGunKitCount();
for (int i = 0; i < n; i++)
{
Gun gun = space.getShip().getGunAt(i);
if (gun != null)
{
JButton button = new JButton(gun.getName());
button.addActionListener(toolListener);
button.setFocusable(false);
toolbar.add(button);
}
}
return toolbar;
}

/**
* Initializes and starts the game.
*/
protected void initSpace()
{
space.startGame();
}

/**
* This method is used to restart the current game.
*/
protected void resetGame()
{
space.resetGame();
}

/**

* This creates the menu bar at the top of the screen. This is where the player
can reset the game
* or read the About menu.
*
* @return Menu bar at displayed at the top of the screen
*/
protected JMenuBar createMenuBar()
{
JMenuBar bar = new JMenuBar();
JMenu menu;
JMenuItem mi;

menu = new JMenu("Game");
bar.add(menu);

mi = new JMenuItem("Reset");
menu.add(mi);
mi.addActionListener(new ResetActionListener());

// horizontal space
bar.add(Box.createHorizontalGlue());

menu = new JMenu("Help");
bar.add(menu);

mi = new JMenuItem("About");
menu.add(mi);
mi.addActionListener(new AboutActionListener());

return bar;
}

protected JTypeSpace space;
protected JPanel toolbar;
protected GunListener gunListener;
protected ExitListener exitAction;
protected boolean paused;


/**
* Main method that defines the screen size and creates the JType object.
*
* @param args
*/
public static void main(String[] args)
{
int width = 1200;
int height = 750;
JFrame frame = new JType();
frame.setSize(width, height);
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
frame.setLocation(screenSize.width/2 - width/2,
screenSize.height/2 - height/2);
frame.setResizable(false);
frame.setVisible(true);
}

protected class ResetActionListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
resetGame();
}

}

protected class AboutActionListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
JOptionPane.showMessageDialog(null,
"JType\nSaimani Saridi\n ss3243@njit.edu", "About",
JOptionPane.INFORMATION_MESSAGE);
}
}


protected class GunListener implements ActionListener
{
public void actionPerformed(ActionEvent event)
{
Object source = event.getSource();
if (source instanceof AbstractButton)
{
AbstractButton button = (AbstractButton) source;
space.getShip().setGun(button.getText());
}
}
}

protected class ExitListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
int result = JOptionPane.showConfirmDialog(null,
"Do you want to quit your game?",
"Exit JType?",
JOptionPane.YES_NO_OPTION);
if (result == JOptionPane.YES_OPTION)
{
System.exit(0);
}
}
}
}
package jType1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* This class is used to display the results of the 15 top scoring games.
The names and
* scores are retrieved from an Oracle database. They are displayed to
the screen
* and animated to move up the screen.
*
*
*
*/
@SuppressWarnings("unused")
public class ScoreBoard
{
/**
* The ScoreBoard constructor will send the current game&#39;s score to
the database if
* the score is greater than zero. It will then retrieve the data in
tblTopScores.
* @param space
* @throws SQLException
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public ScoreBoard(JTypeSpace space) throws SQLException

{
this.space = space;
score = Integer.toString(space.getScore());
if(space.getScore() > 0)
{
name = JOptionPane.showInputDialog("Enter your initials");
EmbeddedSQL.ExecuteQuery("Insert Into tblTopScores Values(" + name + "," + score + ")");
}
rSet = EmbeddedSQL.ExecuteQuery("Select Name, Score From tblTopScores Order By Score Desc");
int i = 0;
names = new ArrayList();
scores = new ArrayList();
while(rSet.next() && i<15)
{
names.add(rSet.getString("Name"));
scores.add(rSet.getString("Score"));
i++;
}
EmbeddedSQL.closeAll(); //Close database connections
d = space.getSize();
y = initY = d.height;
maxY = 50;
divider = (initY - maxY) / 15;
font = new Font(Font.MONOSPACED, Font.BOLD, 40);
}

/**
* This method is used to draw the names and scores to the screen.
Each time method
* is called the initial position is moved up the screen to make it
appear

* animated.
*
* @param g2 - the Graphics used to write to the screen
*/
public void drawBoard(Graphics2D g2)
{
int r, g, b;
r = g = b = 0;
y = initY;
for(int i=0; i<names.size(); i++)
{
g2.setColor(Color.green);
g2.setFont(font);

g2.drawString((String)names.get(i) + " " + (String)scores.get(i),
100, y);
y += divider;
}
initY -= 2;
}

protected JTypeSpace space;
protected ResultSet rSet;
protected String name;
protected String score;
protected Dimension d;
@SuppressWarnings("rawtypes")
protected List names, scores;
protected int initY, maxY, y;
protected int divider;
protected Font font;
}
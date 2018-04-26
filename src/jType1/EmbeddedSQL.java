package jType1;
import java.sql.*;

/**
* This class allows for SQL statements to be executed on the Prophet
Oracle database.
*
*
*
*/

public class EmbeddedSQL
{
/**
* This method is used to execute the query provided by the client.
A connection will
* be made to the Oracle database and the query will be executed.
The results are put
* into a result set and returned.
*
* @param Query - SQL statement to be executed
* @return a result set containing the results of the query
*/
public static ResultSet ExecuteQuery(String Query)
{
stmt = InitStmt();

try
{
System.out.println("Executing Query: " + Query);
rSet = stmt.executeQuery(Query);
return rSet;
}
catch(Exception e)
{
// Catch any exception thrown by the above ExecuteQuery
// method and print it.
System.out.println("Exception caught: " + e.getMessage());
}
return null;
}


/**
* This closes all possible open items. If this method is called when
these are already closed
* nothing will happen.
*/
public static void closeAll()
{
try {
rSet.close();
stmt.close();
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}

}

/**
* Initializes the connection and statement objects that the query
needs to execute.
*
* @return the Statement the connection creates
*/
protected static Statement InitStmt()
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
// Connect to the database
conn = DriverManager.getConnection (url, "SYSTEM",
"1609");

// Create a Statement
Statement s = conn.createStatement ();

return s;
}
catch(SQLException e)
{
// Catch any exception thrown by the above ExecuteUpdate
// method and print it.
System.out.println("Exception caught: " + e.getMessage());
}

return null;
}

protected static ResultSet rSet;
protected static Statement stmt;
protected static Connection conn;
//Needed to connect to the NJIT Oracle database, Prophet
private static String url = "jdbc:oracle:thin:[SYSTEM/1609]:1521:course";
}
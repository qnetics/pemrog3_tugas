

/**
 * Bank Java
 *
 * @author Al-fariqy Raihan Azhwar (NPM : 202143501514)
 * @version 1.0
 * 
 */



import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;



public class Configurations {
    

    protected static Statement SqliteConfigurationStatement () throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(
            "jdbc:sqlite:database.db");

        connection.setAutoCommit(true);

        Statement statement = connection.createStatement();

        return statement;
    }
    

}

package database;

import java.sql.SQLException;

public class PolynamesDatabase extends MySQLDatabase {

    public PolynamesDatabase() throws SQLException{
        super("localhost",3306,"poly_names","Erwan2","Boubou");
        
    }
}
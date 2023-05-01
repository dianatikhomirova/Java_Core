package lesson7.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:local.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS weather (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	city text NOT NULL,\n"
                + "	localdate text NOT NULL,\n"
                + "	text text NOT NULL,\n"
                + "	temperature real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }
}

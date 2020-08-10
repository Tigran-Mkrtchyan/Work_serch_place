package am.tech42.staff.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector{

    private static final Connection connection;
    private static final String dbUser = "test";
    private static final String dbPass = "test";
    private static final String jdbcUrl = "jdbc:postgresql://fm-toolbox.duckdns.org:5433/staff";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}

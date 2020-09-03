package dao;

import proxygen.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class WriteProxyDAO {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
    static final String USER = "postgres";
    static final String PASS = "1623";

    public static void writeProxyInTable(ArrayList<Proxy> proxylist) {
        Connection connection = null;
        Statement statement = null;
        String createsql = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            createsql = "Delete from proxies";
            statement.executeUpdate(createsql);

            for (Proxy proxyforimport : proxylist) {

                createsql = "INSERT INTO proxies (country, host, type, timestamp, port, connecttimeout, speed) Values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(createsql);
                preparedStatement.setString(1, proxyforimport.country);
                preparedStatement.setString(2, proxyforimport.host);
                preparedStatement.setString(3, proxyforimport.type);
                preparedStatement.setString(4, proxyforimport.timestamp);
                preparedStatement.setInt(5, proxyforimport.port);
                preparedStatement.setInt(6, proxyforimport.connecttimeout);
                preparedStatement.setInt(7, proxyforimport.speed);

                preparedStatement.executeUpdate();
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table updated successfully");

    }
}


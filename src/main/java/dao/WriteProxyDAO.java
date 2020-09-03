package dao;

import proxygen.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class WriteProxyDAO {

    public static void writeProxyInTable(ArrayList<Proxy> proxylist) {

        try {

            String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
            String USER = "postgres";
            String PASS = "1623";

            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

                for (Proxy proxyforimport : proxylist) {

                    String createsql = "INSERT INTO proxies (country, host, type, timestamp, port, connecttimeout, speed) Values (?, ?, ?, ?, ?, ?, ?)";
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
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table updated successfully");

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);

        }
        deleteTableData();
    }

    public static void deleteTableData(){
        try {
            String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
            String USER = "postgres";
            String PASS = "1623";

            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

                String createsql = "DELETE from proxies";
                PreparedStatement preparedStatement = connection.prepareStatement(createsql);
                preparedStatement.executeUpdate();

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table updated successfully");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}


package dao;

import generators.StringGen;
import models.Proxy;
import java.sql.*;
import java.util.ArrayList;

public class DAO {

    public static ArrayList<Proxy> getProxyFromTable(String country, String type, String speed, String connectTimeout, String interval) {

        try {
            String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
            String USER = "postgres";
            String PASS = "1623";
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                ArrayList<Proxy> proxylist = new ArrayList<Proxy>();
                String requestString = StringGen.stringGen(country, type, speed, connectTimeout, interval);
                PreparedStatement preparedStatement = connection.prepareStatement(requestString);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    Proxy newProxy = new Proxy();
                    newProxy.setCountry(resultSet.getString("country"));
                    newProxy.setType(resultSet.getString("type"));
                    newProxy.setHost(resultSet.getString("host"));
                    newProxy.setPort(resultSet.getInt("port"));
                    newProxy.setConnecttimeout(resultSet.getInt("connecttimeout"));
                    newProxy.setSpeed(resultSet.getInt("speed"));
                    newProxy.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());
                    proxylist.add(newProxy);
                }
                System.out.println("Table imported successfully");
                return proxylist;
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return null;
    }

    public static void writeProxyInTable(ArrayList<Proxy> proxylist) {
        try {
            String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
            String USER = "postgres";
            String PASS = "1623";
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                //deleteTableData();
                for (Proxy proxyforimport : proxylist) {
                    String createsql = "INSERT INTO proxies (country, host, type, timestamp, port, connecttimeout, speed) Values (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(createsql);
                    preparedStatement.setString(1, proxyforimport.getCountry());
                    preparedStatement.setString(2, proxyforimport.getHost());
                    preparedStatement.setString(3, proxyforimport.getType());
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(proxyforimport.getTimestamp()));
                    preparedStatement.setInt(5, proxyforimport.getPort());
                    preparedStatement.setInt(6, proxyforimport.getConnecttimeout());
                    preparedStatement.setInt(7, proxyforimport.getSpeed());
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
    }

    private static void deleteTableData() {
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


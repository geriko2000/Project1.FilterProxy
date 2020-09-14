package dao;

import proxy.Proxy;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GetProxyDAO {

    public static ArrayList<Proxy> getProxyFromTable() {

        try {

            String DB_URL = "jdbc:postgresql://127.0.0.1:5432/MyData";
            String USER = "postgres";
            String PASS = "1623";

            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

                ArrayList<Proxy> proxylist = new ArrayList<Proxy>();

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM proxies");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Proxy newProxy = new Proxy();
                    newProxy.setCountry(resultSet.getString("country"));
                    newProxy.setHost(resultSet.getString("host"));
                    newProxy.setType(resultSet.getString("type"));
                    newProxy.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());
                    newProxy.setPort(resultSet.getInt("port"));
                    newProxy.setConnecttimeout(resultSet.getInt("connecttimeout"));
                    newProxy.setSpeed(resultSet.getInt("speed"));

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
}

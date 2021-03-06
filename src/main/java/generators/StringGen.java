package generators;

import java.sql.Timestamp;

public class StringGen {

    public static String stringGen(String country, String type, String speed, String connectTimeout, String interval) {
        String requestString = "SELECT country, type, port, host, connecttimeout, speed, timestamp FROM proxies WHERE " +
                whereValues(country, type, speed, connectTimeout, interval);
        //System.out.println(requestString);
        return requestString;
    }

    private static String selectColumns(String country, String type, String speed, String connectTimeout, String interval) {
        String requestString = new String();
        if (country != null) {
            requestString += "country";
            if (type != null || speed != null || connectTimeout != null || interval != null) {
                requestString += ", ";
            } else {
                requestString += " ";
            }
        }
        if (type != null) {
            requestString += "type";
            if (speed != null || connectTimeout != null || interval != null) {
                requestString += ", ";
            } else {
                requestString += " ";
            }
        }
        if (speed != null) {
            requestString += "speed";
            if (connectTimeout != null || interval != null) {
                requestString += ", ";
            } else {
                requestString += " ";
            }
        }
        if (connectTimeout != null) {
            requestString += "connecttimeout";
            if (interval != null) {
                requestString += ", ";
            } else {
                requestString += " ";
            }
        }
        if (interval != null) {
            requestString += "timestamp ";
        }
        return requestString;
    }

    private static String whereValues(String country, String type, String speed, String connectTimeout, String interval) {

        String requestString = new String();
        if (country != null) {
            requestString = "country = '" + country + "'";
            if (type != null || speed != null || connectTimeout != null || interval != null) {
                requestString += " AND ";
            }
        }
        if (type != null) {
            requestString += "type = '" + type + "'";
            if (speed != null || connectTimeout != null || interval != null) {
                requestString += " AND ";
            }
        }
        if (speed != null) {
            requestString += "speed >= " + Integer.parseInt(speed);
            if (connectTimeout != null || interval != null) {
                requestString += " AND ";
            }
        }
        if (connectTimeout != null) {
            requestString += "connecttimeout <= " + Integer.parseInt(connectTimeout);
            if (interval != null) {
                requestString += " AND ";
            }
        }
        if (interval != null) {
            Timestamp timestampInterval = new Timestamp(System.currentTimeMillis() - (Integer.parseInt(interval) * 60 * 1000));
            requestString += "timestamp >= '" + timestampInterval + "'";
        }
        return requestString;
    }
}

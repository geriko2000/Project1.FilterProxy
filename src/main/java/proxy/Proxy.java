package proxy;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.time.*;

public class Proxy {
    private String country;
    private String host;
    private String type;
    private LocalDateTime timestamp;
    private int port;
    private int connecttimeout;
    private int speed;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setConnecttimeout(int connecttimeout) {
        this.connecttimeout = connecttimeout;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCountry() {
        return country;
    }

    public String getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getPort() {
        return port;
    }

    public int getConnecttimeout() {
        return connecttimeout;
    }

    public int getSpeed() {
        return speed;
    }
}

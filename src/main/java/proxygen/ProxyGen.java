package proxygen;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;

public class ProxyGen {
    private int generatePort() {
        Random rp = new Random();
        int port = rp.nextInt(65535 - 1024 + 1);
        port += 1024;

        return port;
    }

    private int generateTimeout() {
        Random rt = new Random();
        int timeout = rt.nextInt(5000) + 1;

        return timeout;
    }

    private int generateSpeed() {
        Random rs = new Random();
        int speed = rs.nextInt(100) + 1;

        return speed;
    }

    private String generateHost() {
        String host;
        Random rip1 = new Random();
        Random rip2 = new Random();
        Random rip3 = new Random();
        Random rip4 = new Random();
        int ip1 = rip1.nextInt(255);
        int ip2 = rip2.nextInt(255);
        int ip3 = rip3.nextInt(255);
        int ip4 = rip4.nextInt(255);
        host = ip1 + "." + ip2 + "." + ip3 + "." + ip4;

        return host;
    }

    private String generateCountry() {
        ArrayList<String> country = new ArrayList<String>();
        country.add("US");
        country.add("RU");
        country.add("VN");
        country.add("DK");
        country.add("IN");
        country.add("CA");
        Random rc = new Random();

        return country.get(rc.nextInt(6));
    }

    private String generateType() {
        ArrayList<String> hosts = new ArrayList<String>();
        hosts.add("http");
        hosts.add("https");
        hosts.add("socks5");
        hosts.add("socks4");
        Random rh = new Random();

        return hosts.get(rh.nextInt(4));
    }

    private LocalDateTime generateTimestamp() {
        Random ry = new Random();
        Random rm = new Random();
        Random rd = new Random();
        Random rh = new Random();
        Random rmin = new Random();
        Random rs = new Random();
        Random rms = new Random();
        int year = ry.nextInt(2020 - 2019 + 1) + 2019;
        int month = rm.nextInt(12) + 1;
        int day = rd.nextInt(31) + 1;
        int hour = rh.nextInt(23);
        int minute = rmin.nextInt(59);
        int second = rs.nextInt(59);
        int milsec = rms.nextInt(999999);

        LocalDateTime timestamp = LocalDateTime.of(year, month, day, hour, minute, second, milsec);

        return timestamp;
    }


    public ArrayList proxyGen(int count) {
        ArrayList<Proxy> proxylist = new ArrayList<Proxy>();
        for (int i = 0; i < count; i++) {
            Proxy newproxy = new Proxy();
            newproxy.country = generateCountry();
            newproxy.host = generateHost();
            newproxy.port = generatePort();
            newproxy.speed = generateSpeed();
            newproxy.timestamp = generateTimestamp();
            newproxy.type = generateType();
            newproxy.connecttimeout = generateTimeout();
            proxylist.add(newproxy);
        }

        return proxylist;
    }
}

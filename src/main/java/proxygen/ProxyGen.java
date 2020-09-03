package proxygen;

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
        String host = new String();
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

    private String generateTimestamp() {
        String timestamp = new String();
        Random ry = new Random();
        Random rm = new Random();
        Random rd = new Random();
        Random rh = new Random();
        Random rmin = new Random();
        Random rs = new Random();
        Random rms = new Random();
        int year = ry.nextInt(2020 - 2019 + 1);
        year += 2019;
        int month = rm.nextInt(12) + 1;
        int day = rd.nextInt(31) + 1;
        if (month == 2 && day > 28) {
            day = day - 3;
        } else {
            if ((month % 2 == 0 && month != 8) && day == 31) {
                day = day - 1;
            }
        }
        int hour = rh.nextInt(23);
        int minute = rmin.nextInt(59);
        int second = rs.nextInt(59);
        int milsec = rms.nextInt(999999);
        timestamp = year + "-";
        if (month < 10) {
            timestamp += "0" + month + "-";
        } else timestamp += month + "-";

        if (day < 10) {
            timestamp += "0" + day + " ";
        } else timestamp += day + " ";

        if (hour < 10) {
            timestamp += "0" + hour + ":";
        } else timestamp += hour + ":";

        if (minute < 10) {
            timestamp += "0" + minute + ":";
        } else timestamp += minute + ":";

        if (second < 10) {
            timestamp += "0" + second + ".";
        } else timestamp += second + ".";

        if (milsec < 10) {
            timestamp += "00000" + milsec;
            return timestamp;
        } else if (milsec < 100) {
            timestamp += "0000" + milsec;
            return timestamp;
        } else if (milsec < 1000) {
            timestamp += "000" + milsec;
            return timestamp;
        } else if (milsec < 10000) {
            timestamp += "00" + milsec;
            return timestamp;
        } else if (milsec < 100000) {
            timestamp += "0" + milsec;
            return timestamp;
        } else {
            timestamp += milsec;
            return timestamp;
        }

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

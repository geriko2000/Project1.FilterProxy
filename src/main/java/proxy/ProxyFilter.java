package proxy;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.GetProxyDAO;

public class ProxyFilter {

    private static ArrayList<Proxy> analyseCountry(ArrayList<Proxy> proxylist, String country) {

        ArrayList<Proxy> changedlist = new ArrayList<Proxy>();

        for (Proxy proxy : proxylist) {

            if (proxy.country.equals(country)) {
                System.out.println("1");
                changedlist.add(proxy);
            }
        }

        return changedlist;
    }

    private static ArrayList<Proxy> analyseType(ArrayList<Proxy> proxylist, String type){

        ArrayList<Proxy> changedlist = new ArrayList<Proxy>();

        for (Proxy proxy : proxylist) {

            if (proxy.type.equals(type)) {
                System.out.println("1");
                changedlist.add(proxy);
            }
        }

        return changedlist;
    }

    private static ArrayList<Proxy> analyseSpeed(ArrayList<Proxy> proxylist, int speed){

        ArrayList<Proxy> changedlist = new ArrayList<Proxy>();

        for (Proxy proxy : proxylist) {

            if (proxy.speed >= speed) {
                System.out.println("1");
                changedlist.add(proxy);
            }
        }

        return changedlist;
    }

    private static ArrayList<Proxy> analyseConnecttimeout(ArrayList<Proxy> proxylist, int connecttimeout){

        ArrayList<Proxy> changedlist = new ArrayList<Proxy>();

        for (Proxy proxy : proxylist) {

            if (proxy.connecttimeout <= connecttimeout) {
                System.out.println("1");
                changedlist.add(proxy);
            }
        }

        return changedlist;
    }

    private static ArrayList<Proxy> analyseInterval(ArrayList<Proxy> proxylist, int interval){

        ArrayList<Proxy> changedlist = new ArrayList<Proxy>();

        LocalDateTime testtime1 = LocalDateTime.of(2019, 01, 06, 18, 35, 48);
        LocalDateTime testtime0 = testtime1.minusMinutes(interval);

        for (Proxy proxy : proxylist) {

            if(proxy.timestamp.isAfter(testtime0) && proxy.timestamp.isBefore(testtime1)){
                System.out.println("1");
                changedlist.add(proxy);
            }

        }

        return changedlist;
    }

    public static ArrayList<Proxy> proxyFilter(String country, String type, String speed_s, String connecttimeout_s, String interval_s) {

        int speed = Integer.parseInt(speed_s);
        int connecttimeout = Integer.parseInt(connecttimeout_s);
        int interval = Integer.parseInt(interval_s);

        ArrayList<Proxy> proxylist = GetProxyDAO.getProxyFromTable();

        if (country != null) {

            proxylist = analyseCountry(proxylist, country);

            if (proxylist.isEmpty() == true) {

                return proxylist;
            }
        }

        if(type != null){

            proxylist = analyseType(proxylist, type);

            if (proxylist.isEmpty() == true) {

                return proxylist;
            }
        }

        if(speed_s != null){

            proxylist = analyseSpeed(proxylist, speed);

            if (proxylist.isEmpty() == true) {

                return proxylist;
            }
        }

        if(connecttimeout_s != null){

            proxylist = analyseConnecttimeout(proxylist, connecttimeout);

            if (proxylist.isEmpty() == true) {

                return proxylist;
            }
        }

        if(interval_s != null){

            proxylist = analyseInterval(proxylist, interval);

            if (proxylist.isEmpty() == true) {

                return proxylist;
            }
        }

        return proxylist;
    }
}

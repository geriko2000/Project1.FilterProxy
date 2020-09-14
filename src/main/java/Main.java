import static spark.Spark.*;

import proxy.*;
import dao.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        //ProxyGen rp = new ProxyGen();
        //WriteProxyDAO.writeProxyInTable(rp.proxyGen(10));

        get("/", (req, res) -> "hello there, write proxy");
        get("/proxy", (req, res) -> {
            System.out.println(req.queryParams());

            String country = req.queryParams("country");
            String type = req.queryParams("type");
            String speed = req.queryParams("speed");
            String connectTimeout = req.queryParams("connect_timeout");
            String interval = req.queryParams("interval");

            List<Proxy> proxyList = ProxyFilter.proxyFilter(country, type, speed, connectTimeout, interval);

            System.out.println(proxyList);

            return country + " " + type + " " + speed + " " + connectTimeout + " " + interval + " ok";
//            return "ok";
        });

    }

}

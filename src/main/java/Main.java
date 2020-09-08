import static spark.Spark.*;

import proxy.*;
import dao.*;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //ProxyGen rp = new ProxyGen();
        //WriteProxyDAO.writeProxyInTable(rp.proxyGen(10));

        get("/", (req, res) -> "hello there, write proxy");
        get("/proxy", (req, res) -> {
            String country = req.queryParams("country");
            String type = req.queryParams("type");
            String speed = req.queryParams("speed");
            String connecttimeout = req.queryParams("connect_timeout");
            String interval = req.queryParams("interval");

            ProxyFilter.proxyFilter(country, type, speed, connecttimeout, interval);

            return country + " " + type + " " + speed + " " + connecttimeout + " " + interval + " ok";
        });

    }

}

import static spark.Spark.*;

import proxygen.Proxy;
import proxygen.ProxyGen;
import dao.*;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //ProxyGen rp = new ProxyGen();
        //WriteProxyDAO.writeProxyInTable(rp.proxyGen(10));

        /*get("/", (req, res) -> "hello there, write proxy");
        get("/proxy", (req, res) -> {
            String country = req.queryParams("country");
            String type = req.queryParams("type");
            String speed = req.queryParams("speed");
            String connecttimeout = req.queryParams("connect_timeout");
            String interval = req.queryParams("interval");



            return country + " " + type + " " + speed + " " + connecttimeout + " " + interval + " ok";
        });*/

        ArrayList<Proxy> test;
        test = GetProxyDAO.getProxyFromTable();

    }

}

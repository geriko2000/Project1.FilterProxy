import static spark.Spark.*;

import dao.DAO;
import generators.JsonGen;


public class Main {
    public static void main(String[] args) {
//        ProxyGen rp = new ProxyGen();
//        WriteProxyDAO.writeProxyInTable(rp.proxyGen(10));

        get("/", (req, res) -> "hello there, write /proxy");
        get("/proxy", (req, res) -> {
            String country = req.queryParams("country");
            String type = req.queryParams("type");
            String speed = req.queryParams("speed");
            String connectTimeout = req.queryParams("connect_timeout");
            String interval = req.queryParams("interval");
            String jsonString = JsonGen.jsonGen(DAO.getProxyFromTable(country, type, speed, connectTimeout, interval));
            return jsonString;
        });

    }

}

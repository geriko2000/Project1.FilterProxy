import static spark.Spark.*;
import proxygen.ProxyGen;
import dao.*;

public class Main {
    public static void main(String args[]){
        ProxyGen a = new ProxyGen();
        WriteProxyDAO.writeProxyInTable(a.proxyGen(10));

        get("/", (req, res) -> "hello there, write proxy");
        get("/proxy", (req, res) -> {
            String country = req.queryParams(":country");
            String type = req.queryParams(":type");
            String speed = req.queryParams(":speed");
            String connecttimeout = req.queryParams(":connect_timeout");
            String interval = req.queryParams(":interval");

            return req.pathInfo() + " ok";
        });

    }

}

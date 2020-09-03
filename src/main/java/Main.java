import spark.Spark.*;
import proxygen.ProxyGen;
import dao.*;

public class Main {
    public static void main(String args[]){
        ProxyGen a = new ProxyGen();
        WriteProxyDAO.writeProxyInTable(a.proxyGen(10));
    }

}

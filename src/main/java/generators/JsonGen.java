package generators;

import com.google.gson.Gson;
import models.Proxy;
import java.util.ArrayList;

public class JsonGen {
    public static String jsonGen(ArrayList<Proxy> proxyList) {
        String jsonString = new String();
        for(Proxy proxy : proxyList) {
            Gson gson = new Gson();
            jsonString += gson.toJson(proxy) + "\n";
            //System.out.println(jsonString);
        }
        return jsonString;
    }
}

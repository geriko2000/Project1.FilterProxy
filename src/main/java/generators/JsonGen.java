package generators;

import com.google.gson.Gson;
import models.Proxy;
import java.util.ArrayList;

public class JsonGen {
    public static ArrayList<String> jsonGen(ArrayList<Proxy> proxyList) {
        ArrayList<String> gsonArray = new ArrayList<String>();
        for(Proxy proxy : proxyList) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(proxy);
            gsonArray.add(jsonString);
        }
        return gsonArray;
    }
}

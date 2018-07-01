package com.example.david.prevdrawer;

/**
 * Created by david on 13/06/2018.
 */
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Connection {

    private final String USER_AGENT = "Mozilla/5.0";


    private final static String TOKEN = "91856c07ea61ceb95e17d6a17110b260";


    public String encodeString(String palavra) {
        char one;
        StringBuffer n = new StringBuffer(palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            one = palavra.charAt(i);
            switch (one) {
                case ' ':
                    n.append('%');
                    n.append('2');
                    n.append('0');
                    break;
                default:
                    n.append(one);
            }
        }
        return n.toString();
    }


    public Weather sendGetId(String name, String state) throws Exception {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String nome = encodeString(name);


        String url = "http://apiadvisor.climatempo.com.br/api/v1/locale/city?name=" + nome + "&state=" + state + "&token=" + TOKEN;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer res = new StringBuffer();
        String resultado = "";
        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
            resultado = res.toString();
        }
        in.close();

        JSONArray j = new JSONArray(resultado);

        if(resultado.equalsIgnoreCase("[]")){
            Weather weather = new Weather();
            return weather;


        }
        JSONObject response = j.getJSONObject(0);


        Weather weather = new Weather(response.getInt("id"), response.getString("name"),
                response.getString("state"), response.getString("country"));

        return weather;
    }


    public Weather sendGet2(int cityId) throws Exception {



        String url2 = "http://apiadvisor.climatempo.com.br/api/v1/weather/locale/" + cityId + "/current?token=" + TOKEN;

        URL obj2 = new URL(url2);
        HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();

        con2.setRequestMethod("GET");


        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(con2.getInputStream()));
        String inputLine2;
        String resultado2 = "";
        StringBuffer response2 = new StringBuffer();

        while ((inputLine2 = in2.readLine()) != null) {
            response2.append(inputLine2);
            resultado2 = response2.toString();
        }
        in2.close();

        JSONObject re = new JSONObject(resultado2).getJSONObject("data");

        Weather weather = new Weather();

        Data dt = new Data(re.getDouble("temperature"), re.getString("wind_direction"), re.getInt("wind_velocity"),
                re.getInt("humidity"), re.getString("condition"), re.getString("pressure"), re.getString("icon"),
                re.getString("sensation"), re.getString("date"));

        weather.setDados(dt);

        return weather;

    }

}

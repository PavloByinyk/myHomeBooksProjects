package com.bignerdranch.android.jsonprogrammingwizards.m_JSON;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 1 on 12.07.2016.
 */
public class Connector {

    public static Object connect(String jsonURL){

        try{
            URL url= new URL(jsonURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(600000);
            con.setReadTimeout(600000);
            con.setDoInput(true);

            return con;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error" + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error" + e.getMessage();
        }
    }
}

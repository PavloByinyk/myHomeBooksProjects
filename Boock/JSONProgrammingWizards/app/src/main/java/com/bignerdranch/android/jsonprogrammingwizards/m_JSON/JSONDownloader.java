package com.bignerdranch.android.jsonprogrammingwizards.m_JSON;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by 1 on 12.07.2016.
 */
public class JSONDownloader extends AsyncTask<Void,Void,String> {

    Context c;
    String jsonURL;
    Spinner spinner;

    ProgressDialog pd;

    public JSONDownloader(Context c, Spinner spinner, String jsonURL) {
        this.c = c;
        this.spinner = spinner;
        this.jsonURL = jsonURL;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Download JSON");
        pd.setMessage("Downloading... please wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();

        if (jsonData.startsWith("Error")) {
            Toast.makeText(c, jsonData, Toast.LENGTH_LONG).show();
        } else {

            new JSONParser(c, jsonData, spinner).execute();
        }


    }

    private String download() {
        Object connection = Connector.connect(jsonURL);
        if (connection.toString().startsWith("Error")) {
            return connection.toString();
        }
        try {
            HttpURLConnection con = (HttpURLConnection) connection;
            if (con.getResponseCode() == con.HTTP_OK) {
                //GET INPUT FROM STREAM
                InputStream is = new BufferedInputStream(con.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer jsonData = new StringBuffer();
                //READ
                while ((line = br.readLine()) != null) {
                    jsonData.append(line + "\n");
                }
                //CLOSE RESOURCES
                br.close();
                is.close();
                //RETURN JSON
                return jsonData.toString();
            } else {
                return "Error " + con.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
    }
}

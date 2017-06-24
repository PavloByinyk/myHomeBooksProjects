package com.bignerdranch.android.jsonprogrammingwizards.m_JSON;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bignerdranch.android.jsonprogrammingwizards.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 1 on 12.07.2016.
 */
public class JSONParser extends AsyncTask<Void,Void,Boolean>{

    Context c;
    String jsonData;
    Spinner spinner;

    ProgressDialog pd;
    ArrayList<String> users=new ArrayList<String>();

    public JSONParser(Context c, String jsonData, Spinner spinner) {
        this.jsonData = jsonData;
        this.c = c;
        this.spinner = spinner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse JSON");
        pd.setMessage("Parsing... please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        pd.dismiss();

        if(aBoolean){

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(c, R.layout.support_simple_spinner_dropdown_item,users);
            spinner.setAdapter(adapter);
//            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(c,users.get(position),Toast.LENGTH_LONG).show();
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                }
//            });



        }else {
            Toast.makeText(c,"Error with parsing",Toast.LENGTH_LONG).show();
        }
    }

    private Boolean parse(){

        try {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            users.clear();

            for(int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");
                users.add(name);
            }
            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

    }
}

package com.risqi17.drawer.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Risqi17 on 21/05/2017.
 */

public class ParseJSONPenjahit {
    public static String[] ids;
    public static String[] names;

    public static final String JSON_ARRAY = "penjahit";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "nama";

    private JSONArray users = null;

    private String json;

    public ParseJSONPenjahit(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

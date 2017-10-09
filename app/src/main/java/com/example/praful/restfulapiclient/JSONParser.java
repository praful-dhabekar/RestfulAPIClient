package com.example.praful.restfulapiclient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by praful on 10/6/2017.
 */

public class JSONParser {

    public static final String TAG = "MainActivity";

    public JSONParser() {
        super();
    }

    public ArrayList<DeptTable> parseDepartment(JSONObject object){

        ArrayList<DeptTable> arrayList = new ArrayList<DeptTable>();
        try {
            JSONArray jsonArray = object.getJSONArray("Value");
            JSONObject jsonObj = null;
            for (int i = 0; i <jsonArray.length(); i++) {
                jsonObj = jsonArray.getJSONObject(i);
                arrayList.add(new DeptTable(jsonObj.getInt("no"), jsonObj.getString("name")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public boolean parseUserAuth(JSONObject object){
        boolean userAuth = false;
        try {
            userAuth = object.getBoolean("Value");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userAuth;
    }

    public UserDetailsTable parseUserDetails(JSONObject object){
        UserDetailsTable userDetails = new UserDetailsTable();
        try {
            JSONObject jsonObject = object.getJSONArray("Values").getJSONObject(0);

            userDetails.setFirstName(jsonObject.getString("firstName"));
            userDetails.setLastName(jsonObject.getString("lastName"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userDetails;

    }
}

package com.example.praful.restfulapiclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserDetailsActivity extends AppCompatActivity {

    EditText username, password;
    TextView tv_fname, tv_lname;

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tv_fname = (TextView) findViewById(R.id.tv_firstname);
        tv_lname = (TextView)findViewById(R.id.tv_lastname);

        bundle = getIntent().getExtras();

        myAsyncTask task = new myAsyncTask();
        task.execute( bundle.getString("username"));

    }

    protected class myAsyncTask extends AsyncTask<String, JSONObject, Boolean>{

        String Fname, Lname;
        @Override
        protected Boolean doInBackground(String... params) {
            RestAPI api = new RestAPI();
            try {
                JSONObject jsonObj = api.GetUserDetails(params[0]);
                Log.d("JSON", ""+jsonObj);
                JSONArray jsonArray = jsonObj.getJSONArray("Value");
                JSONObject jsonObject = null;
                for (int i = 0; i <jsonArray.length() ; i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    Fname = jsonObject.getString("firstName");
                    Lname = jsonObject.getString("lastName");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            tv_fname.setText(Fname);
            tv_lname.setText(Lname);
        }
    }
}

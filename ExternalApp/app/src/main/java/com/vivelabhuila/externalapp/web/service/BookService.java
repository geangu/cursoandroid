package com.vivelabhuila.externalapp.web.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andres on 26/01/15.
 */
public class BookService extends AsyncTask<String, Void, Boolean> {

    Activity activity;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost post = new HttpPost(Constants.API_URL);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("title", params[0]));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = client.execute(post);

            String results = EntityUtils.toString(httpResponse.getEntity());

            try {
                JSONObject object = new JSONObject(results);
                String titleObtained = object.getString("title");
                if( titleObtained !=null && titleObtained.equalsIgnoreCase(params[0])){
                    return Boolean.TRUE;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(this.activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            Toast.makeText(this.activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this.activity.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return Boolean.FALSE;
    }

    @Override
    protected void onPostExecute(Boolean b) {
        super.onPostExecute(b);
    }
}

package com.vivelabhuila.externalapp.web.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
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
public class EditBookService extends AsyncTask<String, Void, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        try {
            HttpClient client = new DefaultHttpClient();

            HttpPut put = new HttpPut(Constants.API_URL + params[0]);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("title", params[1]));
            put.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = client.execute(put);

            String results = EntityUtils.toString(httpResponse.getEntity());

            try {
                JSONObject object = new JSONObject(results);
                String titleObtained = object.getString("title");
                if( titleObtained !=null && titleObtained.equalsIgnoreCase(params[0])){
                    return Boolean.TRUE;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Boolean.FALSE;
    }

    @Override
    protected void onPostExecute(Boolean b) {
        super.onPostExecute(b);
    }
}

package com.vivelabhuila.externalapp.web.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.vivelabhuila.externalapp.MainActivity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
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
public class DeleteBookService extends AsyncTask<String, Void, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        try {
            HttpClient client = new DefaultHttpClient();

            HttpDelete delete = new HttpDelete(Constants.API_URL + params[0]);
            client.execute(delete);
            return Boolean.TRUE;

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

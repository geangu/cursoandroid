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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by andres on 26/01/15.
 */
public class FindAllBookService extends AsyncTask<Void, Void, ArrayList<String>> {

    MainActivity activity;

    public FindAllBookService(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<String> doInBackground(Void... params) {

        ArrayList<String> list = new ArrayList<>();

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(Constants.API_URL + "?max=100");
            HttpResponse httpResponse = client.execute(get);

            String results = EntityUtils.toString(httpResponse.getEntity());

            try {
                JSONArray array = new JSONArray(results);
                for(int i = 0; i < array.length(); i++){
                    JSONObject object = (JSONObject) array.get(i);
                    String titleObtained = object.getString("title");
                    list.add(titleObtained);
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
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<String> b) {
        super.onPostExecute(b);
        Iterator<String> iterator = b.iterator();
        activity.list.clear();
        while ( iterator.hasNext() ) {
            activity.list.add(iterator.next());
        }
        activity.adapter.notifyDataSetChanged();
    }
}

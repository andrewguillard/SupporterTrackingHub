package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.PatronDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.patreon.PatreonOAuth;
import com.patreon.PatreonAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebHelper {

    private String patreonUsername;
    private String patreonPassword;

    public WebHelper(){
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("www.patreon.com/oauth2/authorize");
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public ArrayList<PatronDTO> fetchPatreonInformation(){
//        //Fetch a token
//
//        //Fetch all patron info
//    }
}

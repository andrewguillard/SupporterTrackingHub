package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.PatronDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import com.patreon.PatreonOAuth;
import com.patreon.PatreonAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebHelper {

    private String patreonUsername;
    private String patreonPassword;
    private String clientID = "";
    private String clientSecret = "";
    private String authorizationEndpoint = "https://www.patreon.com/oauth2/authorize";
    
    //TODO: Help with OAuth for Desktop: https://github.com/googlesamples/oauth-apps-for-windows/blob/master/OAuthDesktopApp/README.md

    public WebHelper(){
        try {
            URIBuilder builder = new URIBuilder("https://www.patreon.com/oauth2/authorize");
            builder.setParameter("response_type", "code");
            builder.setParameter("client_id", "<INSERT_ID>");
            builder.setParameter("redirect_uri", "<INSERT_URI>");
            //builder.setParameter("scope", "<scope>");
            //builder.setParameter("state", "<state>");
            
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(builder.build());
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

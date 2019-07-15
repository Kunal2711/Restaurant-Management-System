package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

public class ReadWebPageEx {

    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        //request = urllib2.Request(url, headers={"user-key" :Key});


        try {
            String apikey = "MDo4Y2I3ZjM4ZS1lNzllLTExZTgtYmY5Mi1lNzk0NmFhOTk3M2Q6VzhJSWI5OTBreUZYb2EyTU1QVVZLOHdBT1FjcXpOMmtsM0hZ";
            String resquery = "https://lcboapi.com/stores?access_key=";
            //String apikey = "67fc403c57e527db28f03129fa194cfe";
            //String resquery = "https://developers.zomato.com/api/v2.1/restaurant?res_id=73?apikey=";
            String theURL = resquery + apikey;
            //String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

}

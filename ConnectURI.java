package Network;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConnectURI {

    private final String USER_AGENT = "Mozila/5.0";

    public static URL buildURL(String urlQuery) {  //method dg nama buildURL
        URL url = null;

        try {
            url= new URL(urlQuery.toString());
        } catch (MalformedParameterizedTypeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException{ //method dg nama getResponseFromHttpUrl
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            Boolean hasInput = scanner.hasNext();
            if (hasInput){
                return scanner.next();
            }else {
                return null;
            }
        }finally {
            urlConnection.disconnect();
        }
    }

}
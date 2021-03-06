/*Felipe César Cordeiro Campelo
 * Matricula : 20121004010 
 * 4°ano Integrado em informatica
 * github:felipecesarcordeiro e-mail:felipecesarcordeiro@gmail.com*/

package com.example.felipe.atividade_asynctask;

import android.util.Log;

import java.io.*;
import java.net.*;

public class HttpService {


    private static final String URL_CONTEXT = "http://192.168.25.9:8080/rest-servlet-service/";

    public static HttpURLConnection sendGetRequest(String service) throws MalformedURLException, IOException
	{

        HttpURLConnection connection = null;

        try 
		{
            URL url = new URL(URL_CONTEXT + service);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.connect();

        } 
		finally 
		{

            connection.disconnect();
        }

        return connection;
    }

    public void sendJsonPostRequest() {}

    public static String getHttpContent(HttpURLConnection connection) 
	{
        StringBuilder builder = new StringBuilder();

        try 
		{
            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content, "iso-8859-1"), 8);
            String line;
            while ((line = reader.readLine()) != null) 
			{
                builder.append(line);
            }

            content.close();

        } 
		catch (IOException e) 
		{

            Log.e("NotificationWearApp", "IOException: " + e);
        }
        return builder.toString();
    }
}

package br.com.maciel.controle_casa_v2.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ClienteHttpGet implements Runnable {

    private URL url = null;

    /*
     * Proprio contrutor ja requisita a url e inicia a Thread;
     */
    public ClienteHttpGet(String urlParam) {
        super();
        try {
            url = new URL(urlParam);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //System.out.println("url="+url);
        Thread t = new Thread(this);
        t.start();
    }

    public void fim() {

    }

    @Override
    public void run() {
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            InputStreamReader isw = new InputStreamReader(in);
            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }

           /* HttpClient cliente = new DefaultHttpClient();
        HttpGet requiscao = new HttpGet();
        try {
            requiscao.setURI(new URI(url)); s
            cliente.execute(requiscao);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }
}

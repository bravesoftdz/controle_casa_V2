package br.com.maciel.controle_casa_v2.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteHttpGet implements Runnable {

    private URL url = null;

    /*
     * Proprio contrutor ja requisita a url e inicia a Thread;
     */
    public ClienteHttpGet(String urlParam) {
        super();
        url = new URL(urlParam);
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
            readStream(in);

           /* HttpClient cliente = new DefaultHttpClient();
        HttpGet requiscao = new HttpGet();
        try {
            requiscao.setURI(new URI(url));
            cliente.execute(requiscao);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }

    }
}

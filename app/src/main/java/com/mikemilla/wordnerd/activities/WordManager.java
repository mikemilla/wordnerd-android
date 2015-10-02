package com.mikemilla.wordnerd.activities;

import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WordManager {

    private final String PATH = "/data/data/com.mikemilla.wordnerd/";  //put the downloaded file here
    private static String LINK = "http://api.androidhive.info/contacts/";

    public void DownloadFromUrl(String URL, String fileName) {  //this is the downloader method

        try {
            URL url = new URL(URL);
            File file = new File(fileName);

            long startTime = System.currentTimeMillis();
            Log.d("WordManager", "download beginning");
            Log.d("WordManager", "download url:" + url);
            Log.d("WordManager", "downloaded file name:" + fileName);

            /* Open a connection to that URL. */
            URLConnection connection = url.openConnection();

            /*
            * Define InputStreams to read from the URLConnection.
            */
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            /*
             * Read bytes to the Buffer until there is nothing more to read(-1).
             */
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(50);
            int current;
            while ((current = bufferedInputStream.read()) != -1) {
                byteArrayBuffer.append((byte) current);
            }

            /* Convert the Bytes read to a String. */
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(byteArrayBuffer.toByteArray());
            fos.close();
            Log.d("WordManager", "download ready in"
                    + ((System.currentTimeMillis() - startTime) / 1000)
                    + " sec");

        } catch (IOException e) {
            Log.d("WordManager", "Error: " + e);
        }

    }
}
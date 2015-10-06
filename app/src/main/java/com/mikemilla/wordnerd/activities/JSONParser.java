package com.mikemilla.wordnerd.activities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {
    }

    public JSONObject getJSONfromDevice(File file) {

        try {
            FileInputStream stream = new FileInputStream(file);

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            stream.close();
            json = responseStrBuilder.toString();
            jObj = new JSONObject(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return jObj;
    }
}

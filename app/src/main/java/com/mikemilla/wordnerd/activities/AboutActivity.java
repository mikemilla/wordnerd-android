package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mikemilla.wordnerd.R;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AboutActivity extends Activity {

    Gson gson;
    Response responseObj;
    OkHttpClient client;
    TextView textView;

    List<Words> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Close Button
        textView = (TextView) findViewById(R.id.text_view);
        ImageButton closeButton = (ImageButton) findViewById(R.id.close_button);
        closeButton.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        File file = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(file, cacheSize);
        client = new OkHttpClient();
        client.setCache(cache);

        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://www.mikemilla.com/words.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                response.header("Cache-Control: max-age=10");

                gson = new Gson();
                responseObj = gson.fromJson(response.body().charStream(), Response.class);
                for (int i = 0; i < responseObj.getWords().size(); i++) {

                    // Add the words
                    String word = responseObj.getWords().get(i).getWord();
                    //parsedWords.add(word);

                    // Add the singles
                    ArrayList<String> singlesList = new ArrayList<>();
                    if (responseObj.getWords().get(i).getRhymes().getSingles() != null) {
                        for (int s = 0; s < responseObj.getWords().get(i).getRhymes().getSingles().size(); s++) {
                            String singles = responseObj.getWords().get(i).getRhymes().getSingles().get(s);
                            singlesList.add(singles);
                        }
                    }

                    // Add the Doubles
                    ArrayList<String> doublesList = new ArrayList<>();
                    if (responseObj.getWords().get(i).getRhymes().getDoubles() != null) {
                        for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getDoubles().size(); d++) {
                            String doubles = responseObj.getWords().get(i).getRhymes().getDoubles().get(d);
                            doublesList.add(doubles);
                        }
                    }

                    words.add(new Words(word, singlesList, doublesList));

                }

                Collections.shuffle(words);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(

                                words.get(0).getWordObject()

                                /*
                            "Word: " + words.get(0).getWords().get(0) + "\n" +
                            "Singles: " + words.get(0).getSingles().get(0) + "\n" +
                            "Doubles: " + words.get(0).getDoubles().get(0)  + "\n\n" +
                            "Word: " + words.get(1).getWords().get(1) + "\n" +
                            "Singles: " + words.get(1).getSingles().get(1)  + "\n" +
                            "Doubles: " + words.get(1).getDoubles().get(1)
                            */
                        );
                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        overridePendingTransition(R.anim.scale_in, R.anim.slide_out_down);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}

package com.mikemilla.wordnerd.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import com.mikemilla.wordnerd.AndroidBug5497Workaround;
import com.mikemilla.wordnerd.R;
import com.mikemilla.wordnerd.views.EightBitNominalEditText;
import com.mikemilla.wordnerd.views.EightBitNominalTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameActivity extends Activity {

    // JSON Node names
    private static final String TAG_WORDS = "words";
    private static final String TAG_WORD = "word";
    private static final String TAG_ID = "id";
    private static final String TAG_RHYMES = "rhymes";
    private static final String TAG_SINGLES = "singles";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_GENDER = "gender";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_PHONE_MOBILE = "mobile";
    private static final String TAG_PHONE_HOME = "home";
    private static final String TAG_PHONE_OFFICE = "office";

    EightBitNominalEditText rhymeEntry;
    EightBitNominalTextView rhymeGenerated;
    Boolean isKeyboardOpen = false;

    ArrayList<String> parsedWords = new ArrayList<>();

    private JSONObject jObject;
    JSONArray words = null;
    String filename = "words.json";
    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
    int wordIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        // Run and find the JSON words
        new JSONParse().execute();

        // Keyboard / Full screen Bug Fix
        fixFullscreenKeyboardBug(this);

        // Check keyboard status
        final View rootView = getWindow().getDecorView().findViewById(R.id.main);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
                isKeyboardOpen = heightDiff >= 150;
                android.util.Log.d("heightDiff", "" + heightDiff);
                android.util.Log.d("isKeyboardOpen", "" + isKeyboardOpen);

                if (isKeyboardOpen) {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.blue));
                } else {
                    findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.red));
                }
            }
        });

        // Main Content Area
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
        main.setBackgroundColor(getResources().getColor(R.color.black));

        // Game Content Area
        RelativeLayout game = (RelativeLayout) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isKeyboardOpen) {
                    openKeyboard();
                }
            }
        });

        // Word to Rhyme with
        rhymeGenerated = (EightBitNominalTextView) findViewById(R.id.rhyme_generated);

        // Rhyme entry area and text change listener
        rhymeEntry = (EightBitNominalEditText) findViewById(R.id.rhyme_entry);
        rhymeEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String space = s.toString().replaceAll(" ", "");
                String back = s.toString().replaceAll("\\u003F", "");
                if (!s.toString().equals(space)) {
                    rhymeEntry.setText(space);
                    rhymeEntry.setSelection(space.length());
                }
                if (!s.toString().equals(back)) {
                    rhymeEntry.setText(back);
                    rhymeEntry.setSelection(back.length());
                }

                rhymeGenerated.setText(parsedWords.get(wordIndex += 1));

                JSONObject rhymes;
                try {
                    rhymes = jObject.getJSONObject(TAG_RHYMES);
                    JSONArray singles = rhymes.getJSONArray(TAG_SINGLES);
                    for (int i = 0; i < singles.length(); i++) {
                        Log.d("SINGLES", singles.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void fixFullscreenKeyboardBug(final Activity activity) {

        // Turn off Fullscreen mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Turn on Fullscreen mode
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                AndroidBug5497Workaround.assistActivity(activity);
            }
        }, 100);
    }

    public void openKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(
                InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        rhymeEntry.requestFocus();
    }

    public void closeKeyboard() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(rhymeEntry.getWindowToken(), 0);
    }

    @Override
    public void onPause() {
        super.onPause();
        closeKeyboard();
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

    private class JSONParse extends AsyncTask<String, String, JSONObject> {

        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(GameActivity.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            return jParser.getJSONfromDevice(file);

        }

        @Override
        protected void onPostExecute(JSONObject json) {

            pDialog.dismiss();

            // Hashmap
            ArrayList<HashMap<String, String>> contactList = new ArrayList<>();

            try {
                // Getting Array of Contacts
                words = json.getJSONArray(TAG_WORDS);

                // looping through All Contacts
                for (int i = 0; i < words.length(); i++) {
                    jObject = words.getJSONObject(i);

                    // Storing each json item in variable
                    /*
                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NAME);
                    String email = c.getString(TAG_EMAIL);
                    String address = c.getString(TAG_ADDRESS);
                    String gender = c.getString(TAG_GENDER);

                    // Phone number is again JSON Object
                    JSONObject phone = c.getJSONObject(TAG_PHONE);
                    String mobile = phone.getString(TAG_PHONE_MOBILE);
                    String home = phone.getString(TAG_PHONE_HOME);
                    String office = phone.getString(TAG_PHONE_OFFICE);
                    */

                    // creating new HashMap
                    //HashMap<String, String> map = new HashMap<>();

                    // adding each child node to HashMap key => value
                    //map.put(TAG_ID, id);
                    //map.put(TAG_NAME, name);
                    //map.put(TAG_EMAIL, email);
                    //map.put(TAG_PHONE_MOBILE, mobile);

                    // adding HashList to ArrayList
                    //contactList.add(map);

                    String words = jObject.getString(TAG_WORD);
                    parsedWords.add(words);

                    //contactList.add(map);

                    Collections.shuffle(parsedWords);
                    rhymeGenerated.setText(parsedWords.get(wordIndex));
                }

                JSONObject rhymes = jObject.getJSONObject(TAG_RHYMES);
                JSONArray singles = rhymes.getJSONArray(TAG_SINGLES);
                for (int i = 0; i < singles.length(); i++) {
                    Log.d("SINGLES", singles.toString());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}

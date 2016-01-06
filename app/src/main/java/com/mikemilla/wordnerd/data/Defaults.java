package com.mikemilla.wordnerd.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import bz.tsung.android.objectify.NoSuchPreferenceFoundException;
import bz.tsung.android.objectify.ObjectPreferenceLoader;

public class Defaults {

    private static String WORD_LIST = "WORD_LIST";
    private static String SHOWN_GOOGLE_PLAY_DIALOG = "SHOWN_GOOGLE_PLAY_DIALOG";
    private static String SIGN_INTO_GOOGLE_PLAY_GAMES = "SIGN_INTO_GOOGLE_PLAY_GAMES";
    private static boolean showGooglePlayGamesDialog;
    private static boolean signIntoGooglePlayOnStart;

    public static void setWordList(Response response, BaseGameActivity activity) {
        new ObjectPreferenceLoader(activity, WORD_LIST, Response.class).save(response);
    }

    public static ArrayList<Words> getWordList(BaseGameActivity activity) {
        Response responseObj;
        try {
            responseObj = new ObjectPreferenceLoader(activity, WORD_LIST, Response.class).load();
        } catch (NoSuchPreferenceFoundException e) {
            e.printStackTrace();
            Gson gson = new Gson();
            responseObj = gson.fromJson(loadJSONFromAsset(activity), Response.class);
        }
        return createRhymeLists(responseObj);
    }

    public static String loadJSONFromAsset(BaseGameActivity activity) {
        String json;
        try {
            InputStream is = activity.getResources().getAssets().open("json/words.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private static ArrayList<Words> createRhymeLists(Response responseObj) {

        ArrayList<Words> list = new ArrayList<>();

        for (int i = 0; i < responseObj.getWords().size(); i++) {

            // Add the words
            String word = responseObj.getWords().get(i).getWord();

            // Add the singles
            ArrayList<String> singlesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getSingles() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getSingles().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getSingles().get(d);
                    singlesList.add(words);
                }
            }

            // Add the Doubles
            ArrayList<String> doublesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getDoubles() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getDoubles().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getDoubles().get(d);
                    doublesList.add(words);
                }
            }

            // Add the Triples
            ArrayList<String> triplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getTriples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getTriples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getTriples().get(d);
                    triplesList.add(words);
                }
            }

            // Add the Quads
            ArrayList<String> quadruplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getQuadruples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getQuadruples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getQuadruples().get(d);
                    quadruplesList.add(words);
                }
            }

            // Add the Quins
            ArrayList<String> quintuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getQuintuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getQuintuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getQuintuples().get(d);
                    quintuplesList.add(words);
                }
            }

            // Add the Sexs
            ArrayList<String> sextuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getSextuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getSextuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getSextuples().get(d);
                    sextuplesList.add(words);
                }
            }

            // Add the Seps
            ArrayList<String> septuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getSeptuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getSeptuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getSeptuples().get(d);
                    septuplesList.add(words);
                }
            }

            // Add the Octs
            ArrayList<String> octuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getOctuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getOctuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getOctuples().get(d);
                    octuplesList.add(words);
                }
            }

            // Add the Nons
            ArrayList<String> nonuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getNonuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getNonuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getNonuples().get(d);
                    nonuplesList.add(words);
                }
            }

            // Add the Decs
            ArrayList<String> decuplesList = new ArrayList<>();
            if (responseObj.getWords().get(i).getRhymes().getDecuples() != null) {
                for (int d = 0; d < responseObj.getWords().get(i).getRhymes().getDecuples().size(); d++) {
                    String words = responseObj.getWords().get(i).getRhymes().getDecuples().get(d);
                    decuplesList.add(words);
                }
            }

            // Create a new word object
            // Add it to the words list
            list.add(new Words(word, singlesList, doublesList, triplesList,
                    quadruplesList, quintuplesList, sextuplesList, septuplesList,
                    octuplesList, nonuplesList, decuplesList));
        }

        return list;
    }

    public static boolean getShowGooglePlayGamesDialog(BaseGameActivity activity) {
        showGooglePlayGamesDialog = getActivityPreferences(activity).getBoolean(SHOWN_GOOGLE_PLAY_DIALOG, true);
        return showGooglePlayGamesDialog;
    }

    public static void setShowGooglePlayGamesDialog(boolean shown, BaseGameActivity activity) {
        showGooglePlayGamesDialog = shown;
        SharedPreferences.Editor editor = getActivityPreferences(activity).edit();
        editor.putBoolean(SHOWN_GOOGLE_PLAY_DIALOG, shown);
        editor.apply();
    }

    public static boolean getSignIntoGooglePlayGames(BaseGameActivity activity) {
        signIntoGooglePlayOnStart = getActivityPreferences(activity).getBoolean(SIGN_INTO_GOOGLE_PLAY_GAMES, false);
        return signIntoGooglePlayOnStart;
    }

    public static void setSignIntoGooglePlayGames(boolean signIn, BaseGameActivity activity) {
        signIntoGooglePlayOnStart = signIn;
        SharedPreferences.Editor editor = getActivityPreferences(activity).edit();
        editor.putBoolean(SIGN_INTO_GOOGLE_PLAY_GAMES, signIn);
        editor.apply();
    }

    public static SharedPreferences getActivityPreferences(BaseGameActivity activity) {
        return activity.getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
    }

}
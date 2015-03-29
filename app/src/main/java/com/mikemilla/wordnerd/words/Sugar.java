package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Sugar implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Sugar() {
        doubles.add("RUEGER");
        doubles.add("BOOGER");
        doubles.add("BOOGAR");
        doubles.add("BEGGAR");
        doubles.add("BIGGER");
        doubles.add("BOOKER");
        doubles.add("BOOKIE");
        doubles.add("BUTCHER");
        doubles.add("COOKER");
        doubles.add("COOKIE");
        doubles.add("COOKIES");
        doubles.add("COUGAR");
        doubles.add("ENDURE");
        doubles.add("FOOTER");
        doubles.add("FULLER");
        doubles.add("GOODER");
        doubles.add("HOOKAH");
        doubles.add("HOOKER");
        doubles.add("HUGGER");
        doubles.add("INSURE");
        doubles.add("LOOKER");
        doubles.add("LUGAR");
        doubles.add("LUGER");
        doubles.add("MUGGER");
        doubles.add("PULLER");
        doubles.add("PUSHER");
        doubles.add("ROOKER");
        doubles.add("RUGER");
        doubles.add("SNOOKER");
        doubles.add("SURER");
        doubles.add("TOOKER");
        doubles.add("WOOFER");
    }

    public ArrayList<String> getSingleSyllables() {
        return singles;
    }

    public ArrayList<String> getDoubleSyllables() {
        return doubles;
    }

    public ArrayList<String> getTripleSyllables() {
        return triples;
    }

    public ArrayList<String> getQuadrupleSyllables() {
        return quadruples;
    }

    public ArrayList<String> getQuintupleSyllables() {
        return quintuples;
    }

    public ArrayList<String> getSextupleSyllables() {
        return sextuples;
    }
}

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Gas implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Gas() {
        singles.add("ASS");
        singles.add("BASS");
        singles.add("BLASS");
        singles.add("BRASS");
        singles.add("CASQUE");
        singles.add("CASS");
        singles.add("CHASSE");
        singles.add("CLASS");
        singles.add("CRASS");
        singles.add("DASS");
        singles.add("FAHS");
        singles.add("FASS");
        singles.add("FRASS");
        singles.add("GASS");
        singles.add("GLASS");
        singles.add("GRASS");
        singles.add("HASS");
        singles.add("JASS");
        singles.add("KASS");
        singles.add("KLASS");
        singles.add("KRASS");
        singles.add("KVASS");
        singles.add("LASS");
        singles.add("MASS");
        singles.add("NASS");
        singles.add("PASS");
        singles.add("PLASS");
        singles.add("RAS");
        singles.add("SASS");
        singles.add("TASS");
        singles.add("VASS");
        singles.add("WRASSE");
        singles.add("YASS");
        singles.add("JAZZ");

        doubles.add("ALAS");
        doubles.add("ALSACE");
        doubles.add("AMASS");
        doubles.add("CONTRAST");
        doubles.add("DEPASS");
        doubles.add("FORECAST");
        doubles.add("HARASS");
        doubles.add("IMPASSE");
        doubles.add("LAMBASTES");
        doubles.add("MORASS");
        doubles.add("OUTLAST");
        doubles.add("OUTKAST");
        doubles.add("REPASS");
        doubles.add("SMARTASS");
        doubles.add("SURPASS");
        doubles.add("UMASS");
        doubles.add("VANASSE");
        doubles.add("JACKASS");
        doubles.add("DUMBASS");
        doubles.add("PIZZAZZ");
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

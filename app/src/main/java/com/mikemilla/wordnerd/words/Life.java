package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Life implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Life() {
        singles.add("FIFE");
        singles.add("FYFE");
        singles.add("FYFFE");
        singles.add("GREIFF");
        singles.add("KNIFE");
        singles.add("PFEIFF");
        singles.add("RIFE");
        singles.add("SCHLEIF");
        singles.add("SLIFE");
        singles.add("STREIFF");
        singles.add("STRIFE");
        singles.add("WIFE");
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

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Lake implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Lake() {
        singles.add("ACHE");
        singles.add("AKE");
        singles.add("BAKE");
        singles.add("BLAKE");
        singles.add("BRAKE");
        singles.add("BREAK");
        singles.add("CAKE");
        singles.add("CRAKE");
        singles.add("DAKE");
        singles.add("DRAKE");
        singles.add("FAKE");
        singles.add("FLAKE");
        singles.add("HAIK");
        singles.add("HAKE");
        singles.add("JACQUE");
        singles.add("JAKE");
        singles.add("MAKE");
        singles.add("NAIK");
        singles.add("PAIK");
        singles.add("PAKE");
        singles.add("PLAKE");
        singles.add("QUAKE");
        singles.add("RAKE");
        singles.add("SAKE");
        singles.add("SCHAKE");
        singles.add("SCHLAKE");
        singles.add("SCHNAKE");
        singles.add("SCHWAKE");
        singles.add("SHAIK");
        singles.add("SHAIKH");
        singles.add("SHAKE");
        singles.add("SHRAKE");
        singles.add("SLAKE");
        singles.add("SNAKE");
        singles.add("SPAKE");
        singles.add("STAKE");
        singles.add("STEAK");
        singles.add("STRAKE");
        singles.add("TAKE");
        singles.add("WAKE");
        singles.add("YAKE");
        
        doubles.add("AWAKE");
        doubles.add("BETAKE");
        doubles.add("FORSAKE");
        doubles.add("MISTAKE");
        doubles.add("OPAQUE");
        doubles.add("PARTAKE");
        doubles.add("REMAKE");
        doubles.add("RETAKE");
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

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Mint implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Mint() {
        singles.add("CLINT");
        singles.add("DINT");
        singles.add("FLINT");
        singles.add("FLYNT");
        singles.add("GLINT");
        singles.add("HINT");
        singles.add("KINDT");
        singles.add("KINT");
        singles.add("KLINDT");
        singles.add("KLINT");
        singles.add("LINT");
        singles.add("PRINT");
        singles.add("QUINT");
        singles.add("RINDT");
        singles.add("SCHWINDT");
        singles.add("SINDT");
        singles.add("SKINT");
        singles.add("SPLINT");
        singles.add("SPRINT");
        singles.add("SQUINT");
        singles.add("STINT");
        singles.add("SWINT");
        singles.add("TINT");
        singles.add("VINT");
        singles.add("WINDT");
        singles.add("WINT");
        
        doubles.add("IMPRINT");
        doubles.add("MISPRINT");
        doubles.add("REPRINT");
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

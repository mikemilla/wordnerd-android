package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Pearl implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Pearl() {
        singles.add("BERLE");
        singles.add("BIRLE");
        singles.add("BURL");
        singles.add("CURL");
        singles.add("EARL");
        singles.add("EARLE");
        singles.add("EARLL");
        singles.add("ERL");
        singles.add("GIRL");
        singles.add("HEARL");
        singles.add("HERL");
        singles.add("HURL");
        singles.add("KERL");
        singles.add("MERL");
        singles.add("MERLE");
        singles.add("NERL");
        singles.add("PEARLE");
        singles.add("SEARL");
        singles.add("SEARLE");
        singles.add("SHIRL");
        singles.add("SPERL");
        singles.add("SPERLE");
        singles.add("SWIRL");
        singles.add("TWIRL");
        singles.add("WERLE");
        singles.add("WHIRL");
        singles.add("WHORL");
        singles.add("WURL");
        singles.add("WORLD");

        doubles.add("COWGIRL");
        doubles.add("UNFURL");

        singles.add("CARL");
        singles.add("GNARL");
        singles.add("HARL");
        singles.add("SNARL");

        doubles.add("ENSNARL");
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

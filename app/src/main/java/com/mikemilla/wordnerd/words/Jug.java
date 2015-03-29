package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Jug implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Jug() {
        singles.add("BUG");
        singles.add("CHUG");
        singles.add("DOUG");
        singles.add("DRUG");
        singles.add("DUG");
        singles.add("DEBUG");
        singles.add("HUG");
        singles.add("HUGG");
        singles.add("KLUG");
        singles.add("KRUG");
        singles.add("LUG");
        singles.add("NUG");
        singles.add("MUG");
        singles.add("PLUG");
        singles.add("PUG");
        singles.add("RUG");
        singles.add("RUGG");
        singles.add("SCHUG");
        singles.add("SHRUG");
        singles.add("SLUG");
        singles.add("SMUG");
        singles.add("SNUG");
        singles.add("SUGG");
        singles.add("THUG");
        singles.add("TUG");
        singles.add("UGH");
        singles.add("ZUG");
        
        doubles.add("UNPLUG");
        
        triples.add("ANTIDRUG");
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

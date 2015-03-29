package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Funk implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Funk() {
        singles.add("BLUNCK");
        singles.add("BLUNK");
        singles.add("BRUNK");
        singles.add("BUNK");
        singles.add("CHUNK");
        singles.add("CLUNK");
        singles.add("CRUNK");
        singles.add("DRUNK");
        singles.add("DUNC");
        singles.add("DUNK");
        singles.add("FLUNK");
        singles.add("FUNCK");
        singles.add("FUNKE");
        singles.add("HUNK");
        singles.add("JUHNKE");
        singles.add("JUNK");
        singles.add("KLUNK");
        singles.add("KUHNKE");
        singles.add("MONK");
        singles.add("MUNK");
        singles.add("PLUNK");
        singles.add("PUNK");
        singles.add("RUHNKE");
        singles.add("RUNCK");
        singles.add("RUNK");
        singles.add("SCHMUNK");
        singles.add("SCHUNK");
        singles.add("SHRUNK");
        singles.add("SHUNK");
        singles.add("SKUNK");
        singles.add("SLUNK");
        singles.add("SPUNK");
        singles.add("STRUNK");
        singles.add("STUNK");
        singles.add("SUNK");
        singles.add("TRUNK");
        singles.add("YUNK");
        singles.add("THUNK");
        singles.add("KRUNK");

        doubles.add("DEBUNK");
        doubles.add("FINUNC");
        doubles.add("SPELUNK");
        doubles.add("VANDUNK");
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

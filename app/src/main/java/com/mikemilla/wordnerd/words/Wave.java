package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Wave implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Wave() {
        singles.add("BRAVE");
        singles.add("CAVE");
        singles.add("CRAVE");
        singles.add("DAVE");
        singles.add("FAVE");
        singles.add("GAVE");
        singles.add("GRAVE");
        singles.add("KNAVE");
        singles.add("LAVE");
        singles.add("MAVE");
        singles.add("NAVE");
        singles.add("PAVE");
        singles.add("QUAVE");
        singles.add("RAVE");
        singles.add("SAVE");
        singles.add("SCHAVE");
        singles.add("SHAVE");
        singles.add("SLAVE");
        singles.add("STAVE");
        singles.add("TRAVE");
        
        doubles.add("BEHAVE");
        doubles.add("CONCAVE");
        doubles.add("DEPRAVE");
        doubles.add("ENGRAVE");
        doubles.add("ENSLAVE");
        doubles.add("FORGAVE");
        doubles.add("KUNAEV");
        doubles.add("LAFAVE");
        doubles.add("LEFAVE");
        doubles.add("MCCLAVE");
        doubles.add("SHORTWAVE");
        
        triples.add("AFTERSHAVE");
        triples.add("MISBEHAVE");
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

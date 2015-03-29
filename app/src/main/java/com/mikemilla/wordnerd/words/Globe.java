package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Globe implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Globe() {
        singles.add("BOBE");
        singles.add("COBE");
        singles.add("GROBE");
        singles.add("JOBE");
        singles.add("LOBE");
        singles.add("LOEB");
        singles.add("MOBE");
        singles.add("PROBE");
        singles.add("ROBE");
        singles.add("SHOBE");
        singles.add("STROBE");
        singles.add("THOBE");
        singles.add("TOBE");
        
        doubles.add("LATROBE");
        doubles.add("WARDROBE");
        doubles.add("DISROBE");
        doubles.add("BATHROBE");
        doubles.add("IMPLODE");
        doubles.add("EXPLODE");
        doubles.add("MICROBE");

        triples.add("CLAUSTROPHOBE");

        quadruples.add("HELIOPHOBE");

        singles.add("COPE");
        singles.add("CODE");
        singles.add("DOPE");
        singles.add("GROPE");
        singles.add("HOPE");
        singles.add("LOPE");
        singles.add("MOPE");
        singles.add("NOPE");
        singles.add("POPE");
        singles.add("ROPE");
        singles.add("SCOPE");
        singles.add("SLOPE");
        singles.add("SOAP");
        singles.add("TOPE");
        singles.add("ELOPE");
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

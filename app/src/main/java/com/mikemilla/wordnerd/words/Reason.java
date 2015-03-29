package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Reason implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Reason() {
        doubles.add("BEASON");
        doubles.add("BEESON");
        doubles.add("DEASON");
        doubles.add("DRESEN");
        doubles.add("EASON");
        doubles.add("FRIESON");
        doubles.add("GLEESON");
        doubles.add("SEASON");
        doubles.add("TREASON");
        
        triples.add("ARNESEN");
        triples.add("MATHIESON");
        triples.add("MIDSEASON");
        triples.add("SALVESEN");
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

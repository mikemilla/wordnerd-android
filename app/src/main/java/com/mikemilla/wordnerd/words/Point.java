package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Point implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Point() {
        doubles.add("CONJOINT");

        singles.add("JOINT");
        singles.add("JOYNT");
        
        doubles.add("ANOINT");
        doubles.add("APPOINT");
        doubles.add("DISJOINT");
        doubles.add("LAPOINT");
        doubles.add("LAPOINTE");
        doubles.add("PIERPOINT");
        doubles.add("DATAPOINT");

        triples.add("DISAPPOINT");
        triples.add("REAPPOINT");
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

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Lesson implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Lesson() {
        doubles.add("SESSION");
        
        quintuples.add("INVESTIGATION");
        quintuples.add("INDIGESTION");

        triples.add("DIRECTION");
        triples.add("CORRECTION");
        triples.add("CONNECTION");
        
        doubles.add("QUESTION");
        
        triples.add("DIGESTION");
        
        doubles.add("BESSON");
        doubles.add("BRESSON");
        doubles.add("CAISSON");
        doubles.add("CHESSON");
        doubles.add("CRESON");
        doubles.add("CRESSON");
        doubles.add("DRESSEN");
        doubles.add("ESSEN");
        doubles.add("ESSON");
        doubles.add("HESSON");
        doubles.add("JESSEN");
        doubles.add("JESSON");
        doubles.add("KESSEN");
        doubles.add("KESTEN");
        doubles.add("LESSEN");
        doubles.add("PRESSON");
        doubles.add("WESSON");
        doubles.add("WESTON");
        doubles.add("YESEN");
        
        quadruples.add("DELICATESSEN");
        
        triples.add("RECESSION");
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

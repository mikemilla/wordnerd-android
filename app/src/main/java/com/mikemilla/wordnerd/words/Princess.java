package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Princess implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Princess() {
        doubles.add("BUSINESS");
        doubles.add("CHRISTMAS");
        doubles.add("CONVINCE");
        doubles.add("DINNER");
        doubles.add("FEARLESS");
        doubles.add("FITNESS");
        doubles.add("ILLNESS");
        doubles.add("INDEX");
        doubles.add("INSECT");
        doubles.add("INVEST");
        doubles.add("INSECTS");
        doubles.add("INSENSE");
        doubles.add("INSTANCE");
        doubles.add("KISSES");
        doubles.add("LISTEN");
        doubles.add("MINCES");
        doubles.add("MINUTE");
        doubles.add("MISSES");
        doubles.add("MISSION");
        doubles.add("MISSUS");
        
        doubles.add("RINSES");
        doubles.add("SICKNESS");
        doubles.add("VICIOUS");
        doubles.add("WINCES");
        doubles.add("WINLESS");
        doubles.add("WISHES");
        doubles.add("WITNESS");
        
        triples.add("AMBITIOUS");
        triples.add("CONVINCES");
        triples.add("DELICIOUS");
        triples.add("FORGIVENESS");
        
        quadruples.add("DELICIOUSNESS");
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

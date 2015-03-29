package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Crooks implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Crooks() {
        singles.add("BROOKES");
        singles.add("BROOKS");
        singles.add("COOKS");
        singles.add("BOOKS");
        singles.add("FOOKS");
        singles.add("HOOKS");
        singles.add("LOOKS");
        singles.add("NOOKS");
        singles.add("ROOKS");
        singles.add("SCHNOOKS");
        singles.add("SNOOKS");
        singles.add("TOOKES");
        
        doubles.add("CHINOOKS");
        doubles.add("OVERCOOKS");
        doubles.add("OVERCROOKS");
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

    @Override
    public ArrayList<String> getSextupleSyllables() {
        return sextuples;
    }

}

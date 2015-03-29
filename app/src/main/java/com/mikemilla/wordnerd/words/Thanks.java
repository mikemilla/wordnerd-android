package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Thanks implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Thanks() {
        singles.add("BANKES");
        singles.add("BLANKS");
        singles.add("BRANKS");
        singles.add("BANKS");
        singles.add("CRANKS");
        singles.add("DANKS");
        singles.add("FLANKS");
        singles.add("FRANCS");
        singles.add("FRANKS");
        singles.add("HANKES");
        singles.add("HANKS");
        singles.add("MANX");
        singles.add("PLANKS");
        singles.add("PRANKS");
        singles.add("RANKS");
        singles.add("SANKS");
        singles.add("SHANKS");
        singles.add("TANKS");
        singles.add("YANKS");

        singles.add("CAMPS");
        singles.add("CRAMPS");
        singles.add("LAMPS");
        singles.add("STAMPS");
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

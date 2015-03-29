package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Tusk implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Tusk() {
        singles.add("BRUSKE");
        singles.add("BRUSQUE");
        singles.add("BUSK");
        singles.add("BUSKE");
        singles.add("CUSK");
        singles.add("DUSK");
        singles.add("HUSK");
        singles.add("KUSKE");
        singles.add("LUSK");
        singles.add("MUSK");
        singles.add("RUSK");
        
        doubles.add("MOLLUSK");
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

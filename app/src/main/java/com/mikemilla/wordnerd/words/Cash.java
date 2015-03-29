package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Cash implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Cash() {
        singles.add("ASCH");
        singles.add("ASH");
        singles.add("BASCH");
        singles.add("BASH");
        singles.add("BRASCH");
        singles.add("BRASH");
        singles.add("CACHE");
        singles.add("CLASH");
        singles.add("CRASH");
        singles.add("DASCH");
        singles.add("DASH");
        singles.add("FLASCH");
        singles.add("FLASH");
        singles.add("FRASCH");
        singles.add("GASH");
        singles.add("GNASH");
        singles.add("GUASCH");
        singles.add("HASCH");
        singles.add("HASH");
        singles.add("KASCH");
        singles.add("KASH");
        singles.add("LASCH");
        singles.add("LASH");
        singles.add("MASCH");
        singles.add("MASH");
        singles.add("NASH");
        singles.add("PASH");
        singles.add("PLASH");
        singles.add("RASCH");
        singles.add("RASH");
        singles.add("SASH");
        singles.add("SLASH");
        singles.add("SMASH");
        singles.add("SPLASH");
        singles.add("STASH");
        singles.add("TASCH");
        singles.add("TASH");
        singles.add("THRASH");
        singles.add("TRASH");
        
        doubles.add("ABASH");
        doubles.add("FURASH");
        doubles.add("LUKASH");
        doubles.add("PRECRASH");
        doubles.add("REHASH");
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

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Tux implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Tux() {
        singles.add("BRUCKS");
        singles.add("BUCHS");
        singles.add("BUCKS");
        singles.add("BUCS");
        singles.add("CLUCKS");
        singles.add("CRUX");
        singles.add("DUCKS");
        singles.add("DUX");
        singles.add("FLUX");
        singles.add("FUCKS");
        singles.add("HUCKS");
        singles.add("HUX");
        singles.add("KLUX");
        singles.add("LUCKS");
        singles.add("LUKS");
        singles.add("LUX");
        singles.add("PLUCKS");
        singles.add("RUCKS");
        singles.add("RUX");
        singles.add("SHUCKS");
        singles.add("SUCKS");
        singles.add("SZUCS");
        singles.add("TRUCKS");
        singles.add("TRUCKS'");
        singles.add("TUCKS");
        singles.add("TUKS");
        singles.add("YUKS");
        
        doubles.add("CANUCKS");
        doubles.add("DELUXE");
        
        singles.add("CUPS");
        singles.add("UPS");
        singles.add("PUPS");
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

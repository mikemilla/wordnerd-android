package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Discuss implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Discuss() {
        singles.add("BRUS");
        singles.add("BUS");
        singles.add("CUS");
        singles.add("DUST");
        singles.add("FUHS");
        singles.add("FUSS");
        singles.add("GRUSS");
        singles.add("GUS");
        singles.add("HUSS");
        singles.add("KLUS");
        singles.add("KRUS");
        singles.add("KUS");
        singles.add("MUHS");
        singles.add("NUSS");
        singles.add("PLUS");
        singles.add("PRUS");
        singles.add("PUS");
        singles.add("RUS");
        singles.add("RUST");
        singles.add("SCHUSS");
        singles.add("SHAS");
        singles.add("SLUSS");
        singles.add("STRUSS");
        singles.add("SUS");
        singles.add("THUS");
        singles.add("TRUSS");
        singles.add("US");
        singles.add("WASS");
        singles.add("WUSS");
        singles.add("XUS");
        singles.add("MUST");

        doubles.add("ADJUSTS");
        doubles.add("CAREPLUS");
        doubles.add("MISTRUSTS");
        doubles.add("NONPLUSS");
        doubles.add("VANHUSS");
        
        triples.add("BANDERAS");
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

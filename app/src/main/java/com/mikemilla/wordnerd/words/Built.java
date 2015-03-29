package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Built implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Built() {
        singles.add("BILDT");
        singles.add("GILT");
        singles.add("GUILT");
        singles.add("HILT");
        singles.add("JILT");
        singles.add("KILT");
        singles.add("LILT");
        singles.add("MILT");
        singles.add("QUILT");
        singles.add("SCHILDT");
        singles.add("SCHILT");
        singles.add("SILT");
        singles.add("SPILT");
        singles.add("STILT");
        singles.add("TILT");
        singles.add("WILDT");
        singles.add("WILT");
        singles.add("PILT");

        doubles.add("WELBILT");
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

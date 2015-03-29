package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Quiz implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Quiz() {
        singles.add("BIZ");
        singles.add("BUIS");
        singles.add("CZYZ");
        singles.add("FIZZ");
        singles.add("FRIZZ");
        singles.add("GRIZ");
        singles.add("HIS");
        singles.add("IS");
        singles.add("KRIZ");
        singles.add("LIZ");
        singles.add("RIZ");
        singles.add("TIS");
        singles.add("WHIZ");
        singles.add("WIZ");
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

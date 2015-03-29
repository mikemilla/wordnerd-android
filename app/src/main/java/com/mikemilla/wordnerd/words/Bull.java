package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Bull implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Bull() {
        singles.add("FULL");
        singles.add("KUEHL");
        singles.add("PULL");
        singles.add("RUEHL");
        singles.add("SCHUL");
        singles.add("WOOL");
        singles.add("SKULL");
        singles.add("DULL");
        singles.add("HULL");
        singles.add("NULL");
        singles.add("GULL");
        singles.add("COAL");
        singles.add("SOUL");
        singles.add("SOLE");
        singles.add("POLL");
        singles.add("POLE");
        singles.add("MOLE");
        singles.add("BOWL");

        doubles.add("NORMAL");

        triples.add("ABNORMAL");
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

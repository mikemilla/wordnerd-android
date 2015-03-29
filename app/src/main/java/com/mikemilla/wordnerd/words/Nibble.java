package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Nibble implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Nibble() {
        doubles.add("NIPPLE");
        doubles.add("TRIPLE");
        doubles.add("RIPPLE");
        doubles.add("GIGGLE");
        doubles.add("RIDDLE");
        doubles.add("KIMBLE");
        doubles.add("KIMMEL");
        doubles.add("THIMBLE");
        doubles.add("NIMBLE");
        doubles.add("FRIBBLE");
        doubles.add("NYBBLE");
        doubles.add("DIBBLE");
        doubles.add("DIBOLL");
        doubles.add("DRIBBLE");
        doubles.add("GIBBLE");
        doubles.add("GRIBBLE");
        doubles.add("HYBL");
        doubles.add("KIBBEL");
        doubles.add("KIBBLE");
        doubles.add("KIBELL");
        doubles.add("PRIBBLE");
        doubles.add("PRIBYL");
        doubles.add("QUIBBLE");
        doubles.add("RIBBLE");
        doubles.add("SCRIBBLE");
        doubles.add("SIBIL");
        doubles.add("SIBYL");
        doubles.add("STIBEL");
        doubles.add("TRIBBLE");
        doubles.add("TRIBLE");
        doubles.add("TRIBULL");
        doubles.add("PRZYBYL");
        doubles.add("WIGGLE");
        doubles.add("GIGGLE");
        doubles.add("PICKLE");
        doubles.add("NICKLE");
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

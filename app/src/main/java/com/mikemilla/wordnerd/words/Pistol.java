package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Pistol implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Pistol() {
        doubles.add("NICKLE");
        doubles.add("PICKLE");
        doubles.add("TICKLE");
        doubles.add("WHISTLE");
        doubles.add("MISSLE");
        doubles.add("MISSILE");
        doubles.add("BRISTOL");
        doubles.add("CHRISTAL");
        doubles.add("CHRISTEL");
        doubles.add("CHRYSTAL");
        doubles.add("CRISTAL");
        doubles.add("CRYSTAL");
        doubles.add("DISTAL");
        doubles.add("DISTEL");
        doubles.add("KRISTALL");
        doubles.add("KRISTOL");
        doubles.add("KRYSTAL");
        doubles.add("PISTIL");
        doubles.add("FISCAL");
        doubles.add("THISTLE");
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

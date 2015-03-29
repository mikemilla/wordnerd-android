package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Sense implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Sense() {
        singles.add("BENCE");
        singles.add("CENSE");
        singles.add("CENTS");
        singles.add("DENSE");
        singles.add("FENCE");
        singles.add("FLENSE");
        singles.add("HENCE");
        singles.add("HENSE");
        singles.add("PENCE");
        singles.add("PENSE");
        singles.add("SPENCE");
        singles.add("SPENS");
        singles.add("TENSE");
        singles.add("THENCE");
        singles.add("WHENCE");
        
        doubles.add("COMMENCE");
        doubles.add("CONDENSE");
        doubles.add("DEFENCE");
        doubles.add("DEFENSE");
        doubles.add("DISPENSE");
        doubles.add("EXPENSE");
        doubles.add("FERENC");
        doubles.add("IMMENSE");
        doubles.add("INCENSE");
        doubles.add("INTENSE");
        doubles.add("OFFENSE");
        doubles.add("PRETENSE");
        doubles.add("SUSPENSE");
        
        triples.add("COMMONSENSE");
        triples.add("NONDEFENSE");
        triples.add("MISREPRESENTS");
        
        singles.add("CENTS");
        singles.add("RENTS");
        
        doubles.add("CONTENTS");
        doubles.add("EVENTS");
        doubles.add("LORENZ");
        doubles.add("PRESENTS");
        doubles.add("SEGMENTS");
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

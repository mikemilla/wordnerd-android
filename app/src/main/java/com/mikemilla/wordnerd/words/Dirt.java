package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Dirt implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Dirt() {
        singles.add("BERT");
        singles.add("BIRT");
        singles.add("BLURT");
        singles.add("BURT");
        singles.add("CHERT");
        singles.add("CURT");
        singles.add("ERTE");
        singles.add("FLIRT");
        singles.add("GERT");
        singles.add("GIRT");
        singles.add("HERDT");
        singles.add("HERT");
        singles.add("HIRT");
        singles.add("HURT");
        singles.add("KIRT");
        singles.add("KUHRT");
        singles.add("KURT");
        singles.add("PEART");
        singles.add("PERT");
        singles.add("PURT");
        singles.add("QUIRT");
        singles.add("SCHWERDT");
        singles.add("SHIRT");
        singles.add("SKIRT");
        singles.add("SPURT");
        singles.add("SQUIRT");
        singles.add("VERT");
        singles.add("WERT");
        singles.add("WIRT");
        
        doubles.add("ALERT");
        doubles.add("ASSERT");
        doubles.add("AVERT");
        doubles.add("BOISVERT");
        doubles.add("CONCERT");
        doubles.add("CONVERT");
        doubles.add("DESERT");
        doubles.add("DESSERT");
        doubles.add("DILBERT");
        doubles.add("DIVERT");
        doubles.add("EVERT");
        doubles.add("EXERT");
        doubles.add("INERT");
        doubles.add("INSERT");
        doubles.add("INVERT");
        doubles.add("MCGIRT");
        doubles.add("MCGUIRT");
        doubles.add("MCWHIRT");
        doubles.add("OVERT");
        doubles.add("PERVERT");
        doubles.add("REVERT");
        doubles.add("SUBVERT");
        doubles.add("THIBERT");
        doubles.add("TURRET");
        doubles.add("UNHURT");
        doubles.add("VANWERT");
        
        triples.add("REASSERT");
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

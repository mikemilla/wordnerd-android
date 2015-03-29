package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Loom implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Loom() {
        singles.add("BLOOM");
        singles.add("BLUM");
        singles.add("BLUME");
        singles.add("BOOM");
        singles.add("BROOM");
        singles.add("COOMBE");
        singles.add("CROOM");
        singles.add("CRUME");
        singles.add("DOOM");
        singles.add("FLUME");
        singles.add("FLOOM");
        singles.add("FUME");
        singles.add("GLOOM");
        singles.add("GLUME");
        singles.add("GROOM");
        singles.add("GRUME");
        singles.add("HUME");
        singles.add("KUME");
        singles.add("PLUME");
        singles.add("REAUME");
        singles.add("RHEAUME");
        singles.add("RHEUM");
        singles.add("ROOM");
        singles.add("ROOME");
        singles.add("SPUME");
        singles.add("SUHM");
        singles.add("TOMB");
        singles.add("VROOM");
        singles.add("WHOM");
        singles.add("WOMB");
        singles.add("ZOOM");

        doubles.add("ABLOOM");
        doubles.add("ASSUME");
        doubles.add("CONSUME");
        doubles.add("COSTUME");
        doubles.add("DEBLUM");
        doubles.add("ENTOMB");
        doubles.add("EXHUME");
        doubles.add("KABOOM");
        doubles.add("KHARTOUM");
        doubles.add("LAPLUME");
        doubles.add("LEGROOM");
        doubles.add("MAKTOUM");
        doubles.add("MCBROOM");
        doubles.add("PERFUME");
        doubles.add("PRESUME");
        doubles.add("RESUME");
        doubles.add("MUSHROOM");
        doubles.add("CARTOON");
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

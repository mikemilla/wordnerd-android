package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Slim implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Slim() {
        singles.add("BIHM");
        singles.add("BRIM");
        singles.add("CLIM");
        singles.add("CRIM");
        singles.add("DIM");
        singles.add("FLIM");
        singles.add("GRIM");
        singles.add("GYM");
        singles.add("HIM");
        singles.add("HYMN");
        singles.add("JIM");
        singles.add("KIM");
        singles.add("KLIM");
        singles.add("KLYM");
        singles.add("KRIM");
        singles.add("KYM");
        singles.add("LIM");
        singles.add("MIHM");
        singles.add("MIM");
        singles.add("PIMM");
        singles.add("PRIM");
        singles.add("PYMM");
        singles.add("SCRIM");
        singles.add("SHIM");
        singles.add("SIM");
        singles.add("SKIM");
        singles.add("RIM");
        singles.add("SWIM");
        singles.add("SYM");
        singles.add("TIM");
        singles.add("TRIM");
        singles.add("VIM");
        singles.add("WHIM");
        singles.add("YIM");
        singles.add("ZIM");

        doubles.add("MCKIM");
        doubles.add("PRELIM");

        triples.add("KIBBUTZIM");
        triples.add("PATRONYM");
        triples.add("SYNONYM");
        triples.add("ANTONYM");
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

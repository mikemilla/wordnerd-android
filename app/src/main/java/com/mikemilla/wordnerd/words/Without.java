package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Without implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Without() {
        singles.add("BOUT");
        singles.add("CLOUT");
        singles.add("CROUT");
        singles.add("DOUBT");
        singles.add("DOUTT");
        singles.add("DROUGHT");
        singles.add("FLOUT");
        singles.add("FOUT");
        singles.add("GOUT");
        singles.add("GROUT");
        singles.add("HOUT");
        singles.add("KNOUT");
        singles.add("KRAUT");
        singles.add("KROUT");
        singles.add("LOUT");
        singles.add("OUT");
        singles.add("POUT");
        singles.add("PROUT");
        singles.add("RAUT");
        singles.add("ROUTE");
        singles.add("ROUTT");
        singles.add("SCOUT");
        singles.add("SHOUT");
        singles.add("SHROUT");
        singles.add("SNOUT");
        singles.add("SPOUT");
        singles.add("STOUT");
        singles.add("STROUT");
        singles.add("THUOT");
        singles.add("TOUT");
        singles.add("DEVOUT");
        singles.add("ABOUND");

        doubles.add("ACCOUNT");
        doubles.add("ALLOWED");
        doubles.add("ALOUD");
        doubles.add("ABOUT");
        doubles.add("AMOUNT");
        doubles.add("ANNOUNCE");
        doubles.add("AROUND");
        doubles.add("AROUSE");
        doubles.add("AROUSED");
        doubles.add("DISCOUNT");
        doubles.add("DOWNTOWN");
        doubles.add("ENDOW");
        doubles.add("HOUR");
        doubles.add("MEOW");
        doubles.add("PROFOUND");
        doubles.add("PRONOUNCE");
        doubles.add("RECOUNT");
        doubles.add("RENOWN");
        doubles.add("SURMOUNT");
        doubles.add("SURROUND");
        doubles.add("SURROUND");

        doubles.add("THEREABOUT");

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

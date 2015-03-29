package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Gun implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Gun() {
        singles.add("BRUHN");
        singles.add("BRUN");
        singles.add("BUN");
        singles.add("BYUN");
        singles.add("CHUN");
        singles.add("DONE");
        singles.add("DUN");
        singles.add("FUN");
        singles.add("GRUHN");
        singles.add("GRUN");
        singles.add("HUHN");
        singles.add("HUN");
        singles.add("JUN");
        singles.add("KUHNE");
        singles.add("KUN");
        singles.add("LUHN");
        singles.add("LUN");
        singles.add("MUN");
        singles.add("NONE");
        singles.add("NUHN");
        singles.add("NUN");
        singles.add("ONE");
        singles.add("PUN");
        singles.add("RUN");
        singles.add("SHUN");
        singles.add("SON");
        singles.add("SPUN");
        singles.add("STUN");
        singles.add("SUN");
        singles.add("THRUN");
        singles.add("THUN");
        singles.add("TON");
        singles.add("WON");
        singles.add("YOUN");
        singles.add("YUN");

        doubles.add("BEGUN");
        doubles.add("HOMERUN");
        doubles.add("LAJEUNE");
        doubles.add("MCFUN");
        doubles.add("MCMUNN");
        doubles.add("OUTDONE");
        doubles.add("OUTRUN");
        doubles.add("REDONE");
        doubles.add("RERUN");
        doubles.add("UNDONE");

        triples.add("OVERDONE");
        triples.add("UNDERDONE");
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

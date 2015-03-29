package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Restart implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Restart() {
        singles.add("BART");
        singles.add("CART");
        singles.add("CHART");
        singles.add("DART");
        singles.add("FART");
        singles.add("HAART");
        singles.add("HARDT");
        singles.add("HART");
        singles.add("HEART");
        singles.add("MAHRT");
        singles.add("MART");
        singles.add("PART");
        singles.add("SCHARDT");
        singles.add("SMART");
        singles.add("START");
        singles.add("TART");
        singles.add("ART");

        doubles.add("AHART");
        doubles.add("APART");
        doubles.add("BOSSART");
        doubles.add("DEPART");
        doubles.add("DESCARTES");
        doubles.add("GOULART");
        doubles.add("IMPART");
        doubles.add("KABART");
        doubles.add("MCCART");

        singles.add("BERT");
        singles.add("BIRT");
        singles.add("BLURT");
        singles.add("BORT");
        singles.add("BURT");
        singles.add("CHERT");
        singles.add("CORT");
        singles.add("COURT");
        singles.add("CURT");
        singles.add("DIRT");
        singles.add("DORT");
        singles.add("FLIRT");
        singles.add("FORT");
        singles.add("GIRT");
        singles.add("HURT");
        singles.add("MORT");
        singles.add("ORT");
        singles.add("PEART");
        singles.add("PERT");
        singles.add("PORT");
        singles.add("QUART");
        singles.add("SHIRT");
        singles.add("SHORT");
        singles.add("SKIRT");
        singles.add("SNORT");
        singles.add("SORT");
        singles.add("SPORT");
        singles.add("SPURT");
        singles.add("SQUIRT");
        singles.add("SWART");
        singles.add("THWART");
        singles.add("TORT");
        singles.add("VERT");
        singles.add("WART");
        singles.add("WERT");
        singles.add("YURT");

        doubles.add("ABORT");
        doubles.add("ALERT");
        doubles.add("ASSERT");
        doubles.add("ASSORT");
        doubles.add("ATHWART");
        doubles.add("AVERT");
        doubles.add("CAVORT");
        doubles.add("COMPORT");
        doubles.add("CONCERT");
        doubles.add("CONSORT");
        doubles.add("CONTORT");
        doubles.add("CONVERT");
        doubles.add("DEPORT");
        doubles.add("DESERT");
        doubles.add("DESSERT");
        doubles.add("DISTORT");
        doubles.add("DIVERT");
        doubles.add("ESCORT");
        doubles.add("EVERT");
        doubles.add("EXERT");
        doubles.add("EXHORT");
        doubles.add("EXTORT");
        doubles.add("FORTE");
        doubles.add("IMPORT");
        doubles.add("INERT");
        doubles.add("INSERT");
        doubles.add("INVERT");
        doubles.add("OVERT");
        doubles.add("PERVERT");
        doubles.add("PURPORT");
        doubles.add("REPORT");
        doubles.add("RESORT");
        doubles.add("REVERT");
        doubles.add("STUART");
        doubles.add("SUBVERT");
        doubles.add("SUPPORT");
        doubles.add("TRANSPORT");
        doubles.add("TURRET");
        doubles.add("UNHURT");

        triples.add("DISCONCERT");
        triples.add("MISREPORT");
        triples.add("REASSERT");
        triples.add("TELEPORT");
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

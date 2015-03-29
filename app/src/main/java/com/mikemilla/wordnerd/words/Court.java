package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Court implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Court() {
        singles.add("BOART");
        singles.add("BORT");
        singles.add("CORT");
        singles.add("DORT");
        singles.add("FORET");
        singles.add("FORT");
        singles.add("GORT");
        singles.add("KORT");
        singles.add("MORT");
        singles.add("NORTE");
        singles.add("OHRT");
        singles.add("ORT");
        singles.add("PORT");
        singles.add("QUART");
        singles.add("SHORT");
        singles.add("SNORT");
        singles.add("SORT");
        singles.add("SPORT");
        singles.add("SWART");
        singles.add("THWART");
        singles.add("TORT");
        singles.add("WART");
        singles.add("ZWART");
        
        doubles.add("ABORT");
        doubles.add("ASSORT");
        doubles.add("ATHWART");
        doubles.add("CAVORT");
        doubles.add("COMPORT");
        doubles.add("CONSORT");
        doubles.add("CONTORT");
        doubles.add("DEPORT");
        doubles.add("DISTORT");
        doubles.add("ESCORT");
        doubles.add("EXHORT");
        doubles.add("EXTORT");
        doubles.add("FORTE");
        doubles.add("HJORT");
        doubles.add("IMPORT");
        doubles.add("JEANCOURT");
        doubles.add("LAFORTE");
        doubles.add("LAPORTE");
        doubles.add("MCCORT");
        doubles.add("MCCOURT");
        doubles.add("PRECOURT");
        doubles.add("PURPORT");
        doubles.add("RANCOURT");
        doubles.add("REPORT");
        doubles.add("RESORT");
        doubles.add("RETORT");
        doubles.add("STUART");
        doubles.add("SUPPORT");
        doubles.add("TRANSPORT");
        doubles.add("VALCOURT");
        doubles.add("VANCOURT");
        doubles.add("VANWART");
        
        triples.add("TELEPORT");
        triples.add("MISREPORT");
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

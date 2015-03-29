package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Cup implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Cup() {
        singles.add("BUPP");
        singles.add("CHUPP");
        singles.add("GRUPP");
        singles.add("HUPP");
        singles.add("KNUPP");
        singles.add("KRUPP");
        singles.add("PUP");
        singles.add("RUPP");
        singles.add("SCHLUP");
        singles.add("SCHRUPP");
        singles.add("SCHUPP");
        singles.add("SHUPP");
        singles.add("STRUPP");
        singles.add("STUPP");
        singles.add("SUP");
        singles.add("TRUPP");
        singles.add("UP");
        singles.add("YUP");

        doubles.add("SETUP");
        doubles.add("SIRUP");
        doubles.add("SYRUP");
        doubles.add("STIRRUP");
        doubles.add("EUROPE");
        doubles.add("STEPUP");

        singles.add("CHUMP");
        singles.add("CLUMP");
        singles.add("CRUMP");
        singles.add("DUMP");
        singles.add("FLUMP");
        singles.add("FRUMP");
        singles.add("GRUMP");
        singles.add("GUMP");
        singles.add("HUMP");
        singles.add("JUMP");
        singles.add("KLUMP");
        singles.add("KUMP");
        singles.add("LUMP");
        singles.add("PLUMP");
        singles.add("PUMP");
        singles.add("RUMP");
        singles.add("SLUMP");
        singles.add("STUMP");
        singles.add("SUMP");
        singles.add("THUMP");
        singles.add("TRUMP");
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

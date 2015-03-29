package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Dog implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Dog() {
        singles.add("BLOG");
        singles.add("BOG");
        singles.add("CLAGUE");
        singles.add("CLOG");
        singles.add("COG");
        singles.add("DAGUE");
        singles.add("FLOG");
        singles.add("FOG");
        singles.add("FROG");
        singles.add("GROG");
        singles.add("HAAG");
        singles.add("HAUG");
        singles.add("HOG");
        singles.add("JOG");
        singles.add("KROG");
        singles.add("LAGUE");
        singles.add("LOG");
        singles.add("MAAG");
        singles.add("MOGG");
        singles.add("PLOG");
        singles.add("POG");
        singles.add("PRAGUE");
        singles.add("ROG");
        singles.add("SKOG");
        singles.add("SLOG");
        singles.add("SMOG");
        singles.add("TAGUE");
        singles.add("WAAG");
        singles.add("ZAUGG");
        singles.add("ZOGG");
        
        doubles.add("ACOG");
        doubles.add("AGOG");
        doubles.add("PARAG");
        doubles.add("PIROG");
        doubles.add("PROLOG");
        doubles.add("UNCLOG");
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

package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class House implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public House() {
        singles.add("BLOUSE");
        singles.add("BOUSE");
        singles.add("BROUSE");
        singles.add("CHAUS");
        singles.add("CLOUSE");
        singles.add("COUSE");
        singles.add("CROUSE");
        singles.add("DOUSE");
        singles.add("DOWSE");
        singles.add("FOUSE");
        singles.add("GAUSS");
        singles.add("GROUSE");
        singles.add("HAUS");
        singles.add("HAUSS");
        singles.add("KLAUS");
        singles.add("KNOUSE");
        singles.add("KRAUS");
        singles.add("KROUSE");
        singles.add("LOUSE");
        singles.add("MOUSE");
        singles.add("PROUSE");
        singles.add("ROUSE");
        singles.add("ROUSSE");
        singles.add("SCHAUS");
        singles.add("SHOUSE");
        singles.add("SMOUSE");
        singles.add("SPOUSE");
        singles.add("SPROUSE");
        singles.add("STRAUSS");
        singles.add("STROUSE");
        singles.add("YOUSE");

        doubles.add("BOATHOUSE");
        doubles.add("BATHHOUSE");
        
        triples.add("THEREABOUTS");

        singles.add("OUTS");
        singles.add("SPROUTS");
        singles.add("DROUGHTS");

        doubles.add("ESPOUSE");
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

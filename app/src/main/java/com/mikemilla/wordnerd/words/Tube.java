package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Tube implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Tube() {
        singles.add("BOOB");
        singles.add("CUBE");
        singles.add("DUBE");
        singles.add("GRUBE");
        singles.add("HUBE");
        singles.add("KOOB");
        singles.add("KUBE");
        singles.add("LUBE");
        singles.add("LUEBBE");
        singles.add("RUBE");
        singles.add("RUEB");
        singles.add("SHOOB");
        singles.add("STRUBE");
        singles.add("STUEBE");
        singles.add("TROUBH");
        singles.add("ZUBE");
        singles.add("GALOOB");
        singles.add("COOP");
        singles.add("COUPE");
        singles.add("CROUP");
        singles.add("DROOP");
        singles.add("DRUPE");
        singles.add("DUPE");
        singles.add("GOOP");
        singles.add("GROUP");
        singles.add("HOOP");
        singles.add("LOOP");
        singles.add("LOUP");
        singles.add("LOUPE");
        singles.add("OOP");
        singles.add("POOP");
        singles.add("SCOOP");
        singles.add("SLOOP");
        singles.add("SNOOP");
        singles.add("SOUP");
        singles.add("STOOP");
        singles.add("STOUP");
        singles.add("SWOOP");
        singles.add("TROOP");
        singles.add("TROUPE");
        singles.add("WHOOP");
        
        triples.add("GUADELOUPE");
        
        singles.add("NOOB");
        singles.add("PUBE");
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
